/**
 * �ô�������wait()��notify(),noyifyAll()ʵ��Project8
 */
package project8;

import java.util.Random;
import java.util.Scanner;

public class GetWinner{
	 public static void main(String[] args){
		
		 	Object lock=new Object();//��1
		    Object lock2=new Object();//��2
		    Compare co=new Compare();//�������ݶ���
			System.out.println("������Ƚϴ���(lockʵ��)��");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();//ѭ������
			long t1=System.currentTimeMillis();
		 	ThreadA a = new ThreadA(lock, lock2,co,n);
	        a.start();//��ʼ�߳�A
	        ThreadB b = new ThreadB(lock, lock2,co,n);
	        b.start();//��ʼ�߳�B
	        ThreadC runner = new ThreadC(lock, lock2,co,n);
	        Thread  c= new Thread(runner);
	        c.start();//��ʼ�߳�C
	        sc.close();
			long t2=System.currentTimeMillis();
			//System.out.println("����ʱ��"+(t2-t1)+"ms");
	    }
}
class Compare{
	/**
	 * �Ƚ���
	 * ���ڱ����AB�����̴߳�������Ϣ,���߳�C���Զ�ȡ���Ƕ��ߵ���Ϣ��
	 */
	 private int charA;//�߳�A���ɵ���ĸ��Ӧ�����
	 private int charB;//�߳�B���ɵ���ĸ��Ӧ�����
	 private int timeA;//�߳�A���ɵ�����ʱ��
	 private int timeB;//�߳�B���ɵ�����ʱ��
	 
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
	 * �߳�A���̳��߳��࣬�������˯��ʱ������ĸ
	 * �������ɵ����������compare������
	 * �����й�������Ҫ���߳�c����ͬ��
	 */
	 private Object lock;//ͬ����1
	 private Object lock2;//ͬ����2
	 private int n;//�Ƚϴ���
	 private Compare c;//�̼߳乲�����ݵĶ���
	    public ThreadA(Object lock,Object lock2,Compare c,int n) {
	    	/**
	    	 * �вι��캯�������������������ݵĶ���ѭ������
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
			lock.wait();//�ȴ��߳�C�����һ�μ���
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			sleep(time);		//����
			c.setCharA(ch);			//����������������빲�����
			c.setTimeA(time);		
			synchronized (lock2) {
				lock2.notify();//�����߳�C������������
				}}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
class ThreadB extends Thread {
	/**
	 * �߳�B���̳��߳��࣬�������˯��ʱ������ĸ
	 * �������ɵ����������compare������
	 * �����й�������Ҫ���߳�c����ͬ��
	 */
	 private Object lock;//ͬ����1
	 private Object lock2;//ͬ����2
	 private Compare c;//�̼߳乲�����ݵĶ���
	 private int n;//�Ƚϴ���
	    public ThreadB(Object lock,Object lock2, Compare c,int n) {
	      	/**
	    	 * �вι��캯�������������������ݵĶ���ѭ������
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
			lock.wait();//�ȴ��߳�C�����һ�μ���
			}
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			c.setCharB(ch);			//����������������빲�����
			c.setTimeB(time);
			sleep(time);		//����
			synchronized (lock2) {
				lock2.notify();//�����߳�C������������
				}
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
    }
}
class ThreadC implements Runnable  {
	/**
	 * �߳�C��ʵ��Runnable�ӿ�
	 * ������߳�AB��ͬ�����������ý��ܵ������ݣ����бȽϣ��������������ӡ�ɱ�
	 */
	 private Object lock;//ͬ����1
	 private Object lock2;//ͬ����2
	 private Compare c;//�̼߳乲�����ݵĶ���
	 private int n;//�Ƚϴ���
	    public ThreadC(Object lock,Object lock2,Compare c,int n) {
	    	/**
	    	 * �вι��캯�������������������ݵĶ���ѭ������
	    	 */
	        super();
	        this.lock = lock;
	        this.lock2=lock2;
	        this.c=c;
	        this.n=n;
	    }
    public void run() {
		try {
			int chA;//�߳�A����ĸ���
			int chB;//�߳�B����ĸ���
			int timeA;//�߳�A������ʱ��
			int timeB;//�߳�B������ʱ��
			int scoreA=0;//�߳�A�ķ���
			int scoreB=0;//�߳�B�ķ���
			System.out.println("                Thread A                       Thread B");//��ӡ��ͷ
			System.out.println("Round   Sleep    Random     Points     Sleep    Random     Points");
			System.out.println("         time   character  obtained     time   character  obtained");
			for(int i=0;i<n;i++) {//ѭ��n��
			
				synchronized (lock) {
					lock.notifyAll();//�����߳�AB��ʼ��������
				}

				synchronized (lock2) {
					lock2.wait();//�ȴ��߳�AB��ɻ�������
					lock2.wait();
				}
				
				chA=c.getCharA();//�õ��߳�AB�������������ʱ��
				chB=c.getCharB();
				timeA=c.getTimeA();
				timeB=c.getTimeB();
				if(chA>chB) {//�����߳�AB����ĸ���ı�AB�ķ���
					scoreA+=2;
				}
				else if(chA<chB) {
					scoreB+=2;
				}else {
					scoreA+=1;
					scoreB+=1;
				}
				System.out.printf("%1$4d%2$8dms%3$8c%4$12d",(i+1),timeA,(char)('A'+chA),scoreA);//��ӡ�߳�A�ĵ�����ʱ�䣬��ĸ������
				System.out.printf("%1$8dms%2$8c%3$12d\n",timeB,(char)('A'+chB),scoreB);//��ӡ�߳�B�ĵ�����ʱ�䣬��ĸ������
				
		}
			if(scoreA>scoreB) {//������ѭ������֮�󣬸���AB�ķ����������������
				System.out.println("���ս����Aʤ");
			}
			else if(scoreA<scoreB) {
				System.out.println("���ս����Bʤ");
			}else {
				System.out.println("���ս����ƽ��");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}