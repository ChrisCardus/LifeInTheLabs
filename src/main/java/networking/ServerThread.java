package networking;

import gamelogic.MultiplayerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static networking.Commands.addPlayer;

/**
 * Creates a new thread for each new client that connects.
 * @author Chris Cardus
 */
public class ServerThread extends Thread {
	// Initialise the socked variable
	private Socket socket = null;
	String outLine;
	
	/**
	 * Creates a new thread to handle a new client.
	 * This is how the server handles multiple clients.
	 * @param socket A new socket object to handle the new client.
	 */
	public ServerThread(Socket socket) {
		super("ServerThread");
		this.socket = socket;
		System.out.println("Start Server");
	}
	
	/**
	 * Create new threads for each new client.
	 */
	public void run() {
		
		try {
			// Send output to client.
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			// Read input from client.
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// What you get from the client.
			String inLine = "";
			// What you send to the client.
			outLine = "";
			
			// While commands are coming from the server.
			while((inLine = in.readLine()) != null) {
				recieve(inLine);
				if(outLine != "") {
				    out.println(outLine);
				    outLine = "";
                }
			}
		} catch(IOException e) {
			System.out.println("Something went wrong with one of the server threads: " + e);
			e.printStackTrace();
		}
	}

    /**
     * Used to parse the input from the client associated with each thread.
     * @param input The input from the client.
     */
	private void recieve(String input) {
		String[] commands = input.split("-");

		if(commands[0] == addPlayer) {
		    MultiplayerServer.addPlayer(commands[1], commands[2]);
        }
	}

	public void send(String output) {
        outLine = output;
    }

}
