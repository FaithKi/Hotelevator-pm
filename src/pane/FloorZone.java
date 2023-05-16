package pane;

import java.util.ArrayList;

import entity.building.Hotel;
import entity.cutomer.BaseCustomer;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import utils.Config;

public class FloorZone extends GridPane {
	private Hotel hotel = new Hotel();
	private ArrayList<FloorPane> floorsPane;

	public FloorZone() {
		this.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (1.125 * 7)));
//		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null, null)));
		ArrayList<ArrayList<BaseCustomer>> hotelFloors = hotel.getFloors();
		for (int i = 1; i < hotelFloors.size()+1; i++) {
//			hotelFloors.get(i)
			
		}
	}

	public void InitializeFloorPane() {

	}
}
