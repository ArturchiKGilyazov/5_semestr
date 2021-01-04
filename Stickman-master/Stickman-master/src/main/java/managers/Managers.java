package managers;

import lobby.Lobby;
import lobby.Lobby_I;

public class Managers {

    public Managers(){
    }
    private static final UserManager_I userManager = UserManager.getInstance();
    private static final GameManager_I gameManager = GameManager.getInstance();
    private static final FriendManager_I friendManager = FriendManager.getInstance();
    private static final Lobby_I Lobby = lobby.Lobby.getInstance();

    public static FriendManager_I getFriendManager() {
        return friendManager;
    }

    public static GameManager_I getGameManager() {
        return gameManager;
    }

    public static UserManager_I getUserManager() {
        return userManager;
    }

    public static Lobby_I getLobby() {
        return Lobby;
    }
}
