package gamelogic;

import networking.SocketClient;

import java.net.InetAddress;

public class MultiplayerClient {

    int[][] positions = new int[10][2];
    int userID;
    String username;
    SocketClient client;

    public MultiplayerClient(InetAddress address, int port, String username) {
        for(int i = 0; i < 10; i++) {
            positions[i][0] = 9;
            positions[i][1] = 6;
        }
        this.username = username;
        client = new SocketClient(address, port, username, this);
    }

    public void updateLocation(int userID, int x, int y) {
        positions[userID][0] = x;
        positions[userID][1] = y;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}