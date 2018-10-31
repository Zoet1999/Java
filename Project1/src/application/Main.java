package application;
	

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
	TextField CarText1= new TextField ();
	TextField CarText2= new TextField ();
	TextField CarText3= new TextField ();
	TextField CarText4= new TextField ();
	Button RaceStart=new Button("Start Race");
	Car car1= new Car();
	Car car2= new Car();
	Car car3= new Car();
	Car car4= new Car();
	
	GridPane pane = new GridPane();
	double s1=0;
	double s2=0;
	double s3=0;
	double s4=0;
	@Override
	public void start(Stage primaryStage) {
		try {
			pane.setAlignment(Pos.CENTER);
		    pane.gridLinesVisibleProperty();
		    pane.setHgap(5);
			pane.setVgap(5);
	        //网格垂直间距
	        //网格水平间距
			
			pane.setPadding(new Insets(10, 10, 10, 10));
			
			Scene scene = new Scene(pane,509,300);
	
			primaryStage.setScene(scene);
		
			primaryStage.setTitle("Project1");
			
			pane.add(getHBox(),0,0);
			pane.add(car1,0 ,1);
			pane.add(car2,0 ,2);
			pane.add(car3,0 ,3);
			pane.add(car4,0 ,4);
			primaryStage.show();

		}
			catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	private HBox getHBox() {
		HBox hb=new HBox();
		Label CarLabel1 = new Label("Car 1:");
		CarText1.setMaxWidth(50);
		CarText1.setPromptText("speed");
		CarText1.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s1=Double.valueOf(CarText1.getText());
				 if(s1>1)  s1=1;
				  if(s1<0)  s1=0;
				  car1.play(); 
				  car1.SetRate(s1*10);
			}
		});
		Label CarLabel2 = new Label("Car 2:");
		CarText2.setMaxWidth(50);
		CarText2.setPromptText("speed");
		CarText2.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s2=Double.valueOf(CarText2.getText());
				  if(s2>1)  s2=1;
				  if(s2<0)  s2=0;
				
				  car2.play(); 
				  car2.SetRate(s2*10);
			}
		});
		Label CarLabel3 = new Label("Car 3:");
		CarText3.setMaxWidth(50);
		CarText3.setPromptText("speed");
		CarText3.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s3=Double.valueOf(CarText3.getText());
				  if(s3>1)  s3=1;
				  if(s3<0)  s3=0;
		
				  car3.play(); 
				  car3.SetRate(s3*10);
			}
		});
		Label CarLabel4 = new Label("Car 4:");
		CarText4.setMaxWidth(50);
		CarText4.setPromptText("speed");
		CarText4.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				 s4=Double.valueOf(CarText4.getText());
				  if(s4>1)  s4=1;
				  if(s4<0)  s4=0;
				  car4.play(); 
				  car4.SetRate(s4*10);
			}
		});
		ReStartHandlerClass handler = new  ReStartHandlerClass();
		RaceStart.setOnAction(handler);
		
		hb.getChildren().addAll( CarLabel1,CarText1,CarLabel2 ,CarText2,CarLabel3,CarText3,CarLabel4 ,CarText4,RaceStart);
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER);
		return hb;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	class ReStartHandlerClass implements EventHandler<ActionEvent> {
		  @Override
		  public void handle(ActionEvent e) {
			  s1=Double.valueOf(CarText1.getText());
			  s2=Double.valueOf(CarText2.getText());
			  s3=Double.valueOf(CarText3.getText());
			  s4=Double.valueOf(CarText4.getText());
			  if(s1>1)  s1=1;
			  if(s1<0)  s1=0;
			  if(s2>1)  s2=1;
			  if(s2<0)  s2=0;
			  if(s3>1)  s3=1;
			  if(s3<0)  s3=0;
			  if(s4>1)  s4=1;
			  if(s4<0)  s4=0;
			  car1.SetRate(s1*10);
			  car2.SetRate(s2*10);
			  car3.SetRate(s3*10);
			  car4.SetRate(s4*10);
			  car1.play(); 
			  car2.play(); 		  
			  car3.play(); 	  
			  car4.play(); 
	  }
	}
}