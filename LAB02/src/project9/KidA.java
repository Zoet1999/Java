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
				Socket socket=new Socket("127.0.0.1",8888);//���ӱ���ip��8888�˿�
				DataInputStream in=new DataInputStream(socket.getInputStream());
				DataOutputStream out=new DataOutputStream(socket.getOutputStream());

				int n=in.readInt();//����ѭ������n
				//System.out.println("get n "+n);
				for(int i=0;i<n;i++) {//ѭ��n��
					in.readInt();//���ܷ��������źţ��������Կ�ʼ���������
					//System.out.println("get message ");
					int time;
					Random r=new Random();
					time=r.nextInt(1001);
					int ch;
					ch=r.nextInt(3)+1;
					Thread.sleep(time);//����
					out.writeInt(time);//��������ʱ��ͳ�ȭ����Ų����͸�������
					//System.out.println("send time:"+time);
					out.writeInt(ch);
					//System.out.println("send ch:"+ch);
					
					switch(ch) {
					case 1: str="Rock";break;
					case 2: str="scissors";break;
					case 3: str="paper";break;
					}
					System.out.println((i+1)+":"+str+"  "+time+"ms");//��ӡ����������ɵ���Ϣ
				}
				
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
	    }
}
