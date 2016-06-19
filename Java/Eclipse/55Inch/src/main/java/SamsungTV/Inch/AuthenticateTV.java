package SamsungTV.Inch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AuthenticateTV {
	String AuthenticateTV, ConnectTV;
	
	public void TVAuthenticate(String[] args) {
		
		System.out.println( "We will Authenticate to TV first!" );
		String serverHostname = new String("192.168.1.62");
		int serverPortNumber = 55000;
		
		System.out.println("Attempting to connect to host " + serverHostname + " on port - " + serverPortNumber);
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try 
			{
			echoSocket = new Socket(serverHostname, serverPortNumber);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			} 

		catch (UnknownHostException e) 
			{
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
			} 
		
		catch (IOException e) 
			{
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
			}
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

		System.out.print("Do you wish to Authenticate to Samsung TV - Yes / No : ");
			while ((userInput = stdIn.readLine()) != null) 
				{
				if (userInput = "Y")
					//out.println("$00, $13, $00, 'iphone.iapp.samsung', $38, $00, $64, $00, $10, $00,'MTkyLjE2OC4xLjYy', $10, $00,'TG91bmdSZW1vdGU=', $10, $00, 'Q2hyaXNOZXRsaW54');
					//                            App name                                           192.168.1.62                   LoungRemote                     ChrisNetlinx
					out.println("0x00 + 0x13 + 0x00 + 'iphone.iapp.samsung' + 0x38 + 0x00 + 0x64 + 0x00 + 0x10 + 0x00 + 'MTkyLjE2OC4xLjYy' + 0x10 + 0x00 + 'UmFzcFBpUmVtb3Rl' + 0x10 + 0x00 + 'UmFzcGJlcnJ5UGk=');
					//                            App name                                           192.168.1.62                   RaspPiRemote                     RaspberryPi

					System.out.println("echo: " + in.readLine());
					System.out.print("input: ");
    			}

    			out.close();
    			in.close();
    			stdIn.close();
    			echoSocket.close();
    		}
	}
