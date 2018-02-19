package gamelogic;

import graphics.Avatars;
import networking.SocketServer;

public class Multiplayer {
	private Player[] Players;
	private int numberOfPlayers = 0;
	private SocketServer server = new SocketServer();
	
	public void startServer(int port) {
		server.startServer(port);
	}
	
	public void addPlayer(String username, Avatars avatar) {
		Player player = new Player(username, numberOfPlayers, avatar);
		Players[numberOfPlayers] = player;
		numberOfPlayers++;
		if(numberOfPlayers > 9) {
			server.stopListening();
		}
	}
	
	public int getLastID() {
		return (numberOfPlayers - 1);
	}
}
