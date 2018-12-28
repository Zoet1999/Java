/**
 * �ô�������Join()ʵ��Project8
 */

package project8;

import java.util.Random;
import java.util.Scanner;

public class GetWinner2 {
	 public static void main(String[] args)  {
			
		    Compare2 co=new Compare2();//�������ݶ���
			System.out.println("������Ƚϴ���(joinʵ��)��");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();//ѭ������
			long t1=System.currentTimeMillis();
	        ThreadC2 runner = new ThreadC2(co,n);
	        Thread  c= new Thread(runner);
	        c.start();//��ʼ�߳�C
	        sc.close();
			long t2=System.currentTimeMillis();
			//System.out.println("����ʱ��"+(t2-t1)+"ms");
	    }
}
class Compare2{
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

class ThreadA2 extends Thread {
	/**
	 * �߳�A���̳��߳��࣬�������˯��ʱ������ĸ
	 * �������ɵ����������compare������
	 */
	 private Compare2 c;//�̼߳乲�����ݵĶ���
	    public ThreadA2(Compare2 c) {
	    	/**
	    	 * �вι��캯�������빲�����ݵĶ���
	    	 */
	        super();
	        this.c=c;//�̼߳乲�����ݵĶ���
	    }
	@Override
   public void run() {
		try {
			
			int time;
			Random r=new Random();
			time=r.nextInt(1001);
			int ch;
			ch=r.nextInt(26);
			sleep(time);	//����
			c.setCharA(ch);	//����������������빲�����
			c.setTimeA(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
class ThreadB2 extends Thread {
	/**
	 * �߳�B���̳��߳��࣬�������˯��ʱ������ĸ
	 * �������ɵ����������compare������
	 */
	 private Compare2 c;//�̼߳乲�����ݵĶ���
	    public ThreadB2(Compare2 c) {
	    	/**
	    	 * �вι��캯�������빲�����ݵĶ���
	    	 */
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
			c.setCharB(ch);	//����������������빲�����
			c.setTimeB(time);
			sleep(time);		//����
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
   }
}
class ThreadC2 implements Runnable {
	/**
	 * �߳�C��ʵ��Runnable�ӿ�
	 * ������߳�AB��ͬ�����������ý��ܵ������ݣ����бȽϣ��������������ӡ�ɱ�
	 */
	 private ThreadA2 a;//ͬ����1
	 private ThreadB2 b;//ͬ����2
	 private Compare2 c;//�̼߳乲�����ݵĶ���
	 private int n;//�Ƚϴ���
	    public ThreadC2(Compare2 c,int n) {
	    	/**
	    	 * �вι��캯�������������������ݵĶ���ѭ������
	    	 */
	        super();
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
				a=new ThreadA2(c);
				b=new ThreadB2(c);
				a.start();//��ʼ�߳�AB
				b.start();
				a.join();//�ȴ��߳�AB����
				b.join();
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