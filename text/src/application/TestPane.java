package application;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
 
/**
 *
 * @author wing
 */
public class TestPane extends Pane{
    private ParallelTransition mAnimList;
    
    private Timeline timeline;
    
    private HBox hBox;
    private ToggleButton start, pause, stop;
    private ToggleGroup btnGroup;
    
    private double duration = 200;
    public TestPane(){
        btnGroup = new ToggleGroup();
        start = new ToggleButton("Start");
        start.setToggleGroup(btnGroup);
        start.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent arg0) {
                timeline.play();
                checkUIState();
            }
        });
        
        pause = new ToggleButton("Pause");
        pause.setToggleGroup(btnGroup);
        pause.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent arg0) {
                timeline.pause();
                checkUIState();
            }
        });       
 
        stop = new ToggleButton("Stop");
        stop.setToggleGroup(btnGroup);
        stop.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent arg0) {
                timeline.stop();
                checkUIState();
            }
        });   
        
        hBox = new HBox(10);
        hBox.getChildren().addAll(start, pause, stop);
        
        hBox.setTranslateX((Main.WIDTH - 200) / 2);
        hBox.setTranslateY(20);
        
        getChildren().add(hBox);
        
        
        timeline = new Timeline();
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                createObject();
            }
        });
        timeline.getKeyFrames().add(keyFrame);
    }
    
    /**
     * ���start pause stop������ť��״̬
     */
    public void checkUIState(){
        start.setDisable(false);
        pause.setDisable(false);
        stop.setDisable(false);
        switch(timeline.getStatus()){
            case RUNNING:
                start.setDisable(true);
                break;
            case PAUSED:
                pause.setDisable(true);
                break;
            case STOPPED:
                stop.setDisable(true);
                break;
        }
    }
    
    
    /**
     * ����һ��Object ��ִ�ж���,�����ﴴ����һ��ParallelTransition��������������������������ƽ�Ƶ�TranslateTransition��͸�����𽥱�Ϊ0��FadeTransition���𽥷Ŵ�0.2����ScaleTransition�����մ�����Object������������������ParallelTransition�󶨣�Ȼ��ִ��ParallelTransition��
     */
    public void createObject() {
        double width = Math.max(50, Math.random() * 200);
        double height = Math.max(50, Math.random() * 200);        
        double x = Math.min(Math.random() * Main.WIDTH, Main.WIDTH - width);
        double y = Math.max(Math.random() * (Main.HEIGHT - 100), 100);
        
        double dx = Math.random() * 50;
        double dy = Math.random() * 50;
        final Shape shape = new Circle(x, y, width / 2);
        shape.setEffect(new Bloom(50));
        shape.setFill(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        getChildren().add(shape);
        
        
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setByX(200f);
        tt.setCycleCount(0);
        tt.setAutoReverse(true);
        //tt.play();
        
        mAnimList = new ParallelTransition(
                shape,tt 		);
        mAnimList.play();
        mAnimList.setOnFinished(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent arg0) {
                getChildren().remove(shape);
            }
        });
    }
}