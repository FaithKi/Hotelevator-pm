package pane;

import java.util.ArrayList;

import entity.building.Hotel;
import entity.cutomer.BaseCustomer;
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

public class FloorZone extends StackPane {
	private Hotel hotel;
	private VBox hotelPane;
	private ArrayList<FloorPane> floorsPane;
	private Canvas hotelCanvas;
	private GraphicsContext gc;

	public FloorZone() {
		initializeFloorZoneStyle();
		InitializeFloorPane();

		initializeCanvas();
	}

	public void InitializeFloorPane() {

		this.hotelPane = new VBox();
		hotelPane.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));

		hotel = GameLogic.getInstance().getHotel(); // getHotelInstance from RenderAbleHolder
		this.floorsPane = new ArrayList<>();
		ArrayList<ArrayList<BaseCustomer>> hotelFloors = hotel.getFloors();
		for (int i = 1; i < hotelFloors.size() + 1; i++) {
			ArrayList<BaseCustomer> hotelFloor = hotelFloors.get(i - 1); // arrayList<BaseCustomer>
			FloorPane currentFloorPane = new FloorPane(i, hotelFloor);
			floorsPane.add(currentFloorPane);
		}

		hotelPane.getChildren().addAll(floorsPane);

		this.getChildren().add(hotelPane);
	}

	public void initializeFloorZoneStyle() {
		this.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));
//		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, null)));

	}

	public void initializeCanvas() {
		this.hotelCanvas = new Canvas(Config.UNIT * (8.5), Config.UNIT * (7 * 1.125));
		this.gc = hotelCanvas.getGraphicsContext2D();

		this.getChildren().add(hotelCanvas);
//		gcHotel.setFill(Color.BLACK);
//		gcHotel.fillRect(0, 0, hotelCanvas.getWidth(), hotelCanvas.getHeight());
	}

	public GraphicsContext getGc() {
		return gc;
	}

}
