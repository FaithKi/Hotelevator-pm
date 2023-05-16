package pane;

import java.util.ArrayList;

import entity.building.Hotel;
import entity.cutomer.BaseCustomer;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import utils.Config;

public class FloorZone extends VBox {
	private Hotel hotel;
	private ArrayList<FloorPane> floorsPane;

	public FloorZone() {
		initializeFloorZoneStyle();

		hotel = new Hotel(); // getHotelInstance from RenderAbleHolder
		this.floorsPane = new ArrayList<>();

		ArrayList<ArrayList<BaseCustomer>> hotelFloors = hotel.getFloors();
		for (int i = 1; i < hotelFloors.size() + 1; i++) {
			ArrayList<BaseCustomer> hotelFloor = hotelFloors.get(i - 1); // arrayList<BaseCustomer>
			FloorPane currentFloorPane = new FloorPane(i, hotelFloor);
			floorsPane.add(currentFloorPane);
		}

		this.getChildren().addAll(floorsPane);
	}

	public void InitializeFloorPane() {

	}

	public void initializeFloorZoneStyle() {
		this.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));
//		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, null)));

	}
}
