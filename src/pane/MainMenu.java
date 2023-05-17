package pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Config;

public class MainMenu extends HBox {
	
	private VBox btnWrapper;
	private Button startBtn, instructionBtn, exitBtn;
	
	public MainMenu() {
//		this.getChildren().add(image);
		initializebtnWrapper();
		this.getChildren().add(btnWrapper);
	}
	
	private void initializebtnWrapper() {
		this.btnWrapper = new VBox(Config.UNIT/2);
		this.btnWrapper.setAlignment(Pos.CENTER);
		this.startBtn = new Button("Start!");
		this.instructionBtn = new Button("Instruction");
		this.exitBtn = new Button("Exit");
		this.btnWrapper.getChildren().addAll(startBtn, instructionBtn, exitBtn);
	}
}
