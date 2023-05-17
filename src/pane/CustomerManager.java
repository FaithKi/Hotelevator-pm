package pane;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import entity.elevator.Elevator;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;

public class CustomerManager extends StackPane {
	private Canvas customerManagerCanvas;
	private GraphicsContext gc;
	private ArrayList<BaseCustomer> passengers;

	private final GameLogic logic = GameLogic.getInstance();

	public CustomerManager() {//ArrayList<BaseCustomer> passengers

		initializeCustomerManagerStyle();
		initializeCanvas();
		InitializeCabinPane();

	}

	public void InitializeCabinPane() {
		HBox cabinPaneHolder = new HBox();
		cabinPaneHolder.setPrefSize(Config.UNIT * (14), Config.UNIT * (1.125));
		cabinPaneHolder.setPadding(new Insets(0, 0, 0, Config.UNIT * 1.5));
		cabinPaneHolder.setSpacing(Config.UNIT * 0.4);

		ArrayList<PassengerPane> passengerPanes = new ArrayList<>();

		for (int i = 0; i < Config.MAX_CUSTOMER_PER_FLOOR; i++) {
			PassengerPane passengerPane = new PassengerPane(i);
			passengerPanes.add(passengerPane);
		}
		cabinPaneHolder.getChildren().addAll(passengerPanes);
		this.getChildren().add(cabinPaneHolder);

	}

	public void initializeCustomerManagerStyle() {
		this.setPrefSize((Config.UNIT * 14), (Config.UNIT * (1.125)));
	}

	public void initializeCanvas() {
		this.customerManagerCanvas = new Canvas(Config.UNIT * (14), Config.UNIT * (1.125));
		this.gc = customerManagerCanvas.getGraphicsContext2D();

		this.getChildren().add(customerManagerCanvas);
//		gc.setFill(Color.ALICEBLUE);
//		gc.fillRect(0, 0, (Config.UNIT * 14), (Config.UNIT * (1.125)));
	}

	public GraphicsContext getGc() {
		return gc;
	}

}
