package request_type;

import com.google.protobuf.MessageLite;
import exceptions.*;
import game.PlayerPosition;
import managers.Managers;
import proto_files.DangerStickman;
import proto_files.GameMessages;

import java.util.NoSuchElementException;

public class GameRequests implements GameRequests_I{

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.GameWrapper request = (DangerStickman.PacketWrapper.GameWrapper) _request;
        if(request.hasStartGameRequest()){
            try {
                StartGame(request.getStartGameRequest().getSelfId(), request.getStartGameRequest().getRoomId());
            } catch (NoSuchRoomException e) {
                e.printStackTrace();
            } catch (UserAreNotAdmin userAreNotAdmin) {
                userAreNotAdmin.printStackTrace();
            }
            catch(NoSuchUserException e){

            }
        }
        if(request.hasChangePlayerPosition()){
            try{
            ChangePlayerPosition(request.getChangePlayerPosition().getPlayerId(),
                    request.getChangePlayerPosition().getGameId(), request.getChangePlayerPosition().getNewPlayerPosition());
            } catch(NoSuchGameException | NoSuchPlayerException e){

            }
        }
        throw new UnknownTypeOfRequest();
    }

    void StartGame(int user_id, int game_id) throws NoSuchUserException, NoSuchRoomException, UserAreNotAdmin {
        Managers.getLobby().StartRoom(Managers.getUserManager().GetUser(user_id), game_id);
    }

    void ChangePlayerPosition(int user_id, int game_id, GameMessages.PlayerPosition position) throws NoSuchGameException, NoSuchPlayerException {
        Managers.getGameManager().GetGame(game_id).GetPlayer(user_id).setPlayerPosition(new PlayerPosition(position));
    }

}
