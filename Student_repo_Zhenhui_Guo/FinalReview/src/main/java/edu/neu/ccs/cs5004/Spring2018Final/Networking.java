package edu.neu.ccs.cs5004.Spring2018Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Networking {
  public static void main(String[] args) {
    int count = 0;
    final int portNumber = Integer.parseInt(args[0]);
    try(ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
        PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inClient = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
    ) {
      String inputLine;
      while((inputLine = inClient.readLine())!= null) {
        count ++;
        System.out.println("Received: " + inputLine + "hashcode:" + inputLine.hashCode());

        if (count % 5  == 0) {
          outClient.println("Could you please repeat that message?");
        } else {
          outClient.println("I heard you, thanks");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void client(String hostName, int portNumber) {
    try(Socket socket = new Socket(hostName, portNumber);
      PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    ) {
      String userInput;
      while ((userInput = stdIn.readLine()) != null) {
        outServer.println(userInput);
        System.out.println("Server said: " + inServer.readLine());
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
