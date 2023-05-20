package main;

import utils.Config;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.game.GameLogic;
import pane.ContainerPane;
import pane.GameScreen;
import pane.MainMenu;
import pane.PausePane;
import sharedObject.RenderableHolder;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		MainMenu mainMenu = MainMenu.getInstance();
		Scene scene = new Scene(mainMenu, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

		stage.setScene(scene);
		stage.setTitle("Hotelevator");
		stage.setResizable(false);
		stage.show();

		RenderableHolder.gameSoundTrack.play();

	}

	public static void main(String[] args) {
		launch();
	}
}
