package networking;

import gamelogic.MultiplayerServer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * The class SocketServer is for creating and maintaining an open socket that clients can connect to.
 * @author Chris Cardus
 */
public class SocketServer{
	
	// Determines if the server is listening for new clients.
	private boolean listening = true;
	private ServerThread[] threads = new ServerThread[10];
	private int counter = 0;
	private MultiplayerServer game;

    /**
     * Starts a socket and listens for new clients.
     * @param port Specifies what port number to use.
     */
    public void startServer(int port, MultiplayerServer game) {
        System.out.println("Start Server");
        this.openSocket(port);
    }
    
    /**
     * @param port Specifies what port to open the socket on.
     * @throws Exception This method throws an exception if there is an error with the socket.
     */
    private void openSocket(int port){
        // Catch any network errors that might occur.
        try {
            System.out.println("Openning Socket");
        	// Create the server socket.
            ServerSocket serverSocket = new ServerSocket(port);
            
            // Listen for new clients.
            while(listening) {
            	// Create a new thread to deal with each client that tries to connect.
                System.out.println("Listening");
            	threads[counter] = new ServerThread(serverSocket.accept(), counter, game);
            	threads[counter].start();
            	counter++;
            	if(counter >= 10) {
            	    this.stopListening();
                }
                System.out.println("Client Connected");
            }

        } catch (IOException e) {
            System.err.println("There is an error with socket: "+e);
        }
    }

    /**
     * Stops new clients from being able to connect to the server.
     */
    public void stopListening() {
        listening = false;
    }

    /**
     * Allows the server to listen for and connect to new clients.
     */
    public void startListening() {
        listening = true;
    }

    public void sendAll(String output) {
        for(int i = 0; threads[i] != null; i++) {
            threads[i].send(output);
        }
    }

    public void send(int userID, String output) {
        threads[userID].send(output);
    }
}