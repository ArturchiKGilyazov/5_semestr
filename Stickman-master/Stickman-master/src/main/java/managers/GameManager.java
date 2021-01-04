package managers;

import server.Updatable_I;
import game.Game;
import user.User;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager implements Updatable_I, GameManager_I{

    private static final GameManager_I Instance = new GameManager();
    public static GameManager_I getInstance(){ return Instance;}
    private GameManager(){}

    private final Map<Integer, Game> OnlineGames = new ConcurrentHashMap<>();

    public synchronized Game GetGame(int game_id) throws NoSuchElementException{
        return OnlineGames.entrySet().stream().filter(e -> e.getKey().equals(game_id)).findFirst().get().getValue();
    }

    synchronized Game GetGame(User user) throws NoSuchElementException {
        int user_id = user.getId();
        return OnlineGames.values().stream().filter(game -> game.hasUser(user_id)).findFirst().get();
    }

    public synchronized void AddGame(Game game){
        OnlineGames.put(game.getId(), game);
    }

    @Override
    public void update() {

    }

    public void RemoveGame(){

    }
}
