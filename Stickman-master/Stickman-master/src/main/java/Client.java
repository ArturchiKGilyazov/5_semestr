import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    void run(){
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(InetAddress.getByName("localhost"), 32));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.getOutputStream().write(new String("Hello").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
