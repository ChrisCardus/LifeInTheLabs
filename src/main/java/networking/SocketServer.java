package networking;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * The class SocketServer is for creating and maintaining an open socket that clients can connect to.
 * @author Chris Cardus
 */
public class SocketServer{
	
	// Determines if the server is listening for new clients.
	private boolean listening = true;
	
    /**
     * Starts a socket and listens for new clients.
     * @param port Specifies what port number to use.
     */
    public void startServer(int port) {
        System.out.println("Start Server");
        this.openSocket(port);
    }
    
    /**
     * Starts a socket and listens for new clients.
     * Uses the default port 49100.
     */
    public void startServer() {
        System.out.println("Start Server");
    	int defaultPort = 49100;
    	this.openSocket(defaultPort);
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
            	new ServerThread(serverSocket.accept()).start();
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

    /*public void send(String ouput) {
        ServerThread.send("Test");
    }*/
}