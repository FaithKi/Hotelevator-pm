package pane;

import java.util.ArrayList;

import entity.building.CustomerGrid;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;

public class FloorZone extends GridPane {
	private Canvas hotelCanvas;
	private GraphicsContext gc;

	public FloorZone() {
		initializeCanvas();
		initializeFloorZoneStyle();
		initializeClickableGridGetterPanes();
	}

	public void initializeClickableGridGetterPanes() {
		VBox floorPanes = new VBox();
		floorPanes.setPrefSize((Config.UNIT * 8.5), (Config.UNIT * (7 * 1.125)));

		for (int floor = Config.TOP_FLOOR; floor >= 0; floor--) {

			HBox floorPane = new HBox();
			floorPane.setPrefSize(Config.UNIT * 8.5, Config.UNIT * (1.125));
			floorPane.setSpacing(Config.UNIT * 0.05);
			floorPane.setPadding(new Insets(0, 0, 0, Config.UNIT * 0.2));

			for (int queue = 0; queue < Config.MAX_CUSTOMER_PER_FLOOR; queue++) {
				GridPane customerGridPane = createCustomerPane(queue, floor);
				floorPane.getChildren().add(customerGridPane);
			}
			floorPanes.getChildren().add(floorPane);
		}

		this.add(floorPanes, 0, 0);
	}

	private GridPane createCustomerPane(int queue, int floor) {
		GridPane customerGridPane = new GridPane();

		customerGridPane.setPrefSize(Config.UNIT * 0.75, Config.UNIT * 1.125);
		customerGridPane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2)), null, null));

		customerGridPane.setOnMouseClicked((e) -> {
			Integer[] pos = { queue, floor };
			InputUtility.setHotelGridPressed(pos, true);
		});

		customerGridPane.setOnMouseEntered(event -> {
			customerGridPane.setCursor(Cursor.HAND);
		});

		customerGridPane.setOnMouseExited(event -> {
			customerGridPane.setCursor(Cursor.DEFAULT);
		});

		return customerGridPane;
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
	}

	public GraphicsContext getGc() {
		return gc;
	}

}