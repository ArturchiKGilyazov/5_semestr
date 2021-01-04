package lobby;

import exceptions.NoAvailableIDException;
import exceptions.NoSuchRoomException;
import exceptions.UserAreNotAdmin;
import user.User;

import java.util.List;

public interface Lobby_I {

    Room GetRoom(int room_id) throws NoSuchRoomException;

    List<Room> GetAvailableRooms();

    Room CreateNewRoom(User user) throws NoAvailableIDException;

    void StartRoom(User admin, int room_id) throws NoSuchRoomException, UserAreNotAdmin;
}