package Project3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Least_Common_Multiple {
	
	public static void main(String[] args) {
		start();
	}
	static void start() {
		/**
		 * 要求输入两个数，并通过getPrimeFactorTable（）函数得到两个元素的素数因子表 
		 * 然后传入getLCM（）算出最小公倍数 
		 */
		Scanner sc = new Scanner(System.in); 
		while(true) {
		System.out.println("请输入两个数，输入0退出");
		int n1 = sc.nextInt(); 	//得到第一个数
		if(n1==0) {				//如果得到0，退出循环
			break;
		}
		int n2 = sc.nextInt(); 	//得到第二个数
		if(n1<=0||n2<=0) {
			System.out.println("输入不能为非正数");
		}
		else {
		int n=0;				//保存两个数中较大的那个
		if(n1>n2)				
			n=n1;
		else
			n=n2;
		int[][] t1=getPrimeFactorTable(n1,getPossiblePrime(n));	//得到第一个数的素数因子表
		int[][] t2=getPrimeFactorTable(n2,getPossiblePrime(n));	//得到第二个数的素数因子表
		System.out.println(getLCM(t1,t2));		//得到最小公倍数并输出
		}
		}
		sc.close();
	}
	static List<Integer> getPossiblePrime(int max){
		/**
		 * 计算出可能会出现的素数集合
		 * 得到0到max中的所有素数
		 * @param max int 两个数中较大的那个数
		 */
		List<Integer> Prime=new ArrayList<Integer>();//用于保存范围内的所有素数
		 for (int i = 2; i <=max; i++) {
			 boolean f=true;					//为素数时为真，否则为假
			for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				f=false;
				break;
			}
			}
			if(f) {
				Prime.add(i);						//把素数加入List P
			}
			}
		 return Prime;
	}	
	static int[][] getPrimeFactorTable(int n ,List<Integer> P) {
		/**
		 * 得到n的素数因数表
		 * @param n int 要算素数因数表的数
		 * @param P List<Integer> 可能会出现的素数集合
		 * @return table int[][] 素数因数表 
		 */
		int[][] table=new int[P.size()][2];//用于保存素数因数表  其table[i][0]为素数的值，table[i][1]为素数出现的个数，初始为0；
		boolean flag=true;					//为因子时为真，否则为假
		for(int i=0;i<P.size();i++) {
			table[i][0]=P.get(i);			//初始化table[i][0]为P中的素数，初始化table[i][1]素数出现的个数为0；
			table[i][1]=0;
		}
	    for(int i = 0; i < P.size(); i++) {		
	    	if(P.get(i)>n)					//如果遇到大于n的素数就直接结束
	    		break;
	    	while(flag==true) {					//如果可以被整除就把相应的
				if(n % P.get(i) == 0) {
					table[i][1]++;
					n /= P.get(i);
				} else {
					flag=false;
				}
				if(n==1)			//如果n已经为1，不会再有因子，直接退出
					flag=false;
			}
	    	flag=true;
		}
	    return table;
	}
	static int getLCM(int[][] t1,int[][] t2) {
		/**
		 * 使用得到的两个素数因素表得到最小公倍数
		 * @param t1  第一个数的素数因素表
		 * @param t2  第二个数的素数因素表
		 * @return lcm 最小公倍数
		 */
		int len=t1.length;	//素数因素表的个数  
		int lcm=1;			//并保存最小公倍数的答案
		int temp;			//暂存数据
		for(int i=0;i<len;i++) {
			t1[i][1]=t1[i][1]>t2[i][1]?t1[i][1]:t2[i][1];//把两个表中同一个素数中统计个数较大的赋给表t1
			temp=(int) Math.pow(t1[i][0], t1[i][1]);//把素数进行t1[i][1]的幂次方
			if(temp!=0)
				lcm*=temp;//把得到的数据相乘，得到最小公倍数
		}
		return lcm;//返回最小公倍数
	}
}
