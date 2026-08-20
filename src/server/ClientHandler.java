package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            while (true) {

                String message = input.readLine();

                if (message == null) {
                    break;
                }

                System.out.println("Client says: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}