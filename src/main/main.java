package main;

import utils.Config;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image backgroundImage = new Image(ClassLoader.getSystemResource("gameBackgroundImage.png").toString(),
				Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, true, false);
		ImageView bgImageView = new ImageView(backgroundImage);
		StackPane root = new StackPane();
		root.getChildren().add(bgImageView);

		Scene scene = new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

		stage.setScene(scene);
		stage.setTitle("Elevator TheGame");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
