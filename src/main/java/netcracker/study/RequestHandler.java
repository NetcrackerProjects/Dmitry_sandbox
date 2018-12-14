package netcracker.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String data;
            String threadName = Thread.currentThread().getName();
            System.out.println("Start handling connection in thread: " + threadName
                    + " from: " + socket.getInetAddress().getHostAddress()
                    + ":" + socket.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            while ((data = in.readLine()) != null) {
                System.out.println("data in thread " + threadName + ": " + data);
            }
        } catch (IOException e) {
            System.out.println("exception:" + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
