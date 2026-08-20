package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(HOST, PORT);

            System.out.println("Connected to server!");

            Scanner input = new Scanner(System.in);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                System.out.print("You: ");

                String message = input.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                output.println(message);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}