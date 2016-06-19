import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientServer_Samsung_TV {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int TV_Input,TVReply;
		Scanner sc= new Scanner(System.in);
		Socket SamsungTVLounge = new Socket("192.168.1.106",55001);
		Scanner sc1 = new Scanner(SamsungTVLounge.getInputStream());
		System.out.println("Enter TV Input ");
		TV_Input = sc.nextInt();
		PrintStream p = new PrintStream(SamsungTVLounge.getOutputStream());
		p.println(TV_Input);
		TVReply = sc1.nextInt();
		System.out.println(TVReply);
	}

}
