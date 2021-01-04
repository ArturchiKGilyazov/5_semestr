package managers;

import exceptions.NoSuchGameException;
import game.Game;

public interface GameManager_I {

    Game GetGame(int id) throws NoSuchGameException;

    void AddGame(Game game);

}
