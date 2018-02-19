package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static networking.Commands.addPlayer;
import static networking.Commands.breakOp;

/**
 * Opens a client-side socket and attempts to connect to a specified server.
 * @author Chris Cardus
 */
public class SocketClient {

    String username;
    int avatar;

	/**
	 * Open a socket and attempt to connect to a server.
	 * @param address User specified IP address of a server.
	 * @param port User specified port on the server.
	 */
	public void connect(InetAddress address, int port, String username/*, Avatars avatar*/) {
        System.out.println("Connect");
        this.username = username;
        this.openSocket(address, port);
	    //this.avatar = avatar.toInt();
	}
	
	/**
	 * Open a socket and attempt to connect to a server.
	 * Uses the default port 49100.
	 * @param address User specified IP address of a server.
	 */
	public void connect(InetAddress address, String username/*, Avatars avatar*/) {
		int defaultPort = 49100;
        this.username = username;
        System.out.println("Connect");
        this.openSocket(address, defaultPort);
        //this.avatar = avatar.toInt();
	}
	
	/**
	 * Opens a socket and attempts to connect to the specified server.
	 * @param address The IP address of the server.
	 * @param port A port number on that server.
	 */
	private void openSocket(InetAddress address, int port) {
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
			boolean init = false;
			
			while((inLine = in.readLine()) != null) {

                System.out.println("Waiting for server");

			    if(init = false) {
			        outLine = addPlayer+breakOp+username+breakOp+avatar+breakOp;
			        out.println(outLine);
			        init = true;
                }

				if(inLine == Commands.stop) {
                    break;
                }
			}
		} catch(IOException e) {
			System.err.println("There is an error with the connection: " + e);
		}
	}
	
}
