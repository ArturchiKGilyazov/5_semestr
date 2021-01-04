package friend;

import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;

public class Friend implements ProtobufSerializable {
    private final int id;
    private final String name;
    private final int trophies;

    public Friend(int _id, String _name, int _trophies) {
        id = _id;
        name = _name;
        trophies = _trophies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTrophies() {
        return trophies;
    }

    @Override
    public MessageLite Serialize() {
        return null;
    }
}
