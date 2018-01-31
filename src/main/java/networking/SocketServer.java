package networking;

import java.io.*;
import java.net.*;
/**
 * The class SocketServer is for creating and maintaining an open socket that clients can connect to.
 * @author Chris Cardus
 */
public class SocketServer{
    // The default port that the server will use, unless a different port is specified by the user.
    int defaultPort = 49100;

    /**
     * @param port Specifies what port number to use. If none specified, use the default of 49100.
     * @throws Exception This method throws an exception if there is an error with the network connection.
     */
    public static void main(String args[]){
        // Catch any network errors that might occur.
        try {
            // If there is one or more arguments, the first argument will be a new port number, so use that to create the server socket. If there are no arguments, use the default port number.
            if(args.length >= 1) {
                ServerSocket serverSocket = new ServerSocket(args[1]);
            } else {
                ServerSocket serverSocket = new ServerSocket(defaultPort);
            }

            while (true) {
                Socket socket = ServerSocket.accept();
            }

        } catch (IOException e) {
            System.out.println("There is an error with the connection: "+e);
        }
    }
}