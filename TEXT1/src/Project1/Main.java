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
	
	//---------��ʼ���ؼ�----------------------
	private TextField CarText1= new TextField ();		//4�������ٶ��������ENTER���Լ�ʱ�ı��ٶ�
	private TextField CarText2= new TextField ();
	private TextField CarText3= new TextField ();
	private TextField CarText4= new TextField ();
	private Button RaceStart=new Button("Start Race");	//ͬʱ�ı��ٶȵİ�ť���¼�Ϊͬʱ�ı���������
	private Car car1= new Car();						//4������ĳ�ʼ��
	private Car car2= new Car();
	private Car car3= new Car();
	private Car car4= new Car();
	//---------�����ݵı���--------------------
	private double s1=100;//�洢��4�������ٶ������TextField�еõ����ٶȵ�ֵ
	private double s2=100;
	private double s3=100;
	private double s4=100;
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();				//������
			pane.setAlignment(Pos.CENTER);	//�ؼ�����
		    pane.setHgap(5); 				//����ֱ���
	       	pane.setVgap(5); 				//����ˮƽ���
			pane.setPadding(new Insets(10, 10, 10, 10));	//���ñ߿��С
			
			Scene scene = new Scene(pane,509,300);			//��ʼ�����ڴ�С509,300
	
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project1");
			
			pane.add(getHBox(),0,0);						//������������������Ϸ�
			pane.add(car1,0 ,1);							//�������ĸ���������
			pane.add(car2,0 ,2);	
			pane.add(car3,0 ,3);
			pane.add(car4,0 ,4);
			primaryStage.show();	//��ʾ
		}
			catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	private HBox getHBox() {
		/**
		 * ��������������пؼ�������
		 * @return HBox �������������
		 */
		HBox hb=new HBox();
		
		//ÿ��������������ʾ�������
		
		Label CarLabel1 = new Label("Car 1:");//��ʾ����ʾ������
		CarText1.setMaxWidth(50);			  //���������Ŀ��
		CarText1.setPromptText("speed");	  //���������ı���
		CarText1.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {			//�������ENTERʱ�����¼�
				 s1=Double.valueOf(CarText1.getText()); //�õ�������е��ٶ�����
				 if(s1<1)  s1=1;						//��Ϊ�ٶȷ�ΧҪ��Ϊ1~100������100���ж�Ϊ100�����С��1���ж�Ϊ1
				  if(s1>100)  s1=100;							
				  car1.play(); 							//��ʼִ�ж���
				  car1.SetRate(s1);					//�������ٶ�
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
		RaceStart.setOnAction(handler);					//����Restart��ť�¼���һ�θı�ȫ���ĳ����ٶ�
		
		//��HBox�м������Ŀؼ�
		hb.getChildren().addAll( CarLabel1,CarText1,CarLabel2 ,CarText2,CarLabel3,CarText3,CarLabel4 ,CarText4,RaceStart);
		hb.setSpacing(10);//���Ϊ10
		hb.setAlignment(Pos.CENTER);//����
		return hb;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	class ReStartHandlerClass implements EventHandler<ActionEvent> {
		/**
		 * ReStart��ť�¼���һ�θı�ȫ���ĳ����ٶ�
		 */
		  @Override
		  public void handle(ActionEvent e) {
			  //long beginT=System.currentTimeMillis();
			  try {
			  s1=Double.valueOf(CarText1.getText());//�õ�������е��ٶ�����
			  s2=Double.valueOf(CarText2.getText());
			  s3=Double.valueOf(CarText3.getText());
			  s4=Double.valueOf(CarText4.getText());
			  }
			  catch(Exception q) {
				  
			  }
			  if(s1<1)  s1=1;		//��Ϊ�ٶȷ�ΧҪ��Ϊ1~100������100���ж�Ϊ100�����С��1���ж�Ϊ1
			  if(s1>100)  s1=100;
			  if(s2<1)  s2=1;
			  if(s2>100)  s2=100;
			  if(s3<1)  s3=1;
			  if(s3>100)  s3=100;
			  if(s4<1)  s4=1;
			  if(s4>100)  s4=100;
			  car1.SetRate(s1);//�������ٶ�
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