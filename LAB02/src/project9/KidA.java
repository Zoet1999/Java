package project9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class KidA {
	 public static void main(String[] args){
			try {
				String str = null;
				Socket socket=new Socket("127.0.0.1",8888);//连接本地ip，8888端口
				DataInputStream in=new DataInputStream(socket.getInputStream());
				DataOutputStream out=new DataOutputStream(socket.getOutputStream());

				int n=in.readInt();//接受循环次数n
				//System.out.println("get n "+n);
				for(int i=0;i<n;i++) {//循环n次
					in.readInt();//接受服务器的信号，声明可以开始生成随机数
					//System.out.println("get message ");
					int time;
					Random r=new Random();
					time=r.nextInt(1001);
					int ch;
					ch=r.nextInt(3)+1;
					Thread.sleep(time);//休眠
					out.writeInt(time);//生成休眠时间和出拳的序号并发送给服务器
					//System.out.println("send time:"+time);
					out.writeInt(ch);
					//System.out.println("send ch:"+ch);
					
					switch(ch) {
					case 1: str="Rock";break;
					case 2: str="scissors";break;
					case 3: str="paper";break;
					}
					System.out.println((i+1)+":"+str+"  "+time+"ms");//打印本次随机生成的信息
				}
				
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
	    }
}
