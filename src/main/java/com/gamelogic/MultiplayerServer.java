package com.gamelogic;

import com.graphics.Avatars;
import com.networking.SocketServer;
import com.rendering.Tile;

import static com.networking.Commands.breakOp;
import static com.networking.Commands.globalPosition;

import org.newdawn.slick.opengl.Texture;

/**
 * Contains the main code for the server to host a multiplayer game.
 * @author Chris Cardus
 */
public class MultiplayerServer {
    private Player[] players = new Player[10];
    private SocketServer server = new SocketServer();

    /**
     * Starts the SocketServer
     * @param port What port to use when starting the server.
     */
    public void startServer(int port) {
        server.startServer(port, this);
    }

    /**
     * Adds a new player to the game.
     * @param userID The ID assigned to the player.
     * @param username The username which the player specified.
     */
    public void addPlayer(int userID, String username) {
        Player player = new Player(username, userID);
        players[userID] = player;
        System.out.println("User " + userID + " added to the game.");
    }

    /**
     * Changes the score stat of the player.
     * @param userID The user ID of the player.
     * @param score The new score value.
     */
    public void updateScore(int userID, int score) {
        players[userID].setHighscore(score);
    }

    /**
     * Changes the x & y coordinates of the player. Also sends the updated coordinates to all other clients.
     * @param userID The user who has moved.
     * @param x The new x coordinate.
     * @param y The new y coordinate.
     */
    public void updatePosition(int userID, int x, int y) {
        players[userID].setPosition(x, y);
        server.sendAll(globalPosition+userID+breakOp+x+breakOp+y+breakOp);
    }
}