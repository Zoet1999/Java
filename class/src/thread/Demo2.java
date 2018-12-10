package thread;

public class Demo2 {
	public static void main(String[] args)throws InterruptedException{
		Object ob=new Object();
		Thread1 t1=new Thread1(ob);
		Thread2 t2=new Thread2(ob);

		new Thread(t2).start();
		t1.start();

	}
}
class Thread1 extends Thread{	
	Object ob=new Object();
	Thread1(Object ob) {
		this.ob=ob;
	}
	@Override
	public void run(){
		try {synchronized(ob){	
				Thread.sleep(1000);
				ob.notify();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}

class Thread2 extends Thread{
	Object ob=new Object();
	Thread2(Object ob) {
		this.ob=ob;
	}
	@Override
	public void run() {	
		try {
			synchronized(ob){	
			System.out.println("1秒前的输出");
			ob.wait();
			System.out.println("1秒后的输出");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
	}}
}