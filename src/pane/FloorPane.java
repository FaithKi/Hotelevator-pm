package pane;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import utils.Config;

public class FloorPane extends HBox {
	private int floorNumber;
	private ArrayList<CustomerPane> customerPanes;
	private ArrayList<BaseCustomer> customers;

	public FloorPane(int floorNumber, ArrayList<BaseCustomer> hotelFloor) {
		// TODO Auto-generated constructor stub
		initializeFloorPaneStyle();

		this.floorNumber = floorNumber;

	}

	public void initializeFloorPaneStyle() {
		this.setPrefSize(Config.UNIT * 8.5, Config.UNIT * (1.125));
//		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelFloorSprite,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));
	}
}
