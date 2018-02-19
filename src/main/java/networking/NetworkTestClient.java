package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTestClient {
    public static void main(String[] args) {
        System.out.println("Client Connecting");
        SocketClient client = new SocketClient();
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        client.connect(ip, "test");
    }
}
