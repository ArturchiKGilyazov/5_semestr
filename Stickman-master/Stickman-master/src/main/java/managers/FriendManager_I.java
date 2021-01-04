package managers;

import friend.Friend;
import user.User;

import java.util.List;

public interface FriendManager_I {

    List<Friend> GetFriends();

    Friend GetFriend(User user);

    void AddFriend(User user);

    void AddFriend(int user_id);

    void RemoveFriend(int user_id);

}
