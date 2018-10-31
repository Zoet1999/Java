package application;

 
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Experssion exp= new Experssion();
		Thinker ti=new Thinker(exp);
		ArrayList<Integer> card=new ArrayList<Integer>();
		int sum=24;
		Scanner sc=new Scanner(System.in);
		int t;
		for(int i=0;i<4;i++){
			t=sc.nextInt();
			card.add(t);
		}
		ti.count(card,card.size()-1,sum);
		
	}
 
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 