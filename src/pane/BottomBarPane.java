package pane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import utils.Config;

public class BottomBarPane extends HBox {
	public BottomBarPane() {
		this.setPrefSize(Config.UNIT * 16, Config.UNIT * 1.125);
		this.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));

	}
}
 