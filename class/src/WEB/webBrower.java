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
		pane.setAlignment(Pos.CENTER);	//�ؼ�����
	    pane.setHgap(5); 				//����ֱ���
       	pane.setVgap(5); 				//����ˮƽ���
		pane.setPadding(new Insets(10, 10, 10, 10));	//���ñ߿��С
		
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
		Scene scene = new Scene(pane,1024,720);			//��ʼ�����ڴ�С509,300
		
		primaryStage.setScene(scene);
		
		primaryStage.show();	//��ʾ
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
