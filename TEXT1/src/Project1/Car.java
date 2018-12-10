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
	 * car��
	 * �̳�Pane
	 * ��carPane�м���car��ImageViewͼƬ
	 * ����car�ƶ���timeline
	 */
	private double x=0;						//car����
	private ImageView car=getImage("file:src/img/Car.png",50,50);//carͼƬ
	private Timeline animation;				//car����
	public Car() {
		/**
		 * �޲ι��캯��
		 * ��Car�����ÿؼ�����
		 */
		getChildren().add(car);//����carͼƬ
		 animation = new Timeline(//���ö���
		 new KeyFrame(Duration.millis(50), e ->  {
			if(x>=getWidth()) {				//��x�ӵ�����Ļ��һ����ʱ��˵�������˿�
				x=-car.getFitWidth();		//������ص���ʼλ��	
			}
			else {
				x+=1;						//û������Ļ�⣬�ͼ��������ƶ�
			}
			car.setX(x);					//���ı������긳��carͼƬ
		 }));
		animation.setCycleCount(Timeline.INDEFINITE);//��������ѭ��
	}

	private ImageView getImage(String f,int h,int w) {
		/**
		 * ����ͼƬ
		 * @param f String ͼƬ��ַ
		 * @param h int ͼƬ��
		 * @param w int ͼƬ��
		 * @return ImageView �������úõ�ͼƬ
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
		  * ��ʼ���Ŷ���
		  */
		    animation.play();
	}
	 
	public void pause() {
		/**
		 * ��ͣ����
		 */
		 	animation.pause();
	}
	public void SetRate(double r) {
		/**
		 * �ı䶯������
		 * @param r double ���ʡ�1��죬100����
		 */
		r=r*0.1;
		r=10-r;
	   animation.setRate(r);
}
}
