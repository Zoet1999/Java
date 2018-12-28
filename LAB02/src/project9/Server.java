/**
 * ����˵��
 * ������Serverk.java,�������д���
 * ֮�������� KidA.java ��KidB.java �������ļ������Ⱥ�Ӱ��
 *  KidA.java ��KidB.java ����ʾ�ͳ�����Ϣ
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
		 Object lock1=new Object();//��1
		 Object lock2=new Object();//��2
		
		System.out.println("������Ƚϴ�����");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//�õ�ѭ������
        //long t1=System.currentTimeMillis();
		Compare co=new Compare(n,lock1,lock2);
		TcpServerThread tcp=new TcpServerThread(co,n,lock1,lock2);
		UdpServerThread udp=new UdpServerThread(co,n,lock1,lock2);
		System.out.println("                  Kid A                          Kid B");//������ͷ
		System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
		System.out.println("         time   character  obtained     time   character  obtained");
		tcp.start();//��ʼtcp�������߳�
		udp.start();//��ʼudp�������߳�
		co.start();//��ʼ�Ƚ��߳�
		sc.close();
		//long t2=System.currentTimeMillis();
		//System.out.println("����ʱ��"+(t2-t1)+"ms");
	    }
}

class TcpServerThread extends Thread{
	/**
	 * tcp�������̣߳������tcp�ͻ��˵���Ϣ��������Ƚ��̡߳�
	 */
	private Compare co;//�̼߳乲�����ݵĶ���
	private int n;//�Ƚϴ���
	private Object lock1;//ͬ����1
	private Object lock2;//ͬ����2
	TcpServerThread(Compare co,int n,Object lock1,Object lock2){
		/**
    	 * �вι��캯�������������������ݵĶ���ѭ������
    	 */
		this.co=co;
		this.n=n;
		this.lock1=lock1;
		this.lock2=lock2;
	}
	@Override
    public void run() {
		try {
			ServerSocket server=new ServerSocket(8888);//��ʼServerSocket�˿�Ϊ8888
			//System.out.println("Server stated on port 8888,"+new Date());
			Socket socket=server.accept();				//�ȴ����ܿͻ���
			//  InetAddress inetAddress = socket.getInetAddress();
			//  System.out.println("tcp's host name is " + inetAddress.getHostName());
			//  System.out.println("tcp's IP Address is " + inetAddress.getHostAddress());
			DataInputStream in=new DataInputStream(socket.getInputStream());	//��ʼ��inputStream
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());//��ʼ��outputStream
			
			out.writeInt(n);//�����ͻ���ѭ������
			//System.out.println("tcp send n");
			for(int i=0;i<n;i++) {//ѭ��n��
				out.writeInt(0);//�����ͻ���һ����Ϣ��������Կ�ʼ���������
				co.setTimeA(in.readInt());//�ȴ����ܿͻ��˵Ĵ����ı�������ʱ��
				//System.out.println("tcp get time");
				co.setA(in.readInt());//�ȴ����ܿͻ��˵Ĵ����ĳ�ȭ���1��ʯͷ��2��������3����
				//System.out.println("tcp get ch");
				
				synchronized(lock1) {
					lock1.notify();		//�����߳�compare��ʼ�Ƚ�			 
				}
				synchronized(lock2) {
					lock2.wait();		//�ȴ��߳�compare�ȽϽ���
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
	private Compare co;//�̼߳乲�����ݵĶ���
	private int n;//�Ƚϴ���
	private Object lock1;//ͬ����1
	private Object lock2;//ͬ����2
	UdpServerThread(Compare co,int n,Object lock1,Object lock2){
		/**
    	 * �вι��캯�������������������ݵĶ���ѭ������
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
			DatagramSocket socket=new DatagramSocket(8000);//����udp�˿�Ϊ8000
			//System.out.println("udp Server stated on port 8000,"+new Date());
			DatagramPacket rcvPkt=new DatagramPacket(buf,buf.length);//��ʼ��DatagramPacket
			DatagramPacket sndPkt=new DatagramPacket(buf,buf.length);
			Arrays.fill(buf,(byte)0) ;
			rcvPkt.setData(buf);
			socket.receive(rcvPkt);//���ܿͻ������ӣ��õ��ͻ�����Ϣ
			//System.out.println("udp get link");
			
			sndPkt.setAddress(rcvPkt.getAddress());
			sndPkt.setPort(rcvPkt.getPort());
			Arrays.fill(buf, (byte)0);
			buf=Integer.valueOf(n).toString().getBytes();
			sndPkt.setData(buf);
			socket.send(sndPkt);//���͸��ͻ���ѭ������n
			//System.out.println("udp send n");
			for(int i=0;i<n;i++) {//ѭ��n��
				
				Arrays.fill(buf, (byte)0);
				buf="continue".getBytes();
				sndPkt.setData(buf);
				socket.send(sndPkt);//������Ϣ���ѿͻ��˿��Կ�ʼ���������
				
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);	//���ܿͻ��˴����ı�������ʱ��
				co.setTimeB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get time"+new String(buf).trim());
				Arrays.fill(buf,(byte)0) ;
				rcvPkt.setData(buf);
				socket.receive(rcvPkt);//���ܿͻ��˴����ĳ�ȭ���1��ʯͷ��2��������3����
				co.setB(Integer.parseInt(new String(buf).trim()));
				//System.out.println("udp get ch"+(new String(buf).trim()));
				synchronized(lock1) {
					lock1.notify();				//�����߳�compare��ʼ�Ƚ�			
				}
				synchronized(lock2) {
					lock2.wait();				//�ȴ��߳�compare�ȽϽ���
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
	private int A=-1;//tcp�����ĳ�ȭ���
	private int B=-1;//udp�����ĳ�ȭ���
	private String strA;//tcp�����ĳ�ȭ���ת�ɶ�Ӧ���ַ���
	private String strB;//udp�����ĳ�ȭ���ת�ɶ�Ӧ���ַ���
	private int timeA;//tcp����������ʱ��
	private int timeB;//udp����������ʱ��
	private int scoreA=0;//tcp�̵߳ķ���
	private int scoreB=0;//udp�̵߳ķ���
	private int n=0;//ѭ������
	private Object lock1;//��1
	private Object lock2;//��2
	Compare(int n,Object lock1,Object lock2){
		/**
		 * �вι��캯��������ѭ����������
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
	 * ���в�ȭ���ӷ�
	 * Ȼ���ӡ��� 
	 */
			if(((A-B)==-1)||((A-B)==2)) {//���ݳ�ȭ���ж�ʤ���ӷ�
				scoreA+=2; 
			}else if(((A-B)==-2)||((A-B)==1)) {
				scoreB+=2;
			}
			else if(A==B) {
				scoreA++;
				scoreB++;
			}
			switch(A) {//�ѳ�ȭ���ת��Ϊ�ַ���
			case 1: strA="Rock";break;
			case 2: strA="scissors";break;
			case 3: strA="paper";break;
			}
			switch(B) {
			case 1: strB="Rock";break;
			case 2: strB="scissors";break;
			case 3: strB="paper";break;
			}
			//��ӡ���
			System.out.printf("%1$4d    %2$-4dms   %3$-8s     %4$-9d",(i+1),timeA,strA,scoreA);
			System.out.printf("%1$-4dms   %2$-8s     %3$-12d\n",timeB,strB,scoreB);
	}
	
	@Override
	 public void run() {
		try {
			for(int i=0;i<n;i++) {//ѭ��n��
			synchronized(lock1) {
				lock1.wait();		//�ȴ�tcp��udp�����ܺ�����
				lock1.wait();	
				showCompare(i);		//���бȽϺʹ�ӡ
			}
			synchronized(lock2) {
				lock2.notifyAll();	//����tcp��udp������һ�ν�����Ϣ	
			}	
			}
			if(scoreA>scoreB) {//������������ʾ���
				System.out.println("���ս����Aʤ");
			}
			else if(scoreA<scoreB) {
				System.out.println("���ս����Bʤ");
			}else {
				System.out.println("���ս����ƽ��");
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
