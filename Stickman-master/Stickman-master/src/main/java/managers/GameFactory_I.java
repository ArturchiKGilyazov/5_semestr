package managers;

import game.Game;
import lobby.Room;

public interface GameFactory_I {

    Game createGame(Room room);

}