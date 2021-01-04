package game;

import exceptions.NoSuchPlayerException;
import user.User;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Game implements Game_I {
    private GAME_STATUS status;

    private final List<Player> Players = new LinkedList<>();

    private final int Id;

    private int Damage = 0;
    private int Gravity = 0;
    private int Speed = 0;
    private int Bounce = 0;

    public void setDamage(int damage) {
        Damage = damage;
    }
    public void setGravity(int gravity) {
        Gravity = gravity;
    }
    public void setSpeed(int speed) {
        Speed = speed;
    }
    public void setBounce(int bounce) {
        Bounce = bounce;
    }

    Game(int game_id) {
        Id = game_id;
    }

    @Override
    public Player GetPlayer(int player_id) throws NoSuchPlayerException {
        try {
            return Players.stream().filter(e -> e.getId() == player_id).findFirst().get();
        }catch(NoSuchElementException e){throw new NoSuchPlayerException();}
    }

    void PlayerDisconnected(int player_id){
    }

    void CalculateDamage(){
    }

    void UpdatePlayerPosition(int player_id, Player player/*, new position*/){
    }

    public void AddPlayer(User user){
        //Invoke constructor
        //put player to players
    }

    public Game build(){
        return null;
    }

    public void start(){

    }

    public boolean hasUser(int user_id){
        return Players.stream().anyMatch(e -> e.getId() == user_id);
    }

    public GAME_STATUS getStatus() {
        return status;
    }

    public void setStatus(GAME_STATUS status) {
        this.status = status;
    }

    public int getId() {
        return Id;
    }
}