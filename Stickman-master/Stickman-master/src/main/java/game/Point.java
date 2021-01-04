package game;

import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;
import proto_files.GameMessages;

public class Point implements ProtobufSerializable {
    private float x;
    private float y;

    Point(GameMessages.Point point){
        x = point.getX();
        y = point.getY();
    }

    Point(float _x, float _y){
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public MessageLite Serialize() {
        return GameMessages.Point.newBuilder().setX(getX()).setY(getY()).build();
    }
}