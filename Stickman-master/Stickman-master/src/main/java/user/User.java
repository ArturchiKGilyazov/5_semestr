package user;

import server.ProtobufSerializable;
import friend.Friend;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import proto_files.DangerStickman;
import proto_files.UserMessages;

import java.util.*;

public class User implements ProtobufSerializable {

    private final int id;
    private String name;
    private USER_STATUS Status;
    private ChannelHandlerContext channelHandlerContext;
    private int money = 0;
    private int trophies = 0;
    private int count_win = 0;
    private int count_loss = 0;

    private final List<Integer> skins = new ArrayList<>();

    private final List<Friend> friends = new ArrayList<>();

    private final List<Friend> inboundRequestsForFriend = new ArrayList<>();

    private final List<Friend> outgoingRequestsForFriend = new ArrayList<>();

    public User(){
        id = 0;
    }

    public User(int _id, String _name){
        id = _id;
        name = _name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    void setStatus(USER_STATUS status){
        Status = status;
    }

    USER_STATUS getStatus(){
        return Status;
    }

    void setChannelHandlerContext(ChannelHandlerContext chx){
        channelHandlerContext = chx;
    }

    public void send(DangerStickman.PacketWrapper msg){
        channelHandlerContext.write(msg);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getCount_win() {
        return count_win;
    }

    public void setCount_win(int count_win) {
        this.count_win = count_win;
    }

    public int getCount_loss() {
        return count_loss;
    }

    public void setCount_loss(int count_loss) {
        this.count_loss = count_loss;
    }

    private void updateFriends(){

    }

    private void addFriend(){

    }

    public List<Friend> GetFriendList(){
        return null;
    }

    private void updateInboundRequestsForFriend(){

    }

    public void ConfirmFriendship(){

    }

    @Override
    public MessageLite Serialize() {
        return UserMessages.user.newBuilder().setId(getId())
                .setName(getName())
                .setMoney(getMoney())
                .setTrophies(getTrophies()).build();
    }

}