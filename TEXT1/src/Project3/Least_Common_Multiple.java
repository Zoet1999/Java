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
		 * Ҫ����������������ͨ��getPrimeFactorTable���������õ�����Ԫ�ص��������ӱ� 
		 * Ȼ����getLCM���������С������ 
		 */
		Scanner sc = new Scanner(System.in); 
		while(true) {
		System.out.println("������������������0�˳�");
		int n1 = sc.nextInt(); 	//�õ���һ����
		if(n1==0) {				//����õ�0���˳�ѭ��
			break;
		}
		int n2 = sc.nextInt(); 	//�õ��ڶ�����
		if(n1<=0||n2<=0) {
			System.out.println("���벻��Ϊ������");
		}
		else {
		int n=0;				//�����������нϴ���Ǹ�
		if(n1>n2)				
			n=n1;
		else
			n=n2;
		int[][] t1=getPrimeFactorTable(n1,getPossiblePrime(n));	//�õ���һ�������������ӱ�
		int[][] t2=getPrimeFactorTable(n2,getPossiblePrime(n));	//�õ��ڶ��������������ӱ�
		System.out.println(getLCM(t1,t2));		//�õ���С�����������
		}
		}
		sc.close();
	}
	static List<Integer> getPossiblePrime(int max){
		/**
		 * ��������ܻ���ֵ���������
		 * �õ�0��max�е���������
		 * @param max int �������нϴ���Ǹ���
		 */
		List<Integer> Prime=new ArrayList<Integer>();//���ڱ��淶Χ�ڵ���������
		 for (int i = 2; i <=max; i++) {
			 boolean f=true;					//Ϊ����ʱΪ�棬����Ϊ��
			for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				f=false;
				break;
			}
			}
			if(f) {
				Prime.add(i);						//����������List P
			}
			}
		 return Prime;
	}	
	static int[][] getPrimeFactorTable(int n ,List<Integer> P) {
		/**
		 * �õ�n������������
		 * @param n int Ҫ���������������
		 * @param P List<Integer> ���ܻ���ֵ���������
		 * @return table int[][] ���������� 
		 */
		int[][] table=new int[P.size()][2];//���ڱ�������������  ��table[i][0]Ϊ������ֵ��table[i][1]Ϊ�������ֵĸ�������ʼΪ0��
		boolean flag=true;					//Ϊ����ʱΪ�棬����Ϊ��
		for(int i=0;i<P.size();i++) {
			table[i][0]=P.get(i);			//��ʼ��table[i][0]ΪP�е���������ʼ��table[i][1]�������ֵĸ���Ϊ0��
			table[i][1]=0;
		}
	    for(int i = 0; i < P.size(); i++) {		
	    	if(P.get(i)>n)					//�����������n��������ֱ�ӽ���
	    		break;
	    	while(flag==true) {					//������Ա������Ͱ���Ӧ��
				if(n % P.get(i) == 0) {
					table[i][1]++;
					n /= P.get(i);
				} else {
					flag=false;
				}
				if(n==1)			//���n�Ѿ�Ϊ1�������������ӣ�ֱ���˳�
					flag=false;
			}
	    	flag=true;
		}
	    return table;
	}
	static int getLCM(int[][] t1,int[][] t2) {
		/**
		 * ʹ�õõ��������������ر�õ���С������
		 * @param t1  ��һ�������������ر�
		 * @param t2  �ڶ��������������ر�
		 * @return lcm ��С������
		 */
		int len=t1.length;	//�������ر�ĸ���  
		int lcm=1;			//��������С�������Ĵ�
		int temp;			//�ݴ�����
		for(int i=0;i<len;i++) {
			t1[i][1]=t1[i][1]>t2[i][1]?t1[i][1]:t2[i][1];//����������ͬһ��������ͳ�Ƹ����ϴ�ĸ�����t1
			temp=(int) Math.pow(t1[i][0], t1[i][1]);//����������t1[i][1]���ݴη�
			if(temp!=0)
				lcm*=temp;//�ѵõ���������ˣ��õ���С������
		}
		return lcm;//������С������
	}
}
