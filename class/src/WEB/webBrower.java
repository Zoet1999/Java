package WEB;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class webBrower extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane pane =new GridPane();
		pane.setAlignment(Pos.CENTER);	//控件居中
	    pane.setHgap(5); 				//网格垂直间距
       	pane.setVgap(5); 				//网格水平间距
		pane.setPadding(new Insets(10, 10, 10, 10));	//设置边框大小
		
		Label lb=new Label("Address:  ");
		TextField tx=new TextField();

		HBox hb=new HBox();
		hb.getChildren().addAll(lb,tx);
		WebView wv=new WebView();
		wv.setMinWidth(1000);
		wv.setMinHeight(680);
		pane.add(hb,0,0);
		pane.add(wv,0,1);
		tx.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
	
				WebEngine webEngine = wv.getEngine();
				webEngine.load("http://"+tx.getText().toString());
				
			}	
		});
		Scene scene = new Scene(pane,1024,720);			//初始化窗口大小509,300
		
		primaryStage.setScene(scene);
		
		primaryStage.show();	//显示
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
