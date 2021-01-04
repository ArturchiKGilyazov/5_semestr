package request_type;

import com.google.protobuf.MessageLite;
import exceptions.UnknownTypeOfRequest;
import proto_files.DangerStickman;

public class UserRequests implements UserRequests_I{
    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.UserWrapper request = (DangerStickman.PacketWrapper.UserWrapper) _request;
        if(request.hasLoadUserRequest()){

        }
        if(request.hasUpdateUserRequest()){

        }
        throw new UnknownTypeOfRequest();
    }

    void LoadNewUser(){

    }

    void UpdateExistingUser(){

    }
}
