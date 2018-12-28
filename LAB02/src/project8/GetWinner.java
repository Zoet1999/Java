/**
 * 该代码是用wait()，notify(),noyifyAll()实现Project8
 */
package project8;

import java.util.Random;
import java.util.Scanner;

public class GetWinner{
	 public static void main(String[] args){
		
		 	Object lock=new Object();//锁1
		    Object lock2=new Object();//锁2
		    Compare co=new Compare();//共享数据对象
			System.out.println("请输入比较次数(lock实现)：");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();//循环次数
			long t1=System.currentTimeMillis();
		 	ThreadA a = new ThreadA(lock, lock2,co,n);
	        a.start();//开始线程A
	        ThreadB b = new ThreadB(lock, lock2,co,n);
	        b.start();//开始线程B
	        ThreadC runner = new ThreadC(lock, lock2,co,n);
	        Thread  c= new Thread(runner);
	        c.start();//开始线程C
	        sc.close();
			long t2=System.currentTimeMillis();
			//System.out.println("运行时间"+(t2-t1)+"ms");
	    }
}
class Compare{
	/**
	 * 比较类
	 * 用于保存从AB两个线程传来的信息,让线程C可以读取它们二者的信息。
	 */
	 private int charA;//线程A生成的字母对应的序号
	 private int charB;//线程B生成的字母对应的序号
	 private int timeA;//线程A生成的休眠时间
	 private int timeB;//线程B生成的休眠时间
	 
	 //getter and setter
	public int getTimeA() {
		return timeA;
	}
	public void setTimeA(int ta) {
		this.timeA = ta;
	}
	public int getTimeB() {
		return timeB;
	}
	public void setTimeB(int tb) {
		this.timeB = tb;
	}
	public int getCharA() {
		return charA;
	}
	public void setCharA(int a) {
		this.charA = a;
	}
	public int getCharB() {
		return charB;
	}
	public void setCharB(int b) {
		this.charB = b;
	}

}

class ThreadA extends Thread {
	/**
	 * 线程A，继承线程类，随机生成睡眠时间与字母
	 * 并将生成的随机数存入compare对象中
	 * 在运行过程中需要与线程c进行同步
	 */
	 private Object lock;//同步锁1
	 private Object lock2;//同步锁2
	 private int n;//比较次数
	 private Compare c;//线程间共享数据的对象
	    public ThreadA(Object lock,Object lock2,Compare c,int n) {
	    	/**
	    	 * 有参构造函数，传入锁，共享数据的对象，循环次数
	    	 */
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
			lock.wait();//等待线程C完成上一次计算
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			sleep(time);		//休眠
			c.setCharA(ch);			//生成随机数，并传入共享对象
			c.setTimeA(time);		
			synchronized (lock2) {
				lock2.notify();//提醒线程C随机数生成完成
				}}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
class ThreadB extends Thread {
	/**
	 * 线程B，继承线程类，随机生成睡眠时间与字母
	 * 并将生成的随机数存入compare对象中
	 * 在运行过程中需要与线程c进行同步
	 */
	 private Object lock;//同步锁1
	 private Object lock2;//同步锁2
	 private Compare c;//线程间共享数据的对象
	 private int n;//比较次数
	    public ThreadB(Object lock,Object lock2, Compare c,int n) {
	      	/**
	    	 * 有参构造函数，传入锁，共享数据的对象，循环次数
	    	 */
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
			lock.wait();//等待线程C完成上一次计算
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			c.setCharB(ch);			//生成随机数，并传入共享对象
			c.setTimeB(time);
			sleep(time);		//休眠
			synchronized (lock2) {
				lock2.notify();//提醒线程C随机数生成完成
				}
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
    }
}
class ThreadC implements Runnable  {
	/**
	 * 线程C，实现Runnable接口
	 * 完成与线程AB的同步，并且利用接受到的数据，进行比较，计算分数，并打印成表
	 */
	 private Object lock;//同步锁1
	 private Object lock2;//同步锁2
	 private Compare c;//线程间共享数据的对象
	 private int n;//比较次数
	    public ThreadC(Object lock,Object lock2,Compare c,int n) {
	    	/**
	    	 * 有参构造函数，传入锁，共享数据的对象，循环次数
	    	 */
	        super();
	        this.lock = lock;
	        this.lock2=lock2;
	        this.c=c;
	        this.n=n;
	    }
    public void run() {
		try {
			int chA;//线程A的字母序号
			int chB;//线程B的字母序号
			int timeA;//线程A的休眠时间
			int timeB;//线程B的休眠时间
			int scoreA=0;//线程A的分数
			int scoreB=0;//线程B的分数
			System.out.println("                Thread A                       Thread B");//打印表头
			System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
			System.out.println("         time   character  obtained     time   character  obtained");
			for(int i=0;i<n;i++) {//循环n次
			
				synchronized (lock) {
					lock.notifyAll();//提醒线程AB开始获得随机数
				}

				synchronized (lock2) {
					lock2.wait();//等待线程AB完成获得随机数
					lock2.wait();
				}
				
				chA=c.getCharA();//得到线程AB的随机数和休眠时间
				chB=c.getCharB();
				timeA=c.getTimeA();
				timeB=c.getTimeB();
				if(chA>chB) {//根据线程AB的字母，改变AB的分数
					scoreA+=2;
				}
				else if(chA<chB) {
					scoreB+=2;
				}else {
					scoreA+=1;
					scoreB+=1;
				}
				System.out.printf("%1$4d%2$8dms%3$8c%4$12d",(i+1),timeA,(char)('A'+chA),scoreA);//打印线程A的的休眠时间，字母，分数
				System.out.printf("%1$8dms%2$8c%3$12d\n",timeB,(char)('A'+chB),scoreB);//打印线程B的的休眠时间，字母，分数
				
		}
			if(scoreA>scoreB) {//在所有循环结束之后，根据AB的分数，宣布比赛结果
				System.out.println("最终结果：A胜");
			}
			else if(scoreA<scoreB) {
				System.out.println("最终结果：B胜");
			}else {
				System.out.println("最终结果：平局");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}