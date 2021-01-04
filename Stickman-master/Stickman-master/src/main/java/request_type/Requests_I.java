package request_type;

import com.google.protobuf.MessageLite;
import exceptions.UnknownTypeOfRequest;
import proto_files.DangerStickman;

public interface Requests_I {

    DangerStickman.PacketWrapper execute(MessageLite request) throws UnknownTypeOfRequest;

}
