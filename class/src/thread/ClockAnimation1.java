package thread;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ClockAnimation1 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	Button btnContinue=new Button("Continue");
	Button btnPause=new Button("Pause");
	HBox hb=new HBox();
	hb.getChildren().addAll(btnPause,btnContinue);
	hb.setAlignment(Pos.CENTER);
    ClockPane clock = new ClockPane(); // Create a clock
    clock.setMinWidth(100);
    clock.setMinHeight(100);
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    btnPause.setOnAction(e->{
    	animation.pause();
    });
    btnContinue.setOnAction(e->{
    	animation.play();
    	});
    VBox pane=new VBox();
    pane.getChildren().addAll(clock,hb);
    pane.setAlignment(Pos.CENTER);
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
