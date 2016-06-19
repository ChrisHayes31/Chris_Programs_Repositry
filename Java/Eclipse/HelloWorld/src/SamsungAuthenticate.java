import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SamsungAuthenticate {

	public static void main(String[] args) {
		int TV_Input,TVReply;
		String TV_Code;
		Scanner sc= new Scanner(System.in);
		Socket SamsungTVLounge = new Socket("192.168.1.62",5500);
		Scanner sc1 = new Scanner(SamsungTVLounge.getInputStream());
		System.out.println("Press Enter to conect to Samsung TV ");
		TV_Code = $00, $13, $00, "iphone.iapp.samsung", $38, $00, $64, $00, $10, $00, "MTkyLjE2OC4xLjYy", $10, $00, "TG91bmdSZW1vdGU=", $10, $00, "Q2hyaXNOZXRsaW54" 
				
				
				
				sc.nextInt();
		PrintStream p = new PrintStream(SamsungTVLounge.getOutputStream());
		p.println(TV_Input);
		TVReply = sc1.nextInt();
		System.out.println(TVReply);

	}

}
