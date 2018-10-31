package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CardPane extends Pane{

	private Button SolutionButton=new Button("Find a Solution");
	private TextField SolutionText = new TextField();

	private Button RefreshButton=new Button("Refresh");
	private ImageView card1=getImage(55);
	private ImageView card2=getImage(56);
	private ImageView card3=getImage(55);
	private ImageView card4=getImage(56);
	private Label label=new Label("Enter an Expression:");
	private TextField AnswerText = new TextField();
	private Button VerifyButton=new Button("Verify");
	private HBox head=new HBox();
	private HBox mid=new HBox();
	private HBox bot=new HBox();
	public CardPane() {
		SolutionText.setEditable(false);
		
		
		head.getChildren().addAll( SolutionButton, SolutionText, RefreshButton);
		head.setSpacing(10);
		head.setAlignment(Pos.CENTER);
		mid.getChildren().addAll( card1,card2,card3,card4);
		mid.setSpacing(10);
		mid.setAlignment(Pos.CENTER);
		bot.getChildren().addAll( label, AnswerText, VerifyButton);
		bot.setSpacing(10);
		bot.setAlignment(Pos.CENTER);
		
	}
	public ImageView getImage(int i) {
		Image image = new Image("file:src/card/"+i+".png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(105);
        return imageView;
	}
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
