package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Creates a new thread for each new client that connects.
 * @author Chris Cardus
 */
public class ServerThread extends Thread {
	// Initialise the socked variable
	private Socket socket = null;
	
	/**
	 * Creates a new thread to handle a new client.
	 * This is how the server handles multiple clients.
	 * @param socket A new socket object to handle the new client.
	 */
	public ServerThread(Socket socket) {
		super("ServerThread");
		this.socket = socket;
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
			String outLine = "";
			
			// While commands are coming from the server.
			while((inLine = in.readLine()) != null) {
				
			}
		} catch(IOException e) {
			System.out.println("Something went wrong with one of the server threads: " + e);
			e.printStackTrace();
		}
	}
}
