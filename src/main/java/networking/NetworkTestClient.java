package networking;

import graphics.Avatars;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static networking.Commands.defaultPort;

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
        Avatars avatar = new Avatars(1);
        client.connect(ip, defaultPort, "test", avatar);
    }
}
