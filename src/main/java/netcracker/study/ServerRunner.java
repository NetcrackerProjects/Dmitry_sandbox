package netcracker.study;

import java.io.IOException;

public class ServerRunner {
    public static void main(String[] args) {
        Server server = new Server(5656);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
