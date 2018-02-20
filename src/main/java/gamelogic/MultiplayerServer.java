package gamelogic;

import graphics.Avatars;
import networking.SocketServer;

/**
 * Contains the main code for the server to host a multiplayer game.
 * @author Chris Cardus
 */
public class MultiplayerServer {
    private Player[] players;
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
     * @param avatar The avatar which the player selected.
     */
    public void addPlayer(int userID, String username, int avatar) {
        Player player = new Player(username, userID, Avatars.fromInt(avatar));
        players[userID] = player;
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
}