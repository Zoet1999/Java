package Project5;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CardPane extends Pane{
	//---------------�ϲ��ֿؼ�----------------------
	private Button SolutionButton=new Button("Find a Solution");
	private TextField SolutionText = new TextField();
	private Button RefreshButton=new Button("Refresh");
	//---------------�в��ֿؼ�----------------------	
	private ImageView card1=getImage(55);
	private ImageView card2=getImage(56);
	private ImageView card3=getImage(55);
	private ImageView card4=getImage(56);
	//---------------�²��ֿؼ�----------------------	
	private Label label=new Label("Enter an Expression:");
	private TextField AnswerText = new TextField();
	private Button VerifyButton=new Button("Verify");
	//---------------�����������ֿؼ���HBox-------------
	private HBox head=new HBox();
	private HBox mid=new HBox();
	private HBox bot=new HBox();
	
	
	public CardPane() {
		//-----------���ÿؼ����Բ�����HBox--------------
		SolutionText.setEditable(false);//SolutionText��ʾ��,���Բ���Ҫ�ɱ༭
		head.getChildren().addAll( SolutionButton, SolutionText, RefreshButton);//�ϲ�,����Solution��ť,Solution�ı���,Refresh��ť
		head.setSpacing(10);
		head.setAlignment(Pos.CENTER);
		mid.getChildren().addAll( card1,card2,card3,card4);//�в�,�������ſ�Ƭ
		mid.setSpacing(10);
		mid.setAlignment(Pos.CENTER);
		bot.getChildren().addAll( label, AnswerText, VerifyButton);//�²�,������ʾlabel,Answer�ı���,Verify��ť
		bot.setSpacing(10);
		bot.setAlignment(Pos.CENTER);
		
	}
	public ImageView getImage(int i) {
		/**
		 * ���ÿ�ƬͼƬ
		 * @param i int Ҫ��ʾ�Ŀ�ƬͼƬ�����
		 * @return ImageView �������úõ�ͼƬ
		 */
		Image image = new Image("file:src/card/"+i+".png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(105);
        return imageView;
	}
	
	//-------�����ؼ���Getter-----------------
	public HBox getHead() {
		return head;
	}
	public HBox getMid() {
		return mid;
	}
	public HBox getBot() {
		return bot;
	}
	public Button getSolutionButton() {
		return SolutionButton;
	}
	public TextField getSolutionText() {
		return SolutionText;
	}
	public Button getRefreshButton() {
		return RefreshButton;
	}
	public ImageView getCard1() {
		return card1;
	}
	public ImageView getCard2() {
		return card2;
	}
	public ImageView getCard3() {
		return card3;
	}
	public ImageView getCard4() {
		return card4;
	}
	public TextField getAnswerText() {
		return AnswerText;
	}
	public Button getVerifyButton() {
		return VerifyButton;
	}
}
