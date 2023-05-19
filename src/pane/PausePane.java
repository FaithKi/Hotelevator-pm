package pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.game.GameLogic;
import utils.Config;

public class PausePane extends VBox{

	private Button resumeBtn,mainMenuBtn;
	
	public PausePane() {
		this.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,0,0.8),null,null)));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(Config.UNIT*0.5);
		initializeResumeBtn();
		initializeMainMenuBtn();
	}
	
	public void initializeResumeBtn() {
		this.resumeBtn = new Button("Resume");
		this.getResumeBtn().setFont(new Font("Arial",30));
		this.getChildren().add(this.getResumeBtn());
		this.getResumeBtn().setOnMouseClicked((e) -> {
			GameLogic.getInstance().getCustomerGenerator().play();
			this.getParent().getChildrenUnmodifiable().get(1).requestFocus();
			this.setVisible(false);
		});
	}
	
	public void initializeMainMenuBtn() {
		this.mainMenuBtn = new Button("Main Menu");
		this.getMainMenuBtn().setFont(new Font("Arial",30));
		this.getMainMenuBtn().setOnAction((e) -> {
			GameLogic.getInstance().setGameOver(true);
			this.setVisible(false);
			this.getParent().getScene().setRoot(MainMenu.getInstance());
		});
		this.getChildren().add(mainMenuBtn);
	}

	public Button getResumeBtn() {
		return resumeBtn;
	}

	public Button getMainMenuBtn() {
		return mainMenuBtn;
	}
}
