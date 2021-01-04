package request_type;

import com.google.protobuf.MessageLite;
import com.sun.tools.javac.util.List;
import exceptions.UnknownTypeOfRequest;
import lobby.Room;
import proto_files.DangerStickman;

public class LobbyRequests implements LobbyRequests_I {

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.LobbyWrapper request = (DangerStickman.PacketWrapper.LobbyWrapper) _request;

        if(request.hasUpdateRoomsRequest()){

        }

        throw new UnknownTypeOfRequest();
    }

    List<Room> GetListOfRooms(){
        return null;
    }

}
