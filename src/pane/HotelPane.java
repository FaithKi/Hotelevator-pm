package pane;

import utils.Config;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class HotelPane extends HBox {
	HBox elevatorZone;
	VBox floorZone;

	public HotelPane() {
		this.elevatorZone = new HBox();
		this.floorZone = new VBox();

		this.setPadding(new Insets(0, Config.UNIT, 0, Config.UNIT));
		this.setPrefSize(Config.UNIT * 15, Config.UNIT * (1.125 * 7));
		this.elevatorZone.setPrefSize((Config.UNIT * 4.5), (Config.UNIT * (1.125 * 7)));
		this.floorZone.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));

		elevatorZone.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		floorZone.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
//		elevatorZone.setBackground(new Background(new BackgroundImage(RenderableHolder.elevatorRailSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));
//		floorZone.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));

//		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, null, null, null, null)));
		this.getChildren().addAll(elevatorZone, floorZone);

	}

}
