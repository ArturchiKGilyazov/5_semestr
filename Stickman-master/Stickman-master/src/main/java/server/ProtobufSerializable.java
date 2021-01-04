package server;

import com.google.protobuf.MessageLite;

public interface ProtobufSerializable {

    MessageLite Serialize();

}
