package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Opens a client-side socket and attempts to connect to a specified server.
 * @author Chris Cardus
 */
public class SocketClient {

	/**
	 * Open a socket and attempt to connect to a server.
	 * @param address User specified IP address of a server.
	 * @param port User specified port on the server.
	 */
	public void connect(String address, int port) {
		this.openSocket(address, port);
	}
	
	/**
	 * Open a socket and attempt to connect to a server.
	 * Uses the default port 49100.
	 * @param address User specified IP address of a server.
	 */
	public void connect(String address) {
		int defaultPort = 49100;
		this.openSocket(address, defaultPort);
	}
	
	/**
	 * Opens a socket and attempts to connect to the specified server.
	 * @param address The IP address of the server.
	 * @param port A port number on that server.
	 */
	private void openSocket(String address, int port) {
		try {
			// Create a client side socket.
			Socket clientSocket = new Socket(address, port);
			// Send output to server.
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			// Read input from server.
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// What you get from the server.
			String inLine = "";
			// What you send to the server.
			String outLine = "";
			
			while((inLine = in.readLine()) != null) {
				
				if(inLine == Commands.stop) {
					break;
				}
			}
		} catch(IOException e) {
			System.err.println("There is an error with the connection: " + e);
		}
	}
	
}
