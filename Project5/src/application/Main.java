package application;
	
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	ArrayList<String>answers=new ArrayList<String>();//保存24点所有可能的答案
	CardPane cardpane=new CardPane();				//主要布局，返回三各部分的布局
	int c1,c2,c3,c4=0;								//保存随机出的四个卡片序号
	Random random = new Random();					//随机用
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

	class RefreshHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * 设置Refresh按钮事件，刷新题目
		 */
		  @Override
		  public void handle(ActionEvent e) {
				//随机得到四个不重复的1~52的数字，代表从52张牌中选择4张
			  	do 
				{
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
	  }
	}
	class VerifyHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * 设置Verify按钮事件，确认答案
		 */
		 boolean flag=true;//如果解答中使用了正确的四个数，为True，没有用四个数，或者数值不对，为false
		@Override
		  public void handle(ActionEvent e) {
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
		 try {
			if(isCorrect(answer))//如果判断出结果正常，SolutionText中显示Correct，否则显示wrong
			cardpane.getSolutionText().setText("correct");
			 else
			 cardpane.getSolutionText().setText("wrong");
		} catch (ScriptException e1) {
			//如果表达式不符合规范，抛出异常，SolutionText中显示illegal
			cardpane.getSolutionText().setText("illegal");
		}
		 num.clear();
	  }
		  private boolean isCorrect(String expr) throws ScriptException {
			  /**
			   * 判断输入答案是否正确
			   * @param expr String 要判断的答案的字符串
			   * @return boolean 如果正确返回true，否则为false
			   */
			  //使用ScriptEngineManager，以脚本语言处理方法来读取输入字符串，可以直接算出输入的公式结果，如果不合法会
			  ScriptEngineManager manager = new ScriptEngineManager();
			  ScriptEngine engine = manager.getEngineByName("js");
			  Object result = engine.eval(expr);
			  double ans=Double.parseDouble(result.toString());
			  if(ans==24)
				  return true;
			  else
			  return false;
		  }
	}
	class SolutionHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * (non-Javadoc)
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 * 设置Solution按钮事件，得到题解
		 */
		  @Override
		  public void handle(ActionEvent e) {
			 int index=0;
			  	if(c1!=0) {
			  	Experssion exp= new Experssion();
				Thinker ti=new Thinker(exp);
				ArrayList<Integer> card=new ArrayList<Integer>();
				int sum=24;
				int a1=(c1-1)%13+1;
				int a2=(c2-1)%13+1;
				int a3=(c3-1)%13+1;
				int a4=(c4-1)%13+1;
				card.add(a1);
				card.add(a2);
				card.add(a3);
				card.add(a4);
				ti.count(card,card.size()-1,sum);
				if(answers.size()<=0) {
					 cardpane.getSolutionText().setText("No Answer");
				}else {
			  index=random.nextInt(answers.size());
			  String solution=answers.get(index);
			  cardpane.getSolutionText().setText(solution);
			  answers.clear();}
			  	}
			  	else{
			  		cardpane.getSolutionText().setText("Please Press Refresh");
			  	}
		  }
		  
	}

	class Experssion{
	private ArrayList<Integer>num=new ArrayList<Integer>();
	private ArrayList<String> sign=new ArrayList<String>();
	
	public void add(int n){
		num.add(n);
	}
	
	public void add(String s){
		sign.add(s);
	}
	
	private int getPriority(String s){
		if(sign.equals("+")) return 1;
		if(sign.equals("-")) return 1;
		if(sign.equals("*")) return 2;
		if(sign.equals("/")) return 2;
		return -1;
	}
	private String toString(int la){
		if(la==0){
			return num.get(0)+sign.get(0)+num.get(1);
		}
		else{
			String result=this.toString(la-1);
			if(getPriority(sign.get(la))>=getPriority(sign.get(la-1)))
				result="("+result+")";
			result+=sign.get(la)+num.get(la+1);
			return result;
		}
	}
	
	public String toString(){
		return toString(2);
	}
	
	public void clear(){
		num.clear();
		sign.clear();
	}
	
}
	class Thinker{
	private Experssion exp;
	public Thinker(Experssion expp){
		exp=expp;
	}
	
	public boolean count(ArrayList<Integer>array,int num, int target){
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
			for(int current=0;current<array.size();current++){
				ArrayList<Integer>array1=new ArrayList<Integer>();
				int currentNum=array.get(current);
				for(int i=0;i<array.size();i++){
					if(i!=current){
						array1.add(array.get(i));
					}
				}
				
				if(count(array1,num-1,target-currentNum)){
					exp.add("+");
					exp.add(currentNum);
					if(num==3){
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;
				}
				if(count(array1,num-1,target+currentNum)){
					exp.add("-");
					exp.add(currentNum);
					if(num==3){
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;
				}
				
				
				if(count(array1,num-1,target*currentNum)){
					exp.add("/");
					exp.add(currentNum);
					if(num==3){
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;
				}
				
				if(target%currentNum==0){
					if(count(array1,num-1,(int)(target/currentNum))){
						exp.add("*");
						exp.add(currentNum);
						if(num==3){
						answers.add(exp.toString());
						exp.clear();
					}
					if(num!=3) return true;
				}
			}
		}
		return false;
	}
}
}
 
	public static void main(String[] args) {
		launch(args);
	}
}
