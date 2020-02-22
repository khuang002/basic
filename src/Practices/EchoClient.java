package Practices;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//to run together with EchoServer

public class EchoClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 1080;
//        System.out.println("Enter your input: ");
        Scanner userIn = new Scanner(System.in);
        try {
            Socket socket = new Socket(hostname, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput;
            System.out.println("Please enter: ");
            while (!"exit".equals(userInput = userIn.nextLine())) {
                out.println(userInput);
                System.out.println("Received from server: " + in.readLine());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}