package com.networking;

import com.gamelogic.MultiplayerServer;

import static com.networking.Commands.defaultPort;

public class NetworkTestServer {

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        MultiplayerServer game = new MultiplayerServer();
        System.out.println("Socket Created");
        server.startServer(defaultPort, game);
        System.out.println("End");
    }
}
