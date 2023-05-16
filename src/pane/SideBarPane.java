package pane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.Config;

public class SideBarPane extends VBox {
	public SideBarPane() {
		this.setPrefSize(Config.UNIT * 1, Config.UNIT * (7 * 1.125));
		this.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

	}
}
