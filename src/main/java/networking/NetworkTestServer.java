package networking;

import gamelogic.MultiplayerServer;

import static networking.Commands.defaultPort;

public class NetworkTestServer {

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        MultiplayerServer game = new MultiplayerServer();
        System.out.println("Socket Created");
        server.startServer(defaultPort, game);
        System.out.println("End");
    }
}
