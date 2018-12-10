package Project1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Car extends Pane{
	/**
	 * car类
	 * 继承Pane
	 * 在carPane中加入car的ImageView图片
	 * 设置car移动的timeline
	 */
	private double x=0;						//car坐标
	private ImageView car=getImage("file:src/img/Car.png",50,50);//car图片
	private Timeline animation;				//car动画
	public Car() {
		/**
		 * 无参构造函数
		 * 在Car类设置控件属性
		 */
		getChildren().add(car);//加入car图片
		 animation = new Timeline(//设置动画
		 new KeyFrame(Duration.millis(50), e ->  {
			if(x>=getWidth()) {				//当x加到与屏幕框一样的时，说明开出了框
				x=-car.getFitWidth();		//把坐标回到开始位置	
			}
			else {
				x+=1;						//没开到屏幕外，就继续向右移动
			}
			car.setX(x);					//将改变后的坐标赋给car图片
		 }));
		animation.setCycleCount(Timeline.INDEFINITE);//设置无限循环
	}

	private ImageView getImage(String f,int h,int w) {
		/**
		 * 设置图片
		 * @param f String 图片地址
		 * @param h int 图片高
		 * @param w int 图片宽
		 * @return ImageView 返回设置好的图片
		 */
		Image image = new Image(f);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setFitHeight(h);
        imageView.setFitWidth(w);
		return imageView;	
	}


	 public void play() {
		 /**
		  * 开始播放动画
		  */
		    animation.play();
	}
	 
	public void pause() {
		/**
		 * 暂停动画
		 */
		 	animation.pause();
	}
	public void SetRate(double r) {
		/**
		 * 改变动画速率
		 * @param r double 速率。1最快，100最慢
		 */
		r=r*0.1;
		r=10-r;
	   animation.setRate(r);
}
}
