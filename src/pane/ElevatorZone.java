package pane;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import utils.Config;

public class ElevatorZone extends HBox {
	private Canvas shaft1,shaft2,shaft3;
	
	
	public ElevatorZone() {
		this.setPrefSize((Config.UNIT * 4.5), (Config.UNIT * (1.125 * 7)));
		this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		initializeShafts();
	}
	
	public void initializeShafts() {
		shaft1 = new Canvas();
		shaft2 = new Canvas();
		shaft3 = new Canvas();
		
		this.getChildren().addAll(shaft1,shaft2,shaft3);
	}
}
