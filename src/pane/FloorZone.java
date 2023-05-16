package pane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import utils.Config;

public class FloorZone extends GridPane {
	public FloorZone() {
		this.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));
		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
//		floorZone.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));

	}

}