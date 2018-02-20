package networking;

import graphics.Avatars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static networking.Commands.*;

/**
 * Opens a client-side socket and attempts to connect to a specified server.
 * @author Chris Cardus
 */
public class SocketClient {

    private String username;
    private int avatar;
    // What you send to the server.
    private String outLine = "";

	/**
	 * Open a socket and attempt to connect to a server.
	 * @param address User specified IP address of a server.
	 * @param port User specified port on the server.
	 */
	public void connect(InetAddress address, int port, String username, Avatars avatar) {
        System.out.println("Connect");
        this.username = username;
        this.avatar = Avatars.toInt(avatar);
        this.openSocket(address, port);
	}
	
	/**
	 * Open a socket and attempt to connect to a server.
	 * Uses the default port 49100.
	 * @param address User specified IP address of a server.
	 */
	public void connect(InetAddress address, String username, Avatars avatar) {
		int defaultPort = 49100;
        this.username = username;
        System.out.println("Connect");
        this.avatar = Avatars.toInt(avatar);
        this.openSocket(address, defaultPort);
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
			boolean init = false;
			
			while((inLine = in.readLine()) != null) {

                System.out.println("Waiting for server");

                recieve(inLine);

			    if(init = false) {
                    addPlayer(username, avatar);
                    out.println(outLine);
                    outLine = "";
                    init = true;
                }

                if(outLine != "") {
			        out.println(outLine);
			        outLine = "";
                }

				if(inLine == Commands.stop) {
                    break;
                }
			}
		} catch(IOException e) {
			System.err.println("There is an error with the connection: " + e);
		}
	}

    private void send(String output) {
        outLine = output;
    }

    private void addPlayer(String username, int avatar) {
        outLine = addPlayer+username+breakOp+avatar+breakOp;
    }

    public void updateHealth(int newHealth) {
	    outLine = health+Integer.toString(newHealth)+breakOp;
    }

    public void updateEducation(int newEducation) {
        outLine = education+Integer.toString(newEducation)+breakOp;
    }

    public void updateSocial(int newSocial) {
        outLine = social+Integer.toString(newSocial)+breakOp;
    }

    public void updateMoney(int newMoney) {
        outLine = money+Integer.toString(newMoney)+breakOp;
    }

    private void recieve(String inLine) {

    }

}
