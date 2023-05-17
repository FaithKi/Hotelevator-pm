package pane;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Config;

public class MainMenu extends HBox {
	
	private VBox optionWrapper;
	private Button startBtn, instructionBtn, exitBtn;
	
	public MainMenu() {
//		this.getChildren().add(image);
		initializeOptionWrapper();
	}
	
	private void initializeOptionWrapper() {
		this.optionWrapper = new VBox(Config.UNIT/2);
		this.startBtn = new Button("Start!");
		this.instructionBtn = new Button("Instruction");
		this.exitBtn = new Button("Exit");
		this.optionWrapper.getChildren().addAll(startBtn, instructionBtn, exitBtn);
	}
}
