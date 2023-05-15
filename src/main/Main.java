package main;

import drawing.GamePage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		GamePage gamePage = new GamePage(1200,700);
		
		
		Scene scene = new Scene(root,1200,700);
		
		root.getChildren().add(gamePage);
//        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
//        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
		primaryStage.setTitle("Elevator Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
