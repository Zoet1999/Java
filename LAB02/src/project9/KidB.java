package project9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;

public class KidB {
	 public static void main(String[] args){
		 
		 	String str=null;
			byte[] buf=new byte[1024];
			InetAddress server;
		
			DatagramPacket sndPkt;
			
			DatagramPacket rcvPkt;
			try(DatagramSocket socket=new DatagramSocket()){
				server=InetAddress.getByName("127.0.0.1");//连接本地ip
				sndPkt=new DatagramPacket(buf,buf.length);
				sndPkt.setAddress(server);
				sndPkt.setPort(8000);//连接端口8000
				Arrays.fill(buf, (byte)0);
				buf="link".getBytes();
				sndPkt.setData(buf);
				socket.send(sndPkt);		//发送信息给服务器，让udp服务器得到客户端的信息
				//System.out.println("send link");
				buf=new byte[1024];
				rcvPkt=new DatagramPacket(buf,buf.length);
				socket.receive(rcvPkt);	//接受服务器传来的循环次数n
				//System.out.println("get n");
				int n=Integer.parseInt(new String(buf).trim());
				//System.out.println("set n "+n);
				for(int i=0;i<n;i++) {//循环n次
					Arrays.fill(buf, (byte)0);
					rcvPkt.setData(buf);
					socket.receive(rcvPkt);//等待服务器端发送
					//System.out.println("get message");
					
					//生成随机休眠时间和出拳序号，并发送给服务器
					int time;
					Random r=new Random();
					time=r.nextInt(1001);
					int ch;
					ch=r.nextInt(3)+1;
					Thread.sleep(time);//休眠
					Arrays.fill(buf, (byte)0);
					buf=String.valueOf(time).getBytes();
					sndPkt.setData(buf);
					socket.send(sndPkt);
				//	System.out.println("send time:"+time);

					Arrays.fill(buf, (byte)0);
					buf=String.valueOf(ch).getBytes();
					sndPkt.setData(buf);
					socket.send(sndPkt);
					//System.out.println("send ch:"+ch);
					switch(ch) {
					case 1: str="Rock";break;
					case 2: str="scissors";break;
					case 3: str="paper";break;
					}
					System.out.println((i+1)+":"+str+"  "+time+"ms");//打印本次随机生成的信息
				}
				
		
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
