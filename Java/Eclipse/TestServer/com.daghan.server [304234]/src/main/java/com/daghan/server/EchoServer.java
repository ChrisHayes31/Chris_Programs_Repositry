package com.daghan.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;

		try {
			//serverSocket = new ServerSocket(8005);
			serverSocket = new ServerSocket(10007);
		} catch (IOException e) {
			//System.err.println("Could not listen on port: 8005.");
			System.err.println("Could not listen on port: 10007.");
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("Waiting for connection.....");

		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		System.out.println("Connection successful");
		System.out.println("Waiting for input.....");

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String inputLine;
		// here we go to infinite loop. Yet in.readLine() is blocking call, that
		// is it will wait until something is written to the stream. The other
		// end of the input stream here is the output stream on the EchoClient
		// See out = new PrintWriter(echoSocket.getOutputStream(), true);
		while ((inputLine = in.readLine()) != null) {
			System.out.println("Client says: " + inputLine);
			out.println(inputLine);
			// if the text coming from Client is "Bye." then we shut down the
			// server. Otherwise, we go back to the beginning of the while loop
			// and continue waiting for another message
			if (inputLine.equals("Bye."))
				break;
		}

		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
