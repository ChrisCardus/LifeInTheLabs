package com.gamelogic;

import com.networking.SocketClient;
import com.rendering.Boot;

import java.net.InetAddress;

import static com.rendering.Creator.quickLoad;

public class MultiplayerClient {

    int[][] positions = new int[10][2];
    int userID;
    String username;
    SocketClient client;
    Boot boot;
    Player player;

    public MultiplayerClient(InetAddress address, int port, String username) {
        for(int i = 0; i < 10; i++) {
            positions[i][0] = 9;
            positions[i][1] = 6;
        }
        this.username = username;
        //this.player = new Player(quickLoad("player"), username)
        client = new SocketClient(address, port, username, this);
        //boot = new Boot();
    }

    public void updateLocation(int userID, int x, int y) {
        positions[userID][0] = x;
        positions[userID][1] = y;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}