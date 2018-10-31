package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Car extends Pane{
	private double x=0;
	private ImageView car=getImage("file:src/img/Car.png",50,50);
	private Timeline animation;
	public Car() {
		getChildren().add(car);
		 animation = new Timeline(
		 new KeyFrame(Duration.millis(50), e ->  {
			if(x>=getWidth()) {
				x=-car.getFitWidth();
				//pause();
			}
			else {
				x+=1;
			}
			car.setX(x);
		 }));
		animation.setCycleCount(Timeline.INDEFINITE);
		
		//play();
	}

	private ImageView getImage(String f,int h,int w) {
		Image image = new Image(f);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setFitHeight(h);
        imageView.setFitWidth(w);
		return imageView;	
	}
	public Timeline getAnimation() {
			return animation;
	}
	public void setAnimation(Timeline animation) {
			this.animation = animation;
	}
	public ImageView getCar() {
		return car;
	}
	 public void play() {
		    animation.play();
	}
	 
	public void pause() {
		 	animation.pause();
	}
	public void SetRate(double r) {
	   animation.setRate(r);
}
	public DoubleProperty rateProperty() {
		    return animation.rateProperty();
	}
}
