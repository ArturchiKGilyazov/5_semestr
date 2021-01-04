package managers;

import DB.FRIEND_DB;
import DB.FRIEND_DB_I;
import friend.Friend;
import user.User;

import java.util.List;

public class FriendManager implements FriendManager_I {

    private static final FriendManager Instance = new FriendManager();
    public static FriendManager_I getInstance(){ return Instance;};
    public FriendManager(){}

    private final FRIEND_DB_I FriendDB = new FRIEND_DB();

    @Override
    public List<Friend> GetFriends() {
        return null;
    }

    @Override
    public Friend GetFriend(User user) {
        return null;
    }

    @Override
    public void AddFriend(User user) {
    }

    @Override
    public void AddFriend(int user_id) {
    }

    @Override
    public void RemoveFriend(int user_id) {
    }

}
