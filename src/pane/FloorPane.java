package pane;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import utils.Config;

public class FloorPane extends HBox {
	private int floorNumber;
	private ArrayList<CustomerPane> customerPanes;

	public FloorPane(int floorNumber) {
		// TODO Auto-generated constructor stub
		initializeFloorPaneStyle();
		this.floorNumber = floorNumber;
		this.customerPanes = new ArrayList<CustomerPane>();
		initializeCustomerPane();
	}

	public void initializeCustomerPane() {
		for (int i = 0; i < Config.MAX_CUSTOMER_PER_FLOOR; i++) {
			CustomerPane customerPane = new CustomerPane(i, floorNumber);
			customerPanes.add(customerPane);
		}
		this.getChildren().addAll(customerPanes);
	}

	public void initializeFloorPaneStyle() {
		this.setPrefSize(Config.UNIT * 8.5, Config.UNIT * (1.125));
//		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelFloorSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));
		this.setSpacing(Config.UNIT * 0.05);
		this.setPadding(new Insets(0, 0, 0, Config.UNIT * 0.2));
	}

}
