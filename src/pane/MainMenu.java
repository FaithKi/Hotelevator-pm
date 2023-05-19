package pane;


import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;

public class MainMenu extends StackPane {

	private VBox btnWrapper;
	private Button startBtn, instructionBtn, exitBtn;
	private ImageView gameTitle;
	private static MainMenu instance = new MainMenu();

	public MainMenu() {
//		this.getChildren().add(image);
		this.gameTitle = new ImageView(RenderableHolder.gameName);
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.bgSprite, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
		initializebtnWrapper();
		this.getChildren().add(btnWrapper);
		this.getChildren().add(gameTitle);
		setAlignment(gameTitle,Pos.TOP_CENTER);
		setMargin(gameTitle, new Insets(Config.UNIT*2, 0, 0, 0));
		setAlignment(btnWrapper,Pos.CENTER);
		setMargin(btnWrapper, new Insets(Config.UNIT*1.8, 0, 0, 0));
	}

	public static MainMenu getInstance() {
		return instance;
	}

	private void initializebtnWrapper() {
		this.btnWrapper = new VBox(Config.UNIT / 2);
		this.btnWrapper.setAlignment(Pos.CENTER);
		initializeStart();
		initializeInstruction();
		initializeExit();
		this.btnWrapper.getChildren().addAll(startBtn, instructionBtn, exitBtn);
	}
	
	private void initializeStart() {
		this.startBtn = new Button("Start");
		this.startBtn.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 38));
		this.startBtn.setBackground(new Background(new BackgroundImage(RenderableHolder.startBg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
		this.startBtn.setTextFill(Color.rgb(94, 106, 111));
		this.startBtn.setOnMouseEntered((e) -> {
			this.startBtn.setTextFill(Color.rgb(231, 140, 156));
		});
		this.startBtn.setOnMouseExited((e) -> {
			this.startBtn.setTextFill(Color.rgb(94, 106, 111));
		});
		this.startBtn.setOnAction((e) -> {
			GameScreen gameScreen = new GameScreen();
			this.getScene().setRoot(gameScreen);
			gameScreen.getContainerPane().requestFocus();
			GameLogic logic = GameLogic.getInstance();
			AnimationTimer animation = new AnimationTimer() {

				@Override
				public void handle(long arg0) {
					// TODO Auto-generated method stub
					// timer from GPT
					if(!gameScreen.getPausePane().isVisible()) {
						gameScreen.getContainerPane().paintComponent();
						logic.logicUpdate();
						if (logic.isGameOver()) {
							gameScreen.getContainerPane().paintComponent();
							logic.logicUpdate();
							logic.resetInstance();
							this.stop();
						}
					}
				}

			};
			animation.start();
		});
	}
	
	private void initializeExit() {
		this.exitBtn = new Button("Exit");
		this.exitBtn.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 20));
		this.exitBtn.setBackground(new Background(new BackgroundImage(RenderableHolder.exitBg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
		this.exitBtn.setTextFill(Color.rgb(94, 106, 111));
		this.exitBtn.setOnMouseEntered((e) -> {
			this.exitBtn.setTextFill(Color.rgb(231, 140, 156));
		});
		this.exitBtn.setOnMouseExited((e) -> {
			this.exitBtn.setTextFill(Color.rgb(94, 106, 111));
		});
		this.exitBtn.setOnAction((e) -> {
			Platform.exit();
		});
	}
	
	private void initializeInstruction() {
		this.instructionBtn = new Button("Instruction");
		this.instructionBtn.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 20));
		this.instructionBtn.setBackground(new Background(new BackgroundImage(RenderableHolder.instBg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
		this.instructionBtn.setTextFill(Color.rgb(94, 106, 111));
		this.instructionBtn.setOnMouseEntered((e) -> {
			this.instructionBtn.setTextFill(Color.rgb(231, 140, 156));
		});
		this.instructionBtn.setOnMouseExited((e) -> {
			this.instructionBtn.setTextFill(Color.rgb(94, 106, 111));
		});
	}

}
