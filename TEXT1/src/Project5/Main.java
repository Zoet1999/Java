package Project5;
	
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;



public class Main extends Application {
	private ArrayList<String>answers=new ArrayList<String>();//����24�����п��ܵĴ�
	private CardPane cardpane=new CardPane();				//��Ҫ���֣������������ֵĲ���
	private int c1,c2,c3,c4=0;								//������������ĸ���Ƭ���
	private Random random = new Random();					//�����
	@Override
	public void start(Stage primaryStage) {
		try {
			//----------���ò�������------------------------
			GridPane root = new GridPane();		//������
			root.setHgap(20);					//����ֱ���
			root.setVgap(20);					//����ˮƽ���
			root.setAlignment(Pos.CENTER);		//����
			root.add(cardpane.getHead(),0,0);	//���������м����ϲ��ؼ�
			root.add(cardpane.getMid(),0,1);	//���������м����в��ؼ�
			root.add(cardpane.getBot(),0,2);	//���������м����²��ؼ�
			root.setPadding(new Insets(10, 10, 10, 10));//���ñ߿�
			
			//-----------����������ť���¼�----------------------
			//Solution��ť���õ����
			SolutionHandlerClass Solutionhandler = new  SolutionHandlerClass();
			cardpane.getSolutionButton().setOnAction(Solutionhandler);
			//Refresh��ť��ˢ����Ŀ
			RefreshHandlerClass Refreshhandler = new  RefreshHandlerClass();
			cardpane.getRefreshButton().setOnAction(Refreshhandler);
			//Verify��ť��ȷ�ϴ�
			VerifyHandlerClass Verifyhandler = new  VerifyHandlerClass();
			cardpane.getVerifyButton().setOnAction(Verifyhandler);
			
			//-----------���ô�������------------------------------
			Scene scene = new Scene(root,500,300);//���ô��ڴ�С
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project5");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	private	class RefreshHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * ����Refresh��ť�¼���ˢ����Ŀ
		 */
		  @Override
		  public void handle(ActionEvent e) {
				//����õ��ĸ����ظ���1~52�����֣������52������ѡ��4��
			  long t1=System.currentTimeMillis();
			  	do {
				c1 = random.nextInt(52)+1;
			    c2 = random.nextInt(52)+1;
			    c3 = random.nextInt(52)+1;
			    c4 = random.nextInt(52)+1;
				}
				while(c1==c2||c1==c3||c1==c4||c2==c3||c2==c4||c3==c4); 
			    //System.out.println(c1+" "+c2+" "+c3+" "+c4);
			  	//��������carͼƬΪ�µ�ͼƬ�������SolutionText��
			  cardpane.getCard1().setImage(new Image("file:src/card/"+c1+".png"));
			  cardpane.getCard2().setImage(new Image("file:src/card/"+c2+".png"));
			  cardpane.getCard3().setImage(new Image("file:src/card/"+c3+".png"));
			  cardpane.getCard4().setImage(new Image("file:src/card/"+c4+".png"));	 
			  cardpane.getSolutionText().setText("");
			  long t2=System.currentTimeMillis();
				System.out.println("Refresh��Ӧʱ��:"+(t2-t1));
	  }
	}
	private	class VerifyHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * ����Verify��ť�¼���ȷ�ϴ�
		 */
		 boolean flag=true;//��������ʹ������ȷ���ĸ�����ΪTrue��û�����ĸ�����������ֵ���ԣ�Ϊfalse
		@Override
		  public void handle(ActionEvent e) {
			long t1=System.currentTimeMillis();
		//----------��������----------------
		int a1=(c1-1)%13+1;		//ת����Ƭ�����Ϊ��Ӧ��ֵ	
		int a2=(c2-1)%13+1;
		int a3=(c3-1)%13+1;
		int a4=(c4-1)%13+1;
		String answer =cardpane.getAnswerText().getText();	//�õ�����Ľ����ַ���
		 ArrayList<Integer> num=new ArrayList<Integer>();	//�������е����ֲ���
		 
		 //-----------�������Ľ����ַ����е����ֲ���-----------------
		 //ѭ�������ַ���ÿһλ���Ѽ�鵽���������ִ���num
		  for(int i=0;i<answer.length();i++) {
			  switch(answer.charAt(i)) {
			  case '0':
				  num.add(0);
				  break;
			  case '1':
				  if(i+1<answer.length()) {//������ַ������һλ����ô�ض�Ϊ1�����������10~13
				  if(answer.charAt(i+1)=='0'||answer.charAt(i+1)=='1'||answer.charAt(i+1)=='2'||answer.charAt(i+1)=='3')
					  {
					  num.add(10+answer.charAt(i+1)-48);//�����10~13����Ϊ��Ӧ��ֵ
					  i++;
					  }
				  else 
					  num.add(1);
				  }
				  else
					  num.add(1);
				  break;
			  case '2':
				  num.add(2);
				  break;
			  case '3':
				  num.add(3);
				  break;
			  case '4':
				  num.add(4);
				  break;
			  case '5':
				  num.add(5);
				  break;
			  case '6':
				  num.add(6);
				  break;
			  case '7':
				  num.add(7);
				  break;
			  case '8':
				  num.add(8);
				  break;
			  case '9':
				  num.add(9);
				  break;
			  }
		  }
		 // System.out.println(num.get(0).intValue()+" "+num.get(1).intValue()+" "+num.get(2).intValue()+" "+num.get(3).intValue());
		
		  //---------------�ж��ַ����е������Ƿ����Ҫ��--------------------- 
		  if(num.size()!=4) {
			  //�ж����ݸ����Ƿ����4��
			  cardpane.getSolutionText().setText("use wrong nums");
			  flag=false;
		 }else
		  for(int i=0;i<4;i++) {
			  //�ж�4�����Ƿ�ʱҪ����ĸ���
			  //ÿƥ�䵽һ���Ͱ�����Ϊ-1����ֹ�ظ�ƥ��
			  if(num.get(i).intValue()==a1){
				 a1=-1;
			  }else if(num.get(i).intValue()==a2) {
				  a2=-1;
			  }else	 if(num.get(i).intValue()==a3) {
				  a3=-1;	  
			  }else if(num.get(i).intValue()==a4) {
				  a4=-1;
			  }else {
				  flag=false;
				  cardpane.getSolutionText().setText("use wrong nums");
				  break;
			  }
		  }
		 if(flag)//������������ͽ����жϽ������
		 {
			try {
				if(isCorrect(answer))//����жϳ����������SolutionText����ʾCorrect��������ʾwrong
				cardpane.getSolutionText().setText("correct");
				 else
				 cardpane.getSolutionText().setText("wrong");
			} catch (MyException e1) {//��������쳣����ʾillegal
				// TODO Auto-generated catch block
				 cardpane.getSolutionText().setText("illegal");
			}
			catch (EmptyStackException e1) {//��������쳣����ʾillegal
				// TODO Auto-generated catch block
				 cardpane.getSolutionText().setText("illegal");
			}
		 }
		 flag=true;
		 num.clear();
		 long t2=System.currentTimeMillis();
			System.out.println("Verity��Ӧʱ��:"+(t2-t1));
	  }
		private  boolean isCorrect(String expr) throws MyException,EmptyStackException {
			  /**
			   * �ж�������Ƿ���ȷ
			   * @param expr String Ҫ�жϵĴ𰸵��ַ���
			   * @return boolean �����ȷ����true������Ϊfalse
			   */
			  
			  //ʹ��ScriptEngineManager���Խű����Դ���������ȡ�����ַ���������ֱ���������Ĺ�ʽ�����������Ϸ���
			 /* ScriptEngineManager manager = new ScriptEngineManager();
			  ScriptEngine engine = manager.getEngineByName("js");
			  Object result = engine.eval(expr);
			  double ans=Double.parseDouble(result.toString());
			  */
			//��ջ������
			//----------�Ȱ���׺���ʽת��Ϊ��׺���ʽ---------------------
			 Stack<String> s= new Stack<String>();//������ŵ�ջ
			 Queue<String> q=new LinkedList<String>();//���ڱ�������ĺ�׺���ʽ
			 s.push("&");//�ڷ���ջ�׷�һ�����ȼ���͵ı�־����
			 int ans=0;//�����
			 for(int i=0;i<expr.length();i++) {//������׺���ʽ�е������ַ���ת��Ϊ��׺���ʽ
				 switch(expr.charAt(i)) {
				 case '+':
				 case '-':
				 case '*':
				 case '/':
					 if (getPrivilege(expr.charAt(i)) > getPrivilege(s.peek().charAt(0)))//���ջ�ڵĲ��������ȼ�����ջ������ȼ�������ջ 
						 { 
						 s.push(expr.substring(i,i+1));
						 } else if (getPrivilege(expr.charAt(i)) <= getPrivilege(s.peek().charAt(0))) //���ջ�ڵĲ��������ȼ����ڻ����ջ������ȼ�����ջ�ڵķ��ż����׺���ʽ���У�����ջջ��ķ���
						 	{ 
							 q.add(s.pop());
							 s.push(expr.substring(i,i+1));
						 	}
					 break;
				 case '('://���Ϊ��(����ֱ�Ӽ���ջ
					 s.push(expr.substring(i,i+1)); 
					 break; 
				 case ')':
					 while (s.peek().equals("(")==false){ 
						 q.add(s.pop());
						 }
					 s.pop();//���������š�
					 break;
				 default:
					 if(expr.charAt(i)>='0'&&expr.charAt(i)<='9'){
						if(i+1<expr.length()) {//������ַ������һλ����ô�ض�Ϊ1�����������10~13
							if(expr.charAt(i+1)=='0'||expr.charAt(i+1)=='1'||expr.charAt(i+1)=='2'||expr.charAt(i+1)=='3'){
								q.add(expr.substring(i, i+2));
								i++;
								}
								else {
									q.add(expr.substring(i,i+1));
									}
							}else {
								q.add(expr.substring(i,i+1));
							}
						}
					 	else {
						throw new MyException();//�����������Ҳ���Ƿ��ţ��Ͷ����쳣
					 	}
				 }
			 }
			 while(s.size()>1) {
				 q.add(s.pop());//�ѷ���ջ��ʣ�µĶ���ȫ��ѹ���׺���ʽ����
			 }
			 ans=calculate(q);//�ú�׺���ʽ��������
			 
			  if(ans==24)//������Ϊ24���ͷ���true
				  return true;
			  else//����ͷ���false
			  return false;
			  
		  }
		 private int calculate(Queue<String> q) {
			 /**
			  * �ú�׺���ʽ��������
			  * @param q Queue<String> ��׺���ʽ
			  * @return int ����Ľ��
			  */
			  Stack<Integer> s= new Stack<Integer>();//�ݴ���ֵ��ջ
			  String temp;
			  Integer n1,n2;	
			  int len=q.size();	
			  for(int i=0;i<len;i++) {//������׺���ʽ����
				  temp=q.remove();//������׺���ʽ��ͷ
				  switch(temp.charAt(0)) {
				  case '+'://���Ϊ��+��������ջ��������ֵ�����мӷ����㡣�ѽ��ѹ��ջ
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n1+n2);
					  break;
				  case '-'://���Ϊ��-��������ջ��������ֵ�����м������㡣�ѽ��ѹ��ջ
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n2-n1);
					  break;
				  case '*'://���Ϊ��*��������ջ��������ֵ�����г˷����㡣�ѽ��ѹ��ջ
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n1*n2);
					  break;
				  case '/'://���Ϊ��/��������ջ��������ֵ�����г�������.�ѽ��ѹ��ջ
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n2/n1);
					  break;
				  default:
					  s.push(Integer.valueOf(temp));//������Ƿ���,�Ǿ�������,ֱ��ѹ��ջ.
					  break;
				  }
			  }
			  return s.pop().intValue();
		  }
		 	private int getPrivilege(char c) {
			  /**
			   * �õ��������ȼ�
			   * @param c char ����
			   * @return int ���ȼ�
			   */
			  int Privilege=-1;
			  switch(c) {
			  case '&'://ջ�ױ�־����
				  Privilege=0;
				  break;
			  case '(':
				  Privilege=1;
				  break;
			  case '+':
			  case '-':
				  Privilege=2;
				  break;
			  case '/':
			  case '*':
				  Privilege=3;
				  break;
			  case ')':
				  Privilege=4;
				  break;
			  default:
				  	break;
			  }
			  
			  return Privilege;
		  }
	}
	private	class MyException extends Exception {
	    /**
		 * �Զ����쳣��,�������������������� ���ַ��ͻᶪ���쳣
		 */
		private static final long serialVersionUID = 1L;
		public MyException() {}
	    public MyException(String msg) {
	        super(msg);
	    }
	}
	private	class SolutionHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * ����Solution��ť�¼����õ����
		 */
		  @Override
		  public void handle(ActionEvent e) {
			  long t1=System.currentTimeMillis();
			 int index=0;
			  	if(c1!=0) {//�����û����refreshˢ�¿�Ƭ,����ʾ"Please Press Refresh",������д𰸲���
			  	Experssion exp= new Experssion();	//��ʼ�������洢���ʽ
				Thinker ti=new Thinker(exp);		//
				ArrayList<Integer> card=new ArrayList<Integer>();
				int sum=24;
				int a1=(c1-1)%13+1;
				int a2=(c2-1)%13+1;
				int a3=(c3-1)%13+1;
				int a4=(c4-1)%13+1;
				card.add(a1);
				card.add(a2);
				card.add(a3);
				card.add(a4);//��card�����д�����Ŀ���ĸ�����
				ti.count(card,card.size()-1,sum);//�������,�������Կ��ܴ𰸴���answers������
				if(answers.size()<=0) {//���answers������û��Ԫ��,˵��û�д�
					 cardpane.getSolutionText().setText("No Answer");
				}else {//�������һ������ʾ��SolutionText�ı���
			  index=random.nextInt(answers.size());
			  String solution=answers.get(index);
			  cardpane.getSolutionText().setText(solution);
			  answers.clear();}
			  	}
			  	else{
			  		cardpane.getSolutionText().setText("Please Press Refresh");
			  	}
			  	 long t2=System.currentTimeMillis();
					System.out.println("Solution��Ӧʱ��:"+(t2-t1));
		  }	  
	}
		
