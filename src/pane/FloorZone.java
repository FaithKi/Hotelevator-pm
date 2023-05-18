package pane;

import java.util.ArrayList;

import entity.building.CustomerGrid;
import entity.cutomer.BaseCustomer;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;

public class FloorZone extends GridPane {
	private CustomerGrid hotel;
	private Canvas hotelCanvas;
	private GraphicsContext gc;

	public FloorZone() {
		hotel = GameLogic.getInstance().getHotel(); // getHotelInstance from gameLOgic
		initializeCanvas();
		initializeFloorZoneStyle();
		InitializeFloorPane();
	}

	public void InitializeFloorPane() {
		VBox floorPanes = new VBox();
		floorPanes.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (7 * 1.125)));

		for (int i = Config.TOP_FLOOR; i >= 0; i--) {
			FloorPane currentFloorPane = new FloorPane(i);
			floorPanes.getChildren().add(currentFloorPane);
		}

		this.add(floorPanes, 0, 0);
	}

	public void initializeFloorZoneStyle() {
		this.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, null)));

	}

	public void initializeCanvas() {
		this.hotelCanvas = new Canvas(Config.UNIT * (8.5), Config.UNIT * (7 * 1.125));
		this.gc = hotelCanvas.getGraphicsContext2D();

		this.add(hotelCanvas, 0, 0);
		gc.setFill(Color.BLACK);
		gc.strokeRect(0, 20, 0.2 * Config.UNIT, 5);
	}

	public GraphicsContext getGc() {
		return gc;
	}

}