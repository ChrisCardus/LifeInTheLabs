package gamelogic;

import graphics.Avatars;
import networking.SocketServer;

public class MultiplayerServer {
    private Player[] players;
    private SocketServer server = new SocketServer();

    public void startServer(int port) {
        server.startServer(port, this);
    }

    public void addPlayer(int userID, String username, int avatar) {
        Player player = new Player(username, userID, Avatars.fromInt(avatar));
        players[userID] = player;
    }

    public void changeHealth(int userID, int newHealth) {
        players[userID].setHealth(newHealth);
    }

    public void changeEducation(int userID, int newEducation) {
        players[userID].setEducation(newEducation);
    }

    public void changeSocial(int userID, int newSocial) {
        players[userID].setSocial(newSocial);
    }

    public void changeMoney(int userID, int newMoney) {
        players[userID].setMoney(newMoney);
    }
}