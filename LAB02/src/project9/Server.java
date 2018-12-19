/**
 * 程序说明
 * 先运行Serverk.java,输入运行次数
 * 之后再运行 KidA.java 和KidB.java 这两个文件运行先后不影响
 *  KidA.java 和KidB.java 会显示送出的信息
 */



package project9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class Server {
	 public static void main(String[] args){
		 Object lock1=new Object();
		 Object lock2=new Object();
		
		System.out.println("请输入比较次数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Compare co=new Compare(n,lock1,lock2);
		TcpServerThread tcp=new TcpServerThread(co,n,lock1,lock2);
		UdpServerThread udp=new UdpServerThread(co,n,lock1,lock2);
		System.out.println("                Thread A                       Thread B");
		System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
		System.out.println("         time   character  obtained     time   character  obtained");
		tcp.start();
		udp.start();
		co.start();
	    }
}

class TcpServerThread extends Thread{
	private Compare co;
	int n;
	Object lock1;
	Object lock2;
	TcpServerThread(Compare co,int n,Object lock1,Object lock2){
		this.co=co;
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
    public void run() {
		try {
			ServerSocket server=new ServerSocket(8888);
			//System.out.println("Server stated on port 8888,"+new Date());
			Socket socket=server.accept();
			//  InetAddress inetAddress = socket.getInetAddress();
			//  System.out.println("tcp's host name is " + inetAddress.getHostName());
			//  System.out.println("tcp's IP Address is " + inetAddress.getHostAddress());
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			in.readInt();
			//System.out.println("tcp get link");
			out.writeInt(n);
			//System.out.println("tcp send n");
			for(int i=0;i<n;i++) {
				out.writeInt(0);
				co.setTimeA(in.readInt());
				//System.out.println("tcp get time");
				co.setA(in.readInt());
				//System.out.println("tcp get ch");
				
				synchronized(lock1) {
					lock1.notify();					
				}
				synchronized(lock2) {
					lock2.wait();						
				}
			}
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class UdpServerThread extends Thread{
	private Compare co;
	int n;
	Object lock1;
	Object lock2;
	UdpServerThread(Compare co,int n,Object lock1,Object lock2){
		this.co=co;
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
    public void run() {
		
		try {
			byte[] buf=new byte[1024];
			DatagramSocket socket=new DatagramSocket(8000);
			//System.out.println("udp Server stated on port 8000,"+new Date());
			DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);
			DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
			Arrays.fill(buf,(byte)0) ;
			rcvPkt.setData(buf);
			socket.receive(rcvPkt);
			//System.out.println("udp get link");
			
			sndPkt.setAddress(rcvPkt.getAddress());
			sndPkt.setPort(rcvPkt.getPort());
			Arrays.fill(buf, (byte)0);
			buf=Integer.valueOf(n).toString().getBytes();
			sndPkt.setData(buf);
			socket.send(sndPkt);
			//System.out.println("udp send n");
			for(int i=0;i<n;i++) {
				
				Arrays.fill(buf, (byte)0);
				buf="continue".getBytes();
				sndPkt.setData(buf);
				socket.send(sndPkt);
				
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);
				co.setTimeB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get time"+new String(buf).trim());
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);
				co.setB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get ch"+(new String(buf).trim()));
				synchronized(lock1) {
					lock1.notify();					
				}
				synchronized(lock2) {
					lock2.wait();				
				}
			}
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Compare extends Thread{
	int A=-1;
	int B=-1;
	String strA;
	String strB;
	int TimeA;
	int TimeB;
	int scoreA=0;
	int scoreB=0;
	int n=0;
	public void setA(int a) {
		A = a;
	}
	public void setB(int b) {
		B = b;
	}
	public void setTimeA(int timeA) {
		TimeA = timeA;
	}
	public void setTimeB(int timeB) {
		TimeB = timeB;
	}
	void showCompare(int i) {
	
			if(((A-B)==-1)||((A-B)==2)) {
				scoreA+=2;
			}else if(((A-B)==-2)||((A-B)==1)) {
				scoreB+=2;
			}
			else if(A==B) {
				scoreA++;
				scoreB++;
			}
			switch(A) {
			case 1: strA="Rock";break;
			case 2: strA="scissors";break;
			case 3: strA="paper";break;
			}
			switch(B) {
			case 1: strB="Rock";break;
			case 2: strB="scissors";break;
			case 3: strB="paper";break;
			}
			System.out.printf("%1$4d%2$8dms%3$8s%4$12d",(i+1),TimeA,strA,scoreA);
			System.out.printf("%1$8dms%2$8s%3$12d\n",TimeB,strB,scoreB);
	}
	Object lock1;
	Object lock2;
	Compare(int n,Object lock1,Object lock2){
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
	 public void run() {
		try {
			for(int i=0;i<n;i++) {
			synchronized(lock1) {
				lock1.wait();		
				lock1.wait();		
				showCompare(i);
			}
			synchronized(lock2) {
				lock2.notifyAll();					
			}	
			}
			if(scoreA>scoreB) {
				System.out.println("最终结果：A胜");
			}
			else if(scoreA<scoreB) {
				System.out.println("最终结果：B胜");
			}else {
				System.out.println("最终结果：平局");
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
