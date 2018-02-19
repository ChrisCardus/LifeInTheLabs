package networking;

public class NetworkTestServer {

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        System.out.println("Socket Created");
        server.startServer();
        System.out.println("End");
    }
}
