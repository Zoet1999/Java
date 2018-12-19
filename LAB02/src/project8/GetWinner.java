package project8;

import java.util.Random;
import java.util.Scanner;
public class GetWinner {
	 public static void main(String[] args) throws InterruptedException {
		    Object lock=new Object();
		    Object lock2=new Object();
		    Compare co=new Compare();
			System.out.println("请输入比较次数：");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
		 	ThreadA a = new ThreadA(lock, lock2,co,n);
	        a.start();
	        ThreadB b = new ThreadB(lock, lock2,co,n);
	        b.start();
	        ThreadC c = new ThreadC(lock, lock2,co,n);
	        c.start();
	        sc.close();
	    }
}
class Compare{
	 private int a;
	 private int b;
	 private int ta;
	 private int tb;
	public int getTa() {
		return ta;
	}
	public void setTa(int ta) {
		this.ta = ta;
	}
	public int getTb() {
		return tb;
	}
	public void setTb(int tb) {
		this.tb = tb;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

}

class ThreadA extends Thread {
	 private Object lock;
	 private Object lock2;
	 private int n;
	 private Compare c;
	    public ThreadA(Object lock,Object lock2,Compare c,int n) {
	        super();
	        this.lock = lock;
	        this.lock2=lock2;
	        this.c=c;
	        this.n=n;
	    }
	@Override
    public void run() {
		try {
			for(int i=0;i<n;i++){
			synchronized (lock) {
			lock.wait();
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			sleep(time);
			c.setA(ch);
			c.setTa(time);
			synchronized (lock2) {
				lock2.notify();
				}}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
class ThreadB extends Thread {
	 private Object lock;
	 private Object lock2;
	 private Compare c;
	 private int n;
	    public ThreadB(Object lock,Object lock2, Compare c,int n) {
	        super();
	        this.lock = lock;
	        this.lock2=lock2;
	        this.c=c;
	        this.n=n;
	    }
	@Override
    public void run() {
		try {
			for(int i=0;i<n;i++) {
			synchronized (lock) {
			lock.wait();
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			c.setB(ch);
			c.setTb(time);
			sleep(time);
			synchronized (lock2) {
				lock2.notify();
				}
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
    }
}
class ThreadC extends Thread {
	 private Object lock;
	 private Object lock2;
	 private Compare c;
	 private int n;
	    public ThreadC(Object lock,Object lock2,Compare c,int n) {
	        super();
	        this.lock = lock;
	        this.lock2=lock2;
	        this.c=c;
	        this.n=n;
	    }
	@Override
    public void run() {
		try {

			int chA;
			int chB;
			int timeA;
			int timeB;
			int scoreA=0;
			int scoreB=0;
			System.out.println("                Thread A                       Thread B");
			System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
			System.out.println("         time   character  obtained     time   character  obtained");
			for(int i=0;i<n;i++) {
				synchronized (lock) {
					lock.notifyAll();}

				synchronized (lock2) {
					lock2.wait();
					lock2.wait();
				}
				
				chA=c.getA();
				chB=c.getB();
				timeA=c.getTa();
				timeB=c.getTb();
				if(chA>chB) {
					scoreA+=2;
				}
				else if(chA<chB) {
					scoreB+=2;
				}else {
					scoreA+=1;
					scoreB+=1;
				}
				System.out.printf("%1$4d%2$8dms%3$8c%4$12d",(i+1),timeA,(char)('A'+chA),scoreA);
				System.out.printf("%1$8dms%2$8c%3$12d\n",timeB,(char)('A'+chB),scoreB);
				
		}
			if(scoreA>scoreB) {
				System.out.println("最终结果：A胜");
			}
			else if(scoreA<scoreB) {
				System.out.println("最终结果：B胜");
			}else {
				System.out.println("最终结果：平局");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}