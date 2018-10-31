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
	ArrayList<String>answers=new ArrayList<String>();
	CardPane cardpane=new CardPane();
	int c1,c2,c3,c4=0;
	 int v1,v2,v3,v4=0;
	Random random = new Random();
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			GridPane root = new GridPane();
			 root.gridLinesVisibleProperty();
			root.setHgap(20);
			root.setVgap(20);
			root.setAlignment(Pos.CENTER);
			root.add(cardpane.getHead(),0,0);
			root.add(cardpane.getMid(),0,1);
			root.add(cardpane.getBot(),0,2);
		
			SolutionHandlerClass Solutionhandler = new  SolutionHandlerClass();
			cardpane.getSolutionButton().setOnAction(Solutionhandler);
			RefreshHandlerClass Refreshhandler = new  RefreshHandlerClass();
			cardpane.getRefreshButton().setOnAction(Refreshhandler);
			VerifyHandlerClass Verifyhandler = new  VerifyHandlerClass();
			cardpane.getVerifyButton().setOnAction(Verifyhandler);
			
			
			root.setPadding(new Insets(10, 10, 10, 10));
			Scene scene = new Scene(root,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	class RefreshHandlerClass implements EventHandler<ActionEvent> {
		  @Override
		  public void handle(ActionEvent e) {
				do 
				{
				c1 = random.nextInt(52)+1;
			    c2 = random.nextInt(52)+1;
			    c3 = random.nextInt(52)+1;
			    c4 = random.nextInt(52)+1;
				}
				while(c1==c2||c1==c3||c1==c4||c2==c3||c2==c4||c3==c4); 
			    System.out.println(c1+" "+c2+" "+c3+" "+c4);
			  cardpane.getCard1().setImage(new Image("file:src/card/"+c1+".png"));
			  cardpane.getCard2().setImage(new Image("file:src/card/"+c2+".png"));
			  cardpane.getCard3().setImage(new Image("file:src/card/"+c3+".png"));
			  cardpane.getCard4().setImage(new Image("file:src/card/"+c4+".png"));	 
			  cardpane.getSolutionText().setText("");
	  }
	}
	class VerifyHandlerClass implements EventHandler<ActionEvent> {
		 boolean flag=true;
		  int level=0;
		@Override
		  public void handle(ActionEvent e) {
		int a1=(c1-1)%13+1;
		int a2=(c2-1)%13+1;
		int a3=(c3-1)%13+1;
		int a4=(c4-1)%13+1;
		String answer =cardpane.getAnswerText().getText();
		 ArrayList<Integer> num=new ArrayList<Integer>();
		  for(int i=0;i<answer.length();i++) {
			  switch(answer.charAt(i)) {
			  case '0':
				  num.add(0);
				  break;
			  case '1':
				  if(i+1<answer.length())
				  if(answer.charAt(i+1)=='0'||answer.charAt(i+1)=='1'||answer.charAt(i+1)=='2'||answer.charAt(i+1)=='3')
					  {
					  num.add(10+answer.charAt(i+1)-48);
					  i++;
					  }
				  else 
					  num.add(1);
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
		  System.out.println(num.get(0).intValue()+" "+num.get(1).intValue()+" "+num.get(2).intValue()+" "+num.get(3).intValue());
			  if(num.size()!=4) {
			  cardpane.getSolutionText().setText("use wrong nums");
			  flag=false;
		 }else
		  for(int i=0;i<4;i++) {
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
		 if(flag)
		 try {
			if(isCorrect(answer))
			cardpane.getSolutionText().setText("correct");
			 else
			 cardpane.getSolutionText().setText("error");
		} catch (ScriptException e1) {
			cardpane.getSolutionText().setText("illegal");
		}
		 num.clear();
	  }
		  private boolean isCorrect(String expr) throws ScriptException {
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
