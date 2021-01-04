package game;

import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;
import proto_files.GameMessages;

public class Player extends Player_A implements ProtobufSerializable {
    private final int id;
    private final String name;
    private int Health = 100;
    private int skin_id;
    private GameMessages.PlayerStatus Status = GameMessages.PlayerStatus.ALIVE;

    private PlayerPosition PlayerPosition;

    Player(int _id, String _name, int _skin_id, boolean isFirstPlayer /*for pick right start position*/){
        id = _id;
        name = _name;
        skin_id = _skin_id;
    }

    public PlayerPosition getPlayerPosition() {
        return PlayerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        PlayerPosition = playerPosition;
    }

    @Override
    public void addDamage(int damage) {
        Health-=damage;
    }

    @Override
    public void addHealth(int health) {
        Health+=health;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHealth() {
        return Health;
    }

    public GameMessages.PlayerStatus getStatus() {
        return Status;
    }

    public void setStatus(GameMessages.PlayerStatus status) {
        Status = status;
    }

    public boolean checkIfPlayerAlive(){
        return Health>0;
    }

    @Override
    public MessageLite Serialize() {
        return GameMessages.Player.newBuilder()
                .setId(getId())
                .setPlayerPosition((GameMessages.PlayerPosition) getPlayerPosition().Serialize())
                .setName(getName())
                .setPlayerHealth(getHealth())
                .setPlayerStatus(getStatus()).build();
    }

}
