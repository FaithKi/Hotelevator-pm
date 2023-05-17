package main;

import utils.Config;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.game.GameLogic;
import pane.ContainerPane;
import pane.PausePane;

public class Main extends Application {
	private long startTime;
	public static double elapsedTimeMilliSeconds;

	@Override
	public void start(Stage stage) throws Exception {
		Image backgroundImage = new Image(ClassLoader.getSystemResource("gameBackgroundImage.png").toString(),
				Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, true, false);
		ImageView bgImageView = new ImageView(backgroundImage);

		ContainerPane containerPane = new ContainerPane();
		/// ---///
		PausePane pausePane = new PausePane();
		pausePane.setVisible(false);
		/// ---///
		StackPane root = new StackPane();
		root.getChildren().addAll(bgImageView, containerPane, pausePane);

		Scene scene = new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		containerPane.requestFocus();

		GameLogic logic = GameLogic.getInstance();

		stage.setScene(scene);
		stage.setTitle("Elevator TheGame");
		stage.setResizable(false);
		stage.show();
		startTime = System.nanoTime();
		AnimationTimer animation = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				// timer from GPT
				long elapsedTime = arg0 - startTime;
				elapsedTimeMilliSeconds = elapsedTime / 1_000_000.0;
				containerPane.paintComponent();
				logic.logicUpdate();
			}

		};
		animation.start();
	}

	public static void main(String[] args) {
		launch();
	}

	public static double getElapsedTimeMilliSeconds() {
		return elapsedTimeMilliSeconds;
	}

}
