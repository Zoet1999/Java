package Project1;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


 
public class Main extends Application {
	
	//---------初始化控件----------------------
	private TextField CarText1= new TextField ();		//4辆车的速度输入框，用ENTER可以及时改变速度
	private TextField CarText2= new TextField ();
	private TextField CarText3= new TextField ();
	private TextField CarText4= new TextField ();
	private Button RaceStart=new Button("Start Race");	//同时改变速度的按钮，事件为同时改变四辆车的
	private Car car1= new Car();						//4辆车类的初始化
	private Car car2= new Car();
	private Car car3= new Car();
	private Car car4= new Car();
	//---------存数据的变量--------------------
	private double s1=100;//存储从4辆车的速度输入框TextField中得到的速度的值
	private double s2=100;
	private double s3=100;
	private double s4=100;
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();				//主窗口
			pane.setAlignment(Pos.CENTER);	//控件居中
		    pane.setHgap(5); 				//网格垂直间距
	       	pane.setVgap(5); 				//网格水平间距
			pane.setPadding(new Insets(10, 10, 10, 10));	//设置边框大小
			
			Scene scene = new Scene(pane,509,300);			//初始化窗口大小509,300
	
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project1");
			
			pane.add(getHBox(),0,0);						//把输入控制栏放在最上方
			pane.add(car1,0 ,1);							//下面是四个车的赛道
			pane.add(car2,0 ,2);	
			pane.add(car3,0 ,3);
			pane.add(car4,0 ,4);
			primaryStage.show();	//显示
		}
			catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	private HBox getHBox() {
		/**
		 * 设置输入控制栏中控件的属性
		 * @return HBox 返回输入控制栏
		 */
		HBox hb=new HBox();
		
		//每辆车的输入框和提示框的设置
		
		Label CarLabel1 = new Label("Car 1:");//提示框显示的名字
		CarText1.setMaxWidth(50);			  //设置输入框的宽度
		CarText1.setPromptText("speed");	  //设置输入框的背景
		CarText1.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {			//输入框按下ENTER时触发事件
				 s1=Double.valueOf(CarText1.getText()); //得到输入框中的速度数据
				 if(s1<1)  s1=1;						//因为速度范围要求为1~100果大于100则判断为100，如果小于1则判断为1
				  if(s1>100)  s1=100;							
				  car1.play(); 							//开始执行动画
				  car1.SetRate(s1);					//设置新速度
			}
		});
		Label CarLabel2 = new Label("Car 2:");
		CarText2.setMaxWidth(50);
		CarText2.setPromptText("speed");
		CarText2.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s2=Double.valueOf(CarText2.getText());
				  if(s2<1)  s2=1;
				  if(s2>100)  s2=100;
				
				  car2.play(); 
				  car2.SetRate(s2);
			}
		});
		Label CarLabel3 = new Label("Car 3:");
		CarText3.setMaxWidth(50);
		CarText3.setPromptText("speed");
		CarText3.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s3=Double.valueOf(CarText3.getText());
				  if(s3<1)  s3=1;
				  if(s3>100)  s3=100;
				  car3.play(); 
				  car3.SetRate(s3);
			}
		});
		Label CarLabel4 = new Label("Car 4:");
		CarText4.setMaxWidth(50);
		CarText4.setPromptText("speed");
		CarText4.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s4=Double.valueOf(CarText4.getText());
				  if(s4<1)  s4=1;
				  if(s4>100)  s4=100;
				  car4.play(); 
				  car4.SetRate(s4);
			}
		});
		ReStartHandlerClass handler = new  ReStartHandlerClass();
		RaceStart.setOnAction(handler);					//设置Restart按钮事件，一次改变全部的车的速度
		
		//在HBox中加输入框的控件
		hb.getChildren().addAll( CarLabel1,CarText1,CarLabel2 ,CarText2,CarLabel3,CarText3,CarLabel4 ,CarText4,RaceStart);
		hb.setSpacing(10);//间隔为10
		hb.setAlignment(Pos.CENTER);//居中
		return hb;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	class ReStartHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * ReStart按钮事件，一次改变全部的车的速度
		 */
		  @Override
		  public void handle(ActionEvent e) {
			  //long beginT=System.currentTimeMillis();
			  try {
			  s1=Double.valueOf(CarText1.getText());//得到输入框中的速度数据
			  s2=Double.valueOf(CarText2.getText());
			  s3=Double.valueOf(CarText3.getText());
			  s4=Double.valueOf(CarText4.getText());
			  }
			  catch(Exception q) {
				  
			  }
			  if(s1<1)  s1=1;		//因为速度范围要求为1~100果大于100则判断为100，如果小于1则判断为1
			  if(s1>100)  s1=100;
			  if(s2<1)  s2=1;
			  if(s2>100)  s2=100;
			  if(s3<1)  s3=1;
			  if(s3>100)  s3=100;
			  if(s4<1)  s4=1;
			  if(s4>100)  s4=100;
			  car1.SetRate(s1);//设置新速度
			  car2.SetRate(s2);
			  car3.SetRate(s3);
			  car4.SetRate(s4);
			  car1.play(); 			
			  car2.play(); 		  
			  car3.play(); 	  
			  car4.play(); 
			 // long endT=System.currentTimeMillis();
			 // System.out.println(endT-beginT);
	  }
	}
}