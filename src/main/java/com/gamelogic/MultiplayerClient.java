package com.gamelogic;

import com.networking.SocketClient;
import com.rendering.Boot;

import java.net.InetAddress;

import static com.rendering.Creator.quickLoad;

public class MultiplayerClient {

    int[][] positions = new int[10][2];
    int userID = -1;
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
        client = new SocketClient(address, port, username, this);
        while(userID == -1) {
            //wait for userID to
        }
        this.player = new Player(username, userID);
        boot = new Boot(player);
    }

    public void updateLocation(int userID, int x, int y) {
        positions[userID][0] = x;
        positions[userID][1] = y;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void serverHealth(int health) {
        client.updateHealth(health);
    }

    public void serverSocial(int social) {
        client.updateSocial(social);
    }

    public void serverEducation(int education) {
        client.updateEducation(education);
    }

    public void serverMoney(int money) {
        client.updateMoney(money);
    }
}