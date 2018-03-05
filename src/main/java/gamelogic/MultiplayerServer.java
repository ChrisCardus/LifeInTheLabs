package gamelogic;

import graphics.Avatars;
import networking.SocketServer;

import static networking.Commands.breakOp;
import static networking.Commands.globalPosition;

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
     * Changes the health attribute of the player.
     * @param userID The player who's health needs to change.
     * @param newHealth The new value for the health attribute.
     */
    public void changeHealth(int userID, int newHealth) {
        players[userID].setHealth(newHealth);
    }

    /**
     * Changes the education attribute of the player.
     * @param userID The player who's education needs to change.
     * @param newEducation The new value for the education attribute.
     */
    public void changeEducation(int userID, int newEducation) {
        players[userID].setEducation(newEducation);
    }

    /**
     * Changes the social attribute of the player.
     * @param userID The player who's social attribute needs to change.
     * @param newSocial The new value for the social attribute.
     */
    public void changeSocial(int userID, int newSocial) {
        players[userID].setSocial(newSocial);
    }

    /**
     * Changes the money attribute of the player.
     * @param userID The player who's money attribute needs to change.
     * @param newMoney The new value for the money attribute.
     */
    public void changeMoney(int userID, int newMoney) {
        players[userID].setMoney(newMoney);
    }

    public void updatePosition(int userID, int x, int y) {
        players[userID].setPosition(x, y);
        server.sendAll(globalPosition+userID+breakOp+x+breakOp+y+breakOp);
    }
}