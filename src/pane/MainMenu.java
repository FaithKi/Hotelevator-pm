package pane;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.game.GameLogic;
import utils.Config;

public class MainMenu extends HBox {

	private VBox btnWrapper;
	private Button startBtn, instructionBtn, exitBtn;
	private static MainMenu instance = new MainMenu();

	public MainMenu() {
//		this.getChildren().add(image);
		initializebtnWrapper();
		this.getChildren().add(btnWrapper);
	}

	public static MainMenu getInstance() {
		return instance;
	}

	private void initializebtnWrapper() {
		this.btnWrapper = new VBox(Config.UNIT / 2);
		this.btnWrapper.setAlignment(Pos.CENTER);
		this.startBtn = new Button("Start!");
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
					gameScreen.getContainerPane().paintComponent();
					logic.logicUpdate();
					if (logic.isGameOver()) {
						gameScreen.getContainerPane().paintComponent();
						logic.logicUpdate();
						logic.resetInstance();
						this.stop();
					}
				}

			};
			animation.start();
		});
		this.instructionBtn = new Button("Instruction");
		this.exitBtn = new Button("Exit");
		this.exitBtn.setOnAction((e) -> {
			Platform.exit();
		});
		this.btnWrapper.getChildren().addAll(startBtn, instructionBtn, exitBtn);
	}

}
