import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Least_Common_Multiple {
	
	public static void main(String[] args) {
		start();
	}
	static void start() {
		System.out.println("请输入两个数");
		Scanner sc = new Scanner(System.in); 
		int n1 = sc.nextInt(); 
		int n2 = sc.nextInt();
		int n=0;
		if(n1>n2)
			n=n1;
		else
			n=n2;
		int[][] t1=getPrimeFactorTable(n1,n);
		int[][] t2=getPrimeFactorTable(n2,n);
		System.out.println(getLCM(t1,t2));
		//System.out.println(n1+"  "+n2);
		sc.close();
	}
	static int[][] getPrimeFactorTable(int n ,int max) {
		/**
		 * 得到n的素数因数表
		 * @param n int 要算素数因数表的数
		 * @return table int[][] 素数因数表 
		 */
		List<Integer> P=new ArrayList<Integer>();//保存范围内的所有素数
		 for (int i = 2; i <=max; i++) {
			 boolean f=true;
			for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				f=false;
				break;
			}
			}
			if(f) {
				P.add(i);
			}
			}


/*for(int a : P) {
	System.out.println(a);
}*/


		int[][] table=new int[P.size()][2];
		boolean flag=true;
		for(int i=0;i<P.size();i++) {
			table[i][0]=P.get(i);
			table[i][1]=0;
		}
	    for(int i = 0; i < P.size(); i++) {		
	    	if(P.get(i)>n)
	    		break;
	    	while(flag) {		
				if(n % P.get(i) == 0) {
					table[i][1]++;
					n /= P.get(i);
				} else {
					flag=false;
				}
				if(n==1)
					flag=false;
			}
	    	flag=true;
		}
	    return table;
	}
	static int getLCM(int[][] t1,int[][] t2) {
		int len=t1.length;
		int lcm=1;
		int temp;
		for(int i=0;i<len;i++) {
			t1[i][1]=t1[i][1]>t2[i][1]?t1[i][1]:t2[i][1];
			temp=(int) Math.pow(t1[i][0], t1[i][1]);
			if(temp!=0)
				lcm*=temp;
		}
		return lcm;
	}
}
