package pane;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.SoundUtils;

public class PausePane extends VBox {

	private Button resumeBtn, mainMenuBtn;

	public PausePane() {
		this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.8), null, null)));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(Config.UNIT * 0.5);
		initializeResumeBtn();
		initializeMainMenuBtn();
	}

	public void initializeResumeBtn() {
		this.resumeBtn = new Button("Resume");
		this.getResumeBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 30));
		this.getChildren().add(this.getResumeBtn());
		this.getResumeBtn().setOnMouseClicked((e) -> {
			RenderableHolder.gameSoundTrack.setVolume(0.03);
			GameLogic.getInstance().getCustomerGenerator().play();
			this.getParent().getChildrenUnmodifiable().get(1).requestFocus();
			this.setVisible(false);
		});

		this.getResumeBtn().setOnMouseEntered((e) -> {
			SoundUtils.playTrack(RenderableHolder.buttonHoverTrack, 0.3);
			this.getResumeBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 36));
			this.getResumeBtn().setCursor(Cursor.HAND);
		});

		this.getResumeBtn().setOnMouseExited((e) -> {
			this.getResumeBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 30));
			this.getResumeBtn().setCursor(Cursor.DEFAULT);

		});
	}

	public void initializeMainMenuBtn() {
		this.mainMenuBtn = new Button("Main Menu");
		this.getMainMenuBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 30));
		this.getMainMenuBtn().setOnAction((e) -> {
			RenderableHolder.gameSoundTrack.setVolume(0.03);
			GameLogic.getInstance().setGameOver(true);
			this.setVisible(false);
			this.getParent().getScene().setRoot(MainMenu.getInstance());
		});

		this.getMainMenuBtn().setOnMouseEntered((e) -> {
			SoundUtils.playTrack(RenderableHolder.buttonHoverTrack, 0.3);
			this.getMainMenuBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 36));
			this.getMainMenuBtn().setCursor(Cursor.HAND);
		});

		this.getMainMenuBtn().setOnMouseExited((e) -> {
			this.getMainMenuBtn().setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 30));
			this.getMainMenuBtn().setCursor(Cursor.DEFAULT);
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
