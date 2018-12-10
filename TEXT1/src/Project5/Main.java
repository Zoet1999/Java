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
	private ArrayList<String>answers=new ArrayList<String>();//保存24点所有可能的答案
	private CardPane cardpane=new CardPane();				//主要布局，返回三各部分的布局
	private int c1,c2,c3,c4=0;								//保存随机出的四个卡片序号
	private Random random = new Random();					//随机用
	@Override
	public void start(Stage primaryStage) {
		try {
			//----------设置布局属性------------------------
			GridPane root = new GridPane();		//主窗口
			root.setHgap(20);					//网格垂直间距
			root.setVgap(20);					//网格水平间距
			root.setAlignment(Pos.CENTER);		//居中
			root.add(cardpane.getHead(),0,0);	//在主窗口中加入上部控件
			root.add(cardpane.getMid(),0,1);	//在主窗口中加入中部控件
			root.add(cardpane.getBot(),0,2);	//在主窗口中加入下部控件
			root.setPadding(new Insets(10, 10, 10, 10));//设置边框
			
			//-----------设置三个按钮的事件----------------------
			//Solution按钮，得到题解
			SolutionHandlerClass Solutionhandler = new  SolutionHandlerClass();
			cardpane.getSolutionButton().setOnAction(Solutionhandler);
			//Refresh按钮，刷新题目
			RefreshHandlerClass Refreshhandler = new  RefreshHandlerClass();
			cardpane.getRefreshButton().setOnAction(Refreshhandler);
			//Verify按钮，确认答案
			VerifyHandlerClass Verifyhandler = new  VerifyHandlerClass();
			cardpane.getVerifyButton().setOnAction(Verifyhandler);
			
			//-----------设置窗口属性------------------------------
			Scene scene = new Scene(root,500,300);//设置窗口大小
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
		 * 设置Refresh按钮事件，刷新题目
		 */
		  @Override
		  public void handle(ActionEvent e) {
				//随机得到四个不重复的1~52的数字，代表从52张牌中选择4张
			  long t1=System.currentTimeMillis();
			  	do {
				c1 = random.nextInt(52)+1;
			    c2 = random.nextInt(52)+1;
			    c3 = random.nextInt(52)+1;
			    c4 = random.nextInt(52)+1;
				}
				while(c1==c2||c1==c3||c1==c4||c2==c3||c2==c4||c3==c4); 
			    //System.out.println(c1+" "+c2+" "+c3+" "+c4);
			  	//更新四张car图片为新的图片，并清空SolutionText栏
			  cardpane.getCard1().setImage(new Image("file:src/card/"+c1+".png"));
			  cardpane.getCard2().setImage(new Image("file:src/card/"+c2+".png"));
			  cardpane.getCard3().setImage(new Image("file:src/card/"+c3+".png"));
			  cardpane.getCard4().setImage(new Image("file:src/card/"+c4+".png"));	 
			  cardpane.getSolutionText().setText("");
			  long t2=System.currentTimeMillis();
				System.out.println("Refresh相应时间:"+(t2-t1));
	  }
	}
	private	class VerifyHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * 设置Verify按钮事件，确认答案
		 */
		 boolean flag=true;//如果解答中使用了正确的四个数，为True，没有用四个数，或者数值不对，为false
		@Override
		  public void handle(ActionEvent e) {
			long t1=System.currentTimeMillis();
		//----------声明变量----------------
		int a1=(c1-1)%13+1;		//转换卡片的序号为对应数值	
		int a2=(c2-1)%13+1;
		int a3=(c3-1)%13+1;
		int a4=(c4-1)%13+1;
		String answer =cardpane.getAnswerText().getText();	//得到输入的解答的字符串
		 ArrayList<Integer> num=new ArrayList<Integer>();	//保存解答中的数字部分
		 
		 //-----------获得输入的解答的字符串中的数字部分-----------------
		 //循环遍历字符串每一位，把检查到的所有数字存入num
		  for(int i=0;i<answer.length();i++) {
			  switch(answer.charAt(i)) {
			  case '0':
				  num.add(0);
				  break;
			  case '1':
				  if(i+1<answer.length()) {//如果是字符串最后一位，那么必读为1，否则可能是10~13
				  if(answer.charAt(i+1)=='0'||answer.charAt(i+1)=='1'||answer.charAt(i+1)=='2'||answer.charAt(i+1)=='3')
					  {
					  num.add(10+answer.charAt(i+1)-48);//如果是10~13，存为相应的值
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
		
		  //---------------判断字符串中的数字是否符合要求--------------------- 
		  if(num.size()!=4) {
			  //判断数据个数是否符合4个
			  cardpane.getSolutionText().setText("use wrong nums");
			  flag=false;
		 }else
		  for(int i=0;i<4;i++) {
			  //判断4个数是否时要求的四个数
			  //每匹配到一个就把它置为-1，防止重复匹配
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
		 if(flag)//如果符合条件就进入判断结果函数
		 {
			try {
				if(isCorrect(answer))//如果判断出结果正常，SolutionText中显示Correct，否则显示wrong
				cardpane.getSolutionText().setText("correct");
				 else
				 cardpane.getSolutionText().setText("wrong");
			} catch (MyException e1) {//如果出现异常，显示illegal
				// TODO Auto-generated catch block
				 cardpane.getSolutionText().setText("illegal");
			}
			catch (EmptyStackException e1) {//如果出现异常，显示illegal
				// TODO Auto-generated catch block
				 cardpane.getSolutionText().setText("illegal");
			}
		 }
		 flag=true;
		 num.clear();
		 long t2=System.currentTimeMillis();
			System.out.println("Verity相应时间:"+(t2-t1));
	  }
		private  boolean isCorrect(String expr) throws MyException,EmptyStackException {
			  /**
			   * 判断输入答案是否正确
			   * @param expr String 要判断的答案的字符串
			   * @return boolean 如果正确返回true，否则为false
			   */
			  
			  //使用ScriptEngineManager，以脚本语言处理方法来读取输入字符串，可以直接算出输入的公式结果，如果不合法会
			 /* ScriptEngineManager manager = new ScriptEngineManager();
			  ScriptEngine engine = manager.getEngineByName("js");
			  Object result = engine.eval(expr);
			  double ans=Double.parseDouble(result.toString());
			  */
			//用栈算出结果
			//----------先把中缀表达式转换为后缀表达式---------------------
			 Stack<String> s= new Stack<String>();//保存符号的栈
			 Queue<String> q=new LinkedList<String>();//用于保存输出的后缀表达式
			 s.push("&");//在符号栈底放一个优先级最低的标志符号
			 int ans=0;//保存答案
			 for(int i=0;i<expr.length();i++) {//遍历中缀表达式中的所有字符，转换为后缀表达式
				 switch(expr.charAt(i)) {
				 case '+':
				 case '-':
				 case '*':
				 case '/':
					 if (getPrivilege(expr.charAt(i)) > getPrivilege(s.peek().charAt(0)))//如果栈内的操作符优先级高于栈外的优先级，则入栈 
						 { 
						 s.push(expr.substring(i,i+1));
						 } else if (getPrivilege(expr.charAt(i)) <= getPrivilege(s.peek().charAt(0))) //如果栈内的操作符优先级低于或等于栈外的优先级，把栈内的符号加入后缀表达式队列，并入栈栈外的符号
						 	{ 
							 q.add(s.pop());
							 s.push(expr.substring(i,i+1));
						 	}
					 break;
				 case '('://如果为“(”就直接加入栈
					 s.push(expr.substring(i,i+1)); 
					 break; 
				 case ')':
					 while (s.peek().equals("(")==false){ 
						 q.add(s.pop());
						 }
					 s.pop();//抛弃左括号。
					 break;
				 default:
					 if(expr.charAt(i)>='0'&&expr.charAt(i)<='9'){
						if(i+1<expr.length()) {//如果是字符串最后一位，那么必读为1，否则可能是10~13
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
						throw new MyException();//如果不是数字也不是符号，就丢出异常
					 	}
				 }
			 }
			 while(s.size()>1) {
				 q.add(s.pop());//把符号栈里剩下的东西全部压入后缀表达式队列
			 }
			 ans=calculate(q);//用后缀表达式计算出结果
			 
			  if(ans==24)//如果结果为24，就返回true
				  return true;
			  else//否则就返回false
			  return false;
			  
		  }
		 private int calculate(Queue<String> q) {
			 /**
			  * 用后缀表达式计算出结果
			  * @param q Queue<String> 后缀表达式
			  * @return int 算出的结果
			  */
			  Stack<Integer> s= new Stack<Integer>();//暂存数值的栈
			  String temp;
			  Integer n1,n2;	
			  int len=q.size();	
			  for(int i=0;i<len;i++) {//遍历后缀表达式队列
				  temp=q.remove();//弹出后缀表达式队头
				  switch(temp.charAt(0)) {
				  case '+'://如果为“+”，弹出栈顶两个数值，进行加分运算。把结果压回栈
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n1+n2);
					  break;
				  case '-'://如果为“-”，弹出栈顶两个数值，进行减法运算。把结果压回栈
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n2-n1);
					  break;
				  case '*'://如果为“*”，弹出栈顶两个数值，进行乘分运算。把结果压回栈
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n1*n2);
					  break;
				  case '/'://如果为“/”，弹出栈顶两个数值，进行除分运算.把结果压回栈
					  n1=s.pop();
					  n2=s.pop();
					  s.push(n2/n1);
					  break;
				  default:
					  s.push(Integer.valueOf(temp));//如果不是符号,那就是数字,直接压入栈.
					  break;
				  }
			  }
			  return s.pop().intValue();
		  }
		 	private int getPrivilege(char c) {
			  /**
			   * 得到符号优先级
			   * @param c char 符号
			   * @return int 优先级
			   */
			  int Privilege=-1;
			  switch(c) {
			  case '&'://栈底标志符号
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
		 * 自定义异常类,如果输入符号与数字以外 的字符就会丢出异常
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
		 * 设置Solution按钮事件，得到题解
		 */
		  @Override
		  public void handle(ActionEvent e) {
			  long t1=System.currentTimeMillis();
			 int index=0;
			  	if(c1!=0) {//如果还没有用refresh刷新卡片,就提示"Please Press Refresh",否则进行答案查找
			  	Experssion exp= new Experssion();	//初始化用来存储表达式
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
				card.add(a4);//在card数组中存入题目是四个数字
				ti.count(card,card.size()-1,sum);//计算出答案,并把所以可能答案存入answers数数组
				if(answers.size()<=0) {//如果answers数组中没有元素,说明没有答案
					 cardpane.getSolutionText().setText("No Answer");
				}else {//否则随机一个答案显示在SolutionText文本框
			  index=random.nextInt(answers.size());
			  String solution=answers.get(index);
			  cardpane.getSolutionText().setText(solution);
			  answers.clear();}
			  	}
			  	else{
			  		cardpane.getSolutionText().setText("Please Press Refresh");
			  	}
			  	 long t2=System.currentTimeMillis();
					System.out.println("Solution相应时间:"+(t2-t1));
		  }	  
	}
		
//Experssion和Thinker类的算法参考自：https://blog.csdn.net/u014282557/article/details/70845167

	private	class Experssion{
		/**
		 * 处理数字与运算符的类
		 */
	private ArrayList<Integer>num=new ArrayList<Integer>();//保存数字
	private ArrayList<String> sign=new ArrayList<String>();//保存运算符号
	
	public void add(int n){
		/**
		 * 把数字加入num数组
		 */
		num.add(n);
	}
	public void add(String s){
		/**
		 * 把符号加入sign数组
		 */
		sign.add(s);
	}
	
	private int getPriority(String s){
		/**
		 * 符号运算符优先级
		 * @param s String 符号
		 * @return int 优先级
		 */
		if(sign.equals("+")) return 1;
		if(sign.equals("-")) return 1;
		if(sign.equals("*")) return 2;
		if(sign.equals("/")) return 2;
		return -1;
	}
	private String toString(int la){
		/**
		 * 把表达式输出成按运算顺序,用括号化成的结果
		 * @param la int 判断是第几次运算
		 * @return String 返回表达式
		 */
		if(la==0){//如果是第一次运算就不需要加括号
			return num.get(0)+sign.get(0)+num.get(1);
		}
		else{
			String result=this.toString(la-1);
			if(getPriority(sign.get(la))>=getPriority(sign.get(la-1)))
				result="("+result+")";//如果前一个运算优先级小于等于当前运算,那就需要加括号
			result+=sign.get(la)+num.get(la+1);
			return result;
		}
	}
	
	public String toString(){
		/**
		 * 如果没有参数就默认为最高优先级的运算
		 */
	return toString(2);
	}
	
	public void clear(){
		/**
		 * 清空数组
		 */
		num.clear();
		sign.clear();
	}
	
}
	private	class Thinker{
		/**
		 * 用递归的方法找到符号要求的答案
		 */
	private Experssion exp;
	public Thinker(Experssion expp){
		exp=expp; //传入创建好的Experssion对象
	}
	
	public boolean count(ArrayList<Integer>array,int num, int target){
		/**
		 * 计算出24点正确答案
		 * @param array ArrayList<Integer> 剩余可使用数字
		 * @param num int 剩余操作数量
		 * @param target int 目标结果
		 */
		//如果是最后一步,直接根据符号运算,如果结果为答案,就压入exp.其中减法和除法需要有两种顺序
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
			for(int current=0;current<array.size();current++){//循环剩余数字
				ArrayList<Integer>array1=new ArrayList<Integer>();
				int currentNum=array.get(current);//得到其中一个数字
				for(int i=0;i<array.size();i++){
					if(i!=current){//把其他数字存入array1
						array1.add(array.get(i));
					}
				}
				
				if(count(array1,num-1,target-currentNum)){//如果 currentNum+剩余数字的组合 可以得到目标答案
					exp.add("+");
					exp.add(currentNum);
					if(num==3){				//正好时最外层运算，就直接成为答案
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//否则返回上一层
				}
				if(count(array1,num-1,target+currentNum)){//如果 剩余数字的组合-currentNum 可以得到目标答案
					exp.add("-");
					exp.add(currentNum);
					if(num==3){					//正好时最外层运算，就直接成为答案
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//否则返回上一层
				}
				
				
				if(count(array1,num-1,target*currentNum)){//如果 剩余数字的组合/currentNum 可以得到目标答案
					exp.add("/");
					exp.add(currentNum);
					if(num==3){					//正好时最外层运算，就直接成为答案
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//否则返回上一层
				}
				
				if(target%currentNum==0){//如果 剩余数字的组合*currentNum 可以得到目标答案(首先能被整除)
					if(count(array1,num-1,(int)(target/currentNum))){
						exp.add("*");
						exp.add(currentNum);
						if(num==3){				//正好时最外层运算，就直接成为答案
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;//否则返回上一层
				}
			}
		}
		return false;//如果都没有符合的，就返回失败
	}
}
}
 	public static void main(String[] args) {
		launch(args);
	}
}
