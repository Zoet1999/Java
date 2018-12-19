package WEB;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Date;

public class udps {
	public static void main(String[] args) {
		try {
			byte[] buf=new byte[1024];
			DatagramSocket socket=new DatagramSocket(8888);
			System.out.println("Server stated on port 8888,"+new Date());
			
			DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);
			DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
					
			while(true) {
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);
				 
				System.out.println("Receieved packet from"+rcvPkt.getAddress().getHostAddress()+":"+rcvPkt.getPort());
				double d=Double.parseDouble(new String(buf));
				System.out.println("Double:"+d);
				String s=Double.valueOf(d).toString();
				System.out.println("double is "+d +" String is "+s);
				
				sndPkt.setAddress(rcvPkt.getAddress());
				sndPkt.setPort(rcvPkt.getPort());
				buf=s.getBytes();
				sndPkt.setData(buf,0,buf.length);
				socket.send(sndPkt);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
