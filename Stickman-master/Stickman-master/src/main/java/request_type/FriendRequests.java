package request_type;

import DB.FRIEND_DB;
import exceptions.UnknownTypeOfRequest;
import managers.Managers;
import com.google.protobuf.MessageLite;
import friend.Friend;
import proto_files.DangerStickman;
import proto_files.FriendMessages;
import user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class FriendRequests implements FriendRequests_I{

    private final FRIEND_DB friendDB = new FRIEND_DB();

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.FriendWrapper request = (DangerStickman.PacketWrapper.FriendWrapper) _request;
        if(request.hasFindFriendsRequest()){

        }
        if(request.hasMakeFriendsRequest()){

        }
        if(request.hasConfirmationFriendsRequest()){

        }
        if(request.hasRemoveFriendRequest()){

        }
        if(request.hasUpdateFriendsListRequest()){

        }
        throw new UnknownTypeOfRequest();
    }

    private FriendMessages.FindFriendsResponse.Builder FindFriends(String find_query){
        List<Friend> finded = null;
        try {
            finded = friendDB.FindAllFriend(find_query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        FriendMessages.FindFriendsResponse.Builder builder = FriendMessages.FindFriendsResponse.newBuilder();
        finded.forEach(e -> builder.addFriends((FriendMessages.friend) e.Serialize()));
        return builder;
    }

    private void MakeRequestForFriend(Integer from, Integer to){
        friendDB.MakeRequestForFriend(from.toString(), to.toString());
        User toUser = null;
        User fromUser = null;
        try {
            toUser = Managers.getUserManager().GetUser(to);
            fromUser = Managers.getUserManager().GetUser(from);
        } catch (NoSuchElementException e){
            return;
        }
        toUser.send((DangerStickman.PacketWrapper) new Friend(fromUser.getId(), fromUser.getName(), fromUser.getTrophies()).Serialize());
    }

    private void GetConfirmationFromUser(){

    }

    private void RemoveFriend(Integer from, Integer to){
        try {
            friendDB.RemoveFriend(from.toString(), to.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        User fromUser = null;
        User toUser = null;
        try{
            fromUser = Managers.getUserManager().GetUser(from);
            //TODO logic
        } catch (NoSuchElementException e){

        }

        try{
            toUser = Managers.getUserManager().GetUser(to);
            //TODO logic
        } catch (NoSuchElementException e){

        }

    }

    private FriendMessages.UpdateFriendsListResponse.Builder UpdateFriendList(Integer for_user){

    }



}
