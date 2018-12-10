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
	//---------------上部分控件----------------------
	private Button SolutionButton=new Button("Find a Solution");
	private TextField SolutionText = new TextField();
	private Button RefreshButton=new Button("Refresh");
	//---------------中部分控件----------------------	
	private ImageView card1=getImage(55);
	private ImageView card2=getImage(56);
	private ImageView card3=getImage(55);
	private ImageView card4=getImage(56);
	//---------------下部分控件----------------------	
	private Label label=new Label("Enter an Expression:");
	private TextField AnswerText = new TextField();
	private Button VerifyButton=new Button("Verify");
	//---------------保存三个部分控件的HBox-------------
	private HBox head=new HBox();
	private HBox mid=new HBox();
	private HBox bot=new HBox();
	
	
	public CardPane() {
		//-----------设置控件属性并加入HBox--------------
		SolutionText.setEditable(false);//SolutionText显示答案,所以不需要可编辑
		head.getChildren().addAll( SolutionButton, SolutionText, RefreshButton);//上部,加入Solution按钮,Solution文本框,Refresh按钮
		head.setSpacing(10);
		head.setAlignment(Pos.CENTER);
		mid.getChildren().addAll( card1,card2,card3,card4);//中部,加入四张卡片
		mid.setSpacing(10);
		mid.setAlignment(Pos.CENTER);
		bot.getChildren().addAll( label, AnswerText, VerifyButton);//下部,加入提示label,Answer文本框,Verify按钮
		bot.setSpacing(10);
		bot.setAlignment(Pos.CENTER);
		
	}
	public ImageView getImage(int i) {
		/**
		 * 设置卡片图片
		 * @param i int 要显示的卡片图片的序号
		 * @return ImageView 返回设置好的图片
		 */
		Image image = new Image("file:src/card/"+i+".png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(105);
        return imageView;
	}
	
	//-------各个控件的Getter-----------------
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
