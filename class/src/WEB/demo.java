package WEB;
import java.net.*;
import java.util.Scanner;

public class demo {
	public static void main(String[] args) {
		String add="";
		try {
			System.out.print("«Î ‰»Îµÿ÷∑");
			Scanner sca=new Scanner(System.in);
			add=sca.nextLine();
			InetAddress address=InetAddress.getByName(add);
			System.out.println("Host name:"+address.getHostName());
			System.out.println("IP address:"+address.getHostAddress());
			sca.close();
		}
		catch(UnknownHostException ex) {
			System.err.println("Unknown host or IPaddress"+add);
		}
	}
}
