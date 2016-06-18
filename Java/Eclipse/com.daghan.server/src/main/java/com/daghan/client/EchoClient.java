package com.daghan.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws IOException {

		String serverHostname = new String("192.168.1.150");
		//String serverHostname = new String("127.0.0.1");

		if (args.length > 0)
			serverHostname = args[0];
		//System.out.println("Attemping to connect to host " + serverHostname + " on port 8005.");
		//System.out.println("Attemping to connect to host " + serverHostname + " on port 10007.");
		System.out.println("Attemping to connect to host " + serverHostname + " on port 10008.");

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			//echoSocket = new Socket(serverHostname, 8005);
			//echoSocket = new Socket(serverHostname, 10007);
			echoSocket = new Socket(serverHostname, 10008);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("input: ");
		// As opposed to EchoServer, here the code is waiting a string from
		// command line. Logic is same, we wait in the beginning of the while
		// loop until the user writes something
		while ((userInput = stdIn.readLine()) != null) {
			// as soon as we receive something from the user we send it straight
			// to the server where it is listening on the other end, see
			// EchoServer
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(clientSocket.getInputStream()));
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			System.out.print("input: ");
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