//Experssion��Thinker����㷨�ο��ԣ�https://blog.csdn.net/u014282557/article/details/70845167

	private	class Experssion{
		/**
		 * �������������������
		 */
	private ArrayList<Integer>num=new ArrayList<Integer>();//��������
	private ArrayList<String> sign=new ArrayList<String>();//�����������
	
	public void add(int n){
		/**
		 * �����ּ���num����
		 */
		num.add(n);
	}
	public void add(String s){
		/**
		 * �ѷ��ż���sign����
		 */
		sign.add(s);
	}
	
	private int getPriority(String s){
		/**
		 * ������������ȼ�
		 * @param s String ����
		 * @return int ���ȼ�
		 */
		if(sign.equals("+")) return 1;
		if(sign.equals("-")) return 1;
		if(sign.equals("*")) return 2;
		if(sign.equals("/")) return 2;
		return -1;
	}
	private String toString(int la){
		/**
		 * �ѱ��ʽ����ɰ�����˳��,�����Ż��ɵĽ��
		 * @param la int �ж��ǵڼ�������
		 * @return String ���ر��ʽ
		 */
		if(la==0){//����ǵ�һ������Ͳ���Ҫ������
			return num.get(0)+sign.get(0)+num.get(1);
		}
		else{
			String result=this.toString(la-1);
			if(getPriority(sign.get(la))>=getPriority(sign.get(la-1)))
				result="("+result+")";//���ǰһ���������ȼ�С�ڵ��ڵ�ǰ����,�Ǿ���Ҫ������
			result+=sign.get(la)+num.get(la+1);
			return result;
		}
	}
	
	public String toString(){
		/**
		 * ���û�в�����Ĭ��Ϊ������ȼ�������
		 */
	return toString(2);
	}
	
	public void clear(){
		/**
		 * �������
		 */
		num.clear();
		sign.clear();
	}
	
}
	private	class Thinker{
		/**
		 * �õݹ�ķ����ҵ�����Ҫ��Ĵ�
		 */
	private Experssion exp;
	public Thinker(Experssion expp){
		exp=expp; //���봴���õ�Experssion����
	}
	
	public boolean count(ArrayList<Integer>array,int num, int target){
		/**
		 * �����24����ȷ��
		 * @param array ArrayList<Integer> ʣ���ʹ������
		 * @param num int ʣ���������
		 * @param target int Ŀ����
		 */
		//��������һ��,ֱ�Ӹ��ݷ�������,������Ϊ��,��ѹ��exp.���м����ͳ�����Ҫ������˳��
		if(num==1){
			if(array.get(0)+array.get(1)==target){
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("+");
				return true;
			}
			if(array.get(0)-array.get(1)==target){
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("-");
				return true;
			}
			if(array.get(1)-array.get(0)==target){
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("-");
				return true;
			}
			if(array.get(0)*array.get(1)==target){
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("*");
				return true;
			}
			if(array.get(0)*target==array.get(1)){
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("/");
				return true;
			}
			if(array.get(1)*target==array.get(0)){
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("/");
				return true;
			}
			return false;
			
		}
		else{
			for(int current=0;current<array.size();current++){//ѭ��ʣ������
				ArrayList<Integer>array1=new ArrayList<Integer>();
				int currentNum=array.get(current);//�õ�����һ������
				for(int i=0;i<array.size();i++){
					if(i!=current){//���������ִ���array1
						array1.add(array.get(i));
					}
				}
				
				if(count(array1,num-1,target-currentNum)){//��� currentNum+ʣ�����ֵ���� ���Եõ�Ŀ���
					exp.add("+");
					exp.add(currentNum);
					if(num==3){				//����ʱ��������㣬��ֱ�ӳ�Ϊ��
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//���򷵻���һ��
				}
				if(count(array1,num-1,target+currentNum)){//��� ʣ�����ֵ����-currentNum ���Եõ�Ŀ���
					exp.add("-");
					exp.add(currentNum);
					if(num==3){					//����ʱ��������㣬��ֱ�ӳ�Ϊ��
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//���򷵻���һ��
				}
				
				
				if(count(array1,num-1,target*currentNum)){//��� ʣ�����ֵ����/currentNum ���Եõ�Ŀ���
					exp.add("/");
					exp.add(currentNum);
					if(num==3){					//����ʱ��������㣬��ֱ�ӳ�Ϊ��
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//���򷵻���һ��
				}
				
				if(target%currentNum==0){//��� ʣ�����ֵ����*currentNum ���Եõ�Ŀ���(�����ܱ�����)
					if(count(array1,num-1,(int)(target/currentNum))){
						exp.add("*");
						exp.add(currentNum);
						if(num==3){				//����ʱ��������㣬��ֱ�ӳ�Ϊ��
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//���򷵻���һ��
				}
			}
		}
		return false;//�����û�з��ϵģ��ͷ���ʧ��
	}
}
}
 	public static void main(String[] args) {
		launch(args);
	}
}
