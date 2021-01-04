package game;

import java.util.NoSuchElementException;

public interface Game_I {
    Player GetPlayer(int player_id) throws NoSuchElementException;
}
