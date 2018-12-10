package WEB;

import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class udpc {
	public static void main(String[] args) {
	
		byte[] buf=new byte[1024];
		InetAddress server;
	
		DatagramPacket sndPkt;
		
		DatagramPacket rcvPkt;

		try(DatagramSocket socket=new DatagramSocket()){
			server=InetAddress.getByName("localhost");
			sndPkt=new DatagramPacket(buf,buf.length);
			sndPkt.setAddress(server);
			sndPkt.setPort(8000);
			System.out.println("Please enter a double:");
			Scanner scanner=new Scanner(System.in);
			double d =scanner.nextDouble();
			Arrays.fill(buf, (byte)0);
			buf=Double.valueOf(d).toString().getBytes();
			sndPkt.setData(buf);
			socket.send(sndPkt);
			
			buf=new byte[1024];
			rcvPkt=new DatagramPacket(buf,buf.length);
			socket.receive(rcvPkt);
		
			String s=new String(buf).trim();
			
			
			System.out.println("double is "+d +" String is "+s);
			scanner.close();
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
