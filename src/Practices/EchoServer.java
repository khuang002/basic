package Practices;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//to run together with EchoClient

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1080);
            while (true) {
                Thread thread = new Thread(new ServerThread(serverSocket.accept()));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class ServerThread implements Runnable {
        Socket client;

        public ServerThread(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String userIn;
                while ((userIn = in.readLine()) != null) {
                    System.out.println("Received from client: " + userIn);
                    out.println(userIn);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}