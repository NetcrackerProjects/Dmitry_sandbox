package netcracker.study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accept connection");
                new Thread(new RequestHandler(socket)).start();
            } catch (IOException e) {
                System.out.println("exception:" + e.getMessage());
            }
        }
    }
}
