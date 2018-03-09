package com.gamelogic;

import com.networking.SocketClient;
import com.rendering.Boot;

import java.net.InetAddress;

import static com.rendering.Creator.quickLoad;

/**
 * Contains all the client-side code for playing a multiplayer game.
 * @author Chris Cardus
 */
public class MultiplayerClient {

    int[][] positions = new int[10][2];
    int userID = -1;
    String username;
    SocketClient client;
    Boot boot;
    Player player;

    /**
     * Creates a new client socket and attempts to connect to a server.
     * @param address The IP address of the server.
     * @param port The port which the server is running through.
     * @param username The username of the player.
     */
    public MultiplayerClient(InetAddress address, int port, String username) {
        for(int i = 0; i < 10; i++) {
            positions[i][0] = 9;
            positions[i][1] = 6;
        }
        this.username = username;
        client = new SocketClient(address, port, username, this);
        while(userID == -1) {
            //wait for userID to be returned by the server.
        }
        this.player = new Player(username, userID);
        boot = new Boot(player);
    }

    /**
     * Updates the position of the specified player.
     * @param userID The user who has moved.
     * @param x The new x coordinate.
     * @param y The new y coordinate.
     */
    public void updateLocation(int userID, int x, int y) {
        positions[userID][0] = x;
        positions[userID][1] = y;
    }

    /**
     * Updates the position of the current player.
     * @param x The new x coordinate.
     * @param y The new y coordinate.
     */
    public void updatePosition(int x, int y) {
        updateLocation(userID, x, y);
        client.updatePosition(x, y);
    }

    /**
     * Sets the userID of the client.
     * @param userID The new userID.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Sets the score of the client.
     * @param score The new score.
     */
    public void updateServerScore(int score) {
        client.updateScore(score);
    }
}