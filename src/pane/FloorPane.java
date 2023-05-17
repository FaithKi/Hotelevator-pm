package pane;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import javafx.geometry.Insets;
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

		this.customerPanes = new ArrayList<CustomerPane>();

		for (int i = 0; i < Config.MAX_CUSTOMER_PER_FLOOR; i++) {
			CustomerPane customerPane = new CustomerPane(i, floorNumber);
			customerPanes.add(customerPane);
		}
		this.getChildren().addAll(customerPanes);

	}

	public void initializeFloorPaneStyle() {
		this.setPrefSize(Config.UNIT * 8.5, Config.UNIT * (1.125));
//		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
//		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelFloorSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));
		this.setSpacing(Config.UNIT * 0.05);
		this.setPadding(new Insets(0, 0, 0, Config.UNIT * 0.2));
	}

}
