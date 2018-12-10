package WEB;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class DemoClient {
	public static void main(String[] args) {
		try{
			Socket socket=new Socket("127.0.0.1",8888);//localhost
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			System.out.println("请输入一个double值：");
			Scanner scanner = new Scanner(System.in);
			
			double d=scanner.nextDouble();
			out.writeDouble(d);
			 System.out.println("send:"+d);

			Object s = in.readObject();
			System.out.println("recv:"+s);
			
			scanner.close();
			socket.close();		
		}
		catch (IOException ex) {
			System.err.println(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}