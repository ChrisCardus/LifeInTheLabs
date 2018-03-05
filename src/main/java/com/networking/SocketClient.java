package com.networking;

import com.gamelogic.MultiplayerClient;
import com.graphics.Avatars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static com.networking.Commands.*;

/**
 * Opens a client-side socket and attempts to connect to a specified server.
 * @author Chris Cardus
 */
public class SocketClient extends Thread {

    private String username;
    // What you send to the server.
    private String outLine = "";

    // Send output to server.
    private PrintWriter out;

    MultiplayerClient game;

	/**
	 * Open a socket and attempt to connect to a server.
	 * @param address User specified IP address of a server.
	 * @param port User specified port on the server.
	 */
	public SocketClient(InetAddress address, int port, String username, MultiplayerClient game) {
        this.username = username;
        this.game = game;
        this.openSocket(address, port);
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
			// Read input from server.
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			this.out = new PrintWriter(clientSocket.getOutputStream(), true);
			// What you get from the server.
			String inLine = "";

            addPlayer(username);

			while((inLine = in.readLine()) != stop) {
                recieve(inLine);
			}
		} catch(IOException e) {
			System.err.println("There is an error with the connection: " + e);
		}
	}

    /**
     * Sends the specified general output to the server.
     * @param output A string of commands.
     */
    private void send(String output) {
        System.out.println("send Sending commands to server: " + output);
        out.println(output);
    }

    /**
     * Specifies a username and avatar to use for this client.
     * @param username User specified username.
     */
    private void addPlayer(String username) {
        outLine = addPlayer+username+breakOp;
        System.out.println("addPlayer Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    /**
     * Updates the health attribute of the current user.
     * @param newHealth The new value of the health attribute.
     */
    public void updateHealth(int newHealth) {
	    outLine = health+Integer.toString(newHealth)+breakOp;
        System.out.println("updateHealth Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    /**
     * Updates the education attribute of the current user.
     * @param newEducation The new value of the education attribute.
     */
    public void updateEducation(int newEducation) {
        outLine = education+Integer.toString(newEducation)+breakOp;
        System.out.println("updateEducation Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    /**
     * Updates the social attribute of the current user.
     * @param newSocial The new value of the social attribute.
     */
    public void updateSocial(int newSocial) {
        outLine = social+Integer.toString(newSocial)+breakOp;
        System.out.println("updateSocial Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    /**
     * Updates the money attribute of the current user.
     * @param newMoney The new value of the money attribute.
     */
    public void updateMoney(int newMoney) {
        outLine = money+Integer.toString(newMoney)+breakOp;
        System.out.println("updateMoney Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    public void updatePosition(int x, int y) {
        outLine = position+x+breakOp+y+breakOp;
        System.out.println("updatePosition Sending commands to server: " + outLine);
        out.println(outLine);
        outLine = "";
    }

    /**
     * Used to parse comands recieved from the server and perform actions based on the commands recieved.
     * @param inLine A string of commands.
     */
    private void recieve(String inLine) {
        String[] commands = inLine.split("-");

        if(commands[0].equals(globalPositionCompare)) {
            game.updateLocation(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
        }

        if(commands[0].equals(userIDCompare)) {
            game.setUserID(Integer.parseInt(commands[1]));
        }
    }

}
