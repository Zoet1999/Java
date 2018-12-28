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
		 Object lock1=new Object();//锁1
		 Object lock2=new Object();//锁2
		
		System.out.println("请输入比较次数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//得到循环次数
        //long t1=System.currentTimeMillis();
		Compare co=new Compare(n,lock1,lock2);
		TcpServerThread tcp=new TcpServerThread(co,n,lock1,lock2);
		UdpServerThread udp=new UdpServerThread(co,n,lock1,lock2);
		System.out.println("                  Kid A                          Kid B");//画出表头
		System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
		System.out.println("         time   character  obtained     time   character  obtained");
		tcp.start();//开始tcp服务器线程
		udp.start();//开始udp服务器线程
		co.start();//开始比较线程
		sc.close();
		//long t2=System.currentTimeMillis();
		//System.out.println("运行时间"+(t2-t1)+"ms");
	    }
}

class TcpServerThread extends Thread{
	/**
	 * tcp服务器线程，与接收tcp客户端的信息，并传入比较线程。
	 */
	private Compare co;//线程间共享数据的对象
	private int n;//比较次数
	private Object lock1;//同步锁1
	private Object lock2;//同步锁2
	TcpServerThread(Compare co,int n,Object lock1,Object lock2){
		/**
    	 * 有参构造函数，传入锁，共享数据的对象，循环次数
    	 */
		this.co=co;
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
    public void run() {
		try {
			ServerSocket server=new ServerSocket(8888);//初始ServerSocket端口为8888
			//System.out.println("Server stated on port 8888,"+new Date());
			Socket socket=server.accept();				//等待接受客户端
			//  InetAddress inetAddress = socket.getInetAddress();
			//  System.out.println("tcp's host name is " + inetAddress.getHostName());
			//  System.out.println("tcp's IP Address is " + inetAddress.getHostAddress());
			DataInputStream in=new DataInputStream(socket.getInputStream());	//初始化inputStream
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());//初始化outputStream
			
			out.writeInt(n);//传给客户端循环次数
			//System.out.println("tcp send n");
			for(int i=0;i<n;i++) {//循环n次
				out.writeInt(0);//传给客户端一个信息，代表可以开始生成随机数
				co.setTimeA(in.readInt());//等待接受客户端的传来的本次休眠时间
				//System.out.println("tcp get time");
				co.setA(in.readInt());//等待接受客户端的传来的出拳序号1：石头，2：剪刀，3：布
				//System.out.println("tcp get ch");
				
				synchronized(lock1) {
					lock1.notify();		//提醒线程compare开始比较			 
				}
				synchronized(lock2) {
					lock2.wait();		//等待线程compare比较结束
				}
			}
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class UdpServerThread extends Thread{
	private Compare co;//线程间共享数据的对象
	private int n;//比较次数
	private Object lock1;//同步锁1
	private Object lock2;//同步锁2
	UdpServerThread(Compare co,int n,Object lock1,Object lock2){
		/**
    	 * 有参构造函数，传入锁，共享数据的对象，循环次数
    	 */
		this.co=co;
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
    public void run() {
		
		try {
			byte[] buf=new byte[1024];
			DatagramSocket socket=new DatagramSocket(8000);//设置udp端口为8000
			//System.out.println("udp Server stated on port 8000,"+new Date());
			DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);//初始化DatagramPacket
			DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
			Arrays.fill(buf,(byte)0) ;
			rcvPkt.setData(buf);
			socket.receive(rcvPkt);//接受客户端连接，得到客户端信息
			//System.out.println("udp get link");
			
			sndPkt.setAddress(rcvPkt.getAddress());
			sndPkt.setPort(rcvPkt.getPort());
			Arrays.fill(buf, (byte)0);
			buf=Integer.valueOf(n).toString().getBytes();
			sndPkt.setData(buf);
			socket.send(sndPkt);//发送给客户端循环次数n
			//System.out.println("udp send n");
			for(int i=0;i<n;i++) {//循环n次
				
				Arrays.fill(buf, (byte)0);
				buf="continue".getBytes();
				sndPkt.setData(buf);
				socket.send(sndPkt);//发送信息提醒客户端可以开始生成随机数
				
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);	//接受客户端传来的本次休眠时间
				co.setTimeB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get time"+new String(buf).trim());
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);//接受客户端传来的出拳序号1：石头，2：剪刀，3：布
				co.setB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get ch"+(new String(buf).trim()));
				synchronized(lock1) {
					lock1.notify();				//提醒线程compare开始比较			
				}
				synchronized(lock2) {
					lock2.wait();				//等待线程compare比较结束
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
	private int A=-1;//tcp传来的出拳序号
	private int B=-1;//udp传来的出拳序号
	private String strA;//tcp传来的出拳序号转成对应的字符串
	private String strB;//udp传来的出拳序号转成对应的字符串
	private int timeA;//tcp传来的休眠时间
	private int timeB;//udp传来的休眠时间
	private int scoreA=0;//tcp线程的分数
	private int scoreB=0;//udp线程的分数
	private int n=0;//循环次数
	private Object lock1;//锁1
	private Object lock2;//锁2
	Compare(int n,Object lock1,Object lock2){
		/**
		 * 有参构造函数，传入循环次数和锁
		 */
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	//getter and setter
	public void setA(int a) {
		A = a;
	}
	public void setB(int b) {
		B = b;
	}
	public void setTimeA(int timeA) {
		this.timeA = timeA;
	}
	public void setTimeB(int timeB) {
		this.timeB = timeB;
	}
	
	void showCompare(int i) {
	/**
	 * 进行猜拳，加分
	 * 然后打印结果 
	 */
			if(((A-B)==-1)||((A-B)==2)) {//根据出拳，判断胜负加分
				scoreA+=2; 
			}else if(((A-B)==-2)||((A-B)==1)) {
				scoreB+=2;
			}
			else if(A==B) {
				scoreA++;
				scoreB++;
			}
			switch(A) {//把出拳序号转化为字符串
			case 1: strA="Rock";break;
			case 2: strA="scissors";break;
			case 3: strA="paper";break;
			}
			switch(B) {
			case 1: strB="Rock";break;
			case 2: strB="scissors";break;
			case 3: strB="paper";break;
			}
			//打印结果
			System.out.printf("%1$4d    %2$-4dms   %3$-8s     %4$-9d",(i+1),timeA,strA,scoreA);
			System.out.printf("%1$-4dms   %2$-8s     %3$-12d\n",timeB,strB,scoreB);
	}
	
	@Override
	 public void run() {
		try {
			for(int i=0;i<n;i++) {//循环n次
			synchronized(lock1) {
				lock1.wait();		//等待tcp和udp都接受好数据
				lock1.wait();	
				showCompare(i);		//进行比较和打印
			}
			synchronized(lock2) {
				lock2.notifyAll();	//提醒tcp和udp进行下一次接受信息	
			}	
			}
			if(scoreA>scoreB) {//根据最后分数显示结果
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
