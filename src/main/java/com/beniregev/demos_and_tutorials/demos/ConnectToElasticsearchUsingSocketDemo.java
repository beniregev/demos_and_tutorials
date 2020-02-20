package com.beniregev.demos_and_tutorials.demos;

import java.io.IOException;
import java.net.Socket;

public class ConnectToElasticsearchUsingSocketDemo {
    private String hostname = "localhost";
    private int port = 9600;
    private Socket clientSocket;

    public boolean open() {
        try {
            clientSocket = new Socket(hostname, port);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
            return false;
        }
        return true;

    }

    public boolean close() {
        try {
            clientSocket.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ConnectToElasticsearchUsingSocketDemo demo = new ConnectToElasticsearchUsingSocketDemo();
        boolean result = demo.open();
        if (result) System.out.println("Connection to Elasticsearch on hostname \"localhost\" and port 9600 IS OPEN");
        result = demo.close();
        if (result) System.out.println("Connection to Elasticsearch on hostname \"localhost\" and port 9600 is CLOSED");
    }

}
