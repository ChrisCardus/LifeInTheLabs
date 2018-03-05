package com.networking;

import com.gamelogic.MultiplayerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.networking.Commands.*;

/**
 * Creates a new thread for each new client that connects.
 * @author Chris Cardus
 */
public class ServerThread extends Thread {
	// Initialise the socked variable
	private Socket socket = null;
	private int userID;
	private MultiplayerServer game;
	PrintWriter out;
	
	/**
	 * Creates a new thread to handle a new client.
	 * This is how the server handles multiple clients.
	 * @param socket A new socket object to handle the new client.
	 */
	public ServerThread(Socket socket, int userID, MultiplayerServer game) {
		super("ServerThread");
		this.socket = socket;
		this.userID = userID;
		this.game = game;
	}
	
	/**
	 * Create new threads for each new client.
	 */
	public void run() {
		
		try {
			// Send output to client.
			out = new PrintWriter(socket.getOutputStream(), true);
			// Read input from client.
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// What you get from the client.
			String inLine = "";
			
			// While commands are coming from the server.
			while((inLine = in.readLine()) != null) {
				recieve(inLine);
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
		System.out.println("Input recieved from client: "+input);
		String[] commands = input.split("-");

		for(int i = 0; i < commands.length; i++) {
		    System.out.println("commands["+i+"] == " + commands[i]);
        }

        if(commands[0].equals(addPlayerCompare)) {
		    game.addPlayer(userID, commands[1]);
		    send(Commands.userID+userID+breakOp);
        }

        if(commands[0].equals(healthCompare)) {
		    game.changeHealth(userID, Integer.parseInt(commands[1]));
        }

        if(commands[0].equals(educationCompare)) {
		    game.changeEducation(userID, Integer.parseInt(commands[1]));
        }

        if(commands[0].equals(socialCompare)) {
		    game.changeSocial(userID, Integer.parseInt(commands[1]));
        }

        if(commands[0].equals(moneyCompare)) {
		    game.changeMoney(userID, Integer.parseInt(commands[1]));
        }

        if(commands[0].equals(positionCompare)) {
		    game.updatePosition(userID, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        }
	}

	/**
	 * Sends the string of commands contained in output to the client.
	 * @param output A string of commands.
	 */
	public void send(String output) {
        out.println(output);
    }

}
