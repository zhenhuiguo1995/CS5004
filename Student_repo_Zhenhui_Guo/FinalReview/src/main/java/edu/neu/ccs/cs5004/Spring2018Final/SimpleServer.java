package edu.neu.ccs.cs5004.Spring2018Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
  public static void main(String[] args) {
    int counter = 0;

    if (args.length != 1) {
      System.err.println("Usage: java SimpleServer <port number>");
      System.exit(1);
    }

    final int portNumber = Integer.parseInt(args[0]);
    System.out.println(portNumber);

    try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        Socket clientSocket = serverSocket.accept();
        PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inClient =
            new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
      String inputLine;
      while ((inputLine = inClient.readLine()) != null) {
        counter++;
        System.out.println("Received: " + inputLine + " and it’s hash code is: " + inputLine.hashCode());
        if(counter % 5 == 0)
          outClient.println("Can you please repeat the last message?");
        else
          outClient.println("I heard you, thanks.");
      }
    } catch (final IOException e) {
      System.out.println("Exception caught when trying to listen on port " + portNumber
          + " or listening for a connection");
      System.out.println(e.getMessage());
    }


  }
}
