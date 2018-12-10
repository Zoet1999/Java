package WEB;

import java.io.*;
import java.net.*;

public class Demo4  {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("resource")
			ServerSocket server=new ServerSocket(8888);
			while (true) {
			Socket socket=server.accept();
			  InetAddress inetAddress = socket.getInetAddress();
			  System.out.println("'s host name is " + inetAddress.getHostName());
			  System.out.println("'s IP Address is " + inetAddress.getHostAddress());

			ClientThread thread = new ClientThread(socket);
	        thread.start();
			}
		}
		catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
class ClientThread extends Thread {
    private Socket socket; 
    public ClientThread(Socket socket) {
      this.socket = socket;
    }
    public void run() {
      try {
			DataInputStream in=new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			double d = in.readDouble();
			System.out.println("recv double  "+d);
			sleep(3000);
			String s=Double.toString(d);
			out.writeObject(s);
			System.out.println("send string  "+s);
      }
      catch(IOException ex) {
			System.err.println(ex);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

}
