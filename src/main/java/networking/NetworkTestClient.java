package networking;

import gamelogic.MultiplayerClient;
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
        MultiplayerClient game = new MultiplayerClient();
        client.connect(ip, defaultPort, "test", avatar, game);
        System.out.println("Attempting to change x to 3 and y to 4...");
        client.updatePosition(3, 4);
        System.out.println("Attempting to change x to 7 and y to 6...");
        client.updatePosition(7, 6);
    }
}
