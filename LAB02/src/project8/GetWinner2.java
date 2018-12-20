/**
 * 该代码是用Join()实现Project8
 */

package project8;

import java.util.Random;
import java.util.Scanner;

public class GetWinner2 {
	 public static void main(String[] args) throws InterruptedException {
		    Compare2 co=new Compare2();
			System.out.println("请输入比较次数：");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
	        ThreadC2 c = new ThreadC2(co,n);
	        c.start();
	        sc.close();
	    }
}
class Compare2{
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

class ThreadA2 extends Thread {


	 private Compare2 c;
	    public ThreadA2(Compare2 c) {
	        super();
	        this.c=c;
	    }
	@Override
   public void run() {
		try {
			
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			sleep(time);
			c.setA(ch);
			c.setTa(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
class ThreadB2 extends Thread {

	 private Compare2 c;
	    public ThreadB2(Compare2 c) {
	        super();
	        this.c=c;
	    }
	@Override
   public void run() {
		try {
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			c.setB(ch);
			c.setTb(time);
			sleep(time);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
   }
}
class ThreadC2 extends Thread {

	 private ThreadA2 a;
	 private ThreadB2 b;
	 private Compare2 c;
	 private int n;
	    public ThreadC2(Compare2 c,int n) {
	        super();
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
				a=new ThreadA2(c);
				b=new ThreadB2(c);
				a.start();
				b.start();
				a.join();
				b.join();
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