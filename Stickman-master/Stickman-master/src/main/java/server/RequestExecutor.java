package server;

import proto_files.DangerStickman;
import request_type.*;

public class RequestExecutor implements RequestExecutor_I{

    private final UserRequests_I userRequests = new UserRequests();
    private final GameRequests_I gameRequests = new GameRequests();
    private final FriendRequests_I friendRequests = new FriendRequests();
    private final RoomRequests_I roomRequests = new RoomRequests();
    private final LobbyRequests_I lobbyRequests = new LobbyRequests();
    public DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request) {

        DangerStickman.PacketWrapper.Builder response = DangerStickman.PacketWrapper.newBuilder();

        if(request.hasUser()){
            userRequests.execute(request.getUser());
        }
        if(request.hasRoom()){
            roomRequests.execute(request.getRoom());
        }
        if(request.hasLobby()){
            lobbyRequests.execute(request.getLobby());
        }
        if(request.hasFriend()){
            friendRequests.execute(request.getFriend());
        }
        if(request.hasGame()){
            gameRequests.execute(request.getGame());
        }

        return response.build();
    }

}
