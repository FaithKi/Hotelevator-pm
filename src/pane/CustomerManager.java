package pane;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;

public class CustomerManager extends GridPane {
	private Canvas customerManagerCanvas;
	private GraphicsContext gc;

	private final GameLogic logic = GameLogic.getInstance();

	public CustomerManager() {
		initializeCustomerManagerStyle();
		initializeCanvas();
	}

	public void InitializeCabinPane() {
	}

	public void initializeCustomerManagerStyle() {
		this.setPrefSize((Config.UNIT * 14), (Config.UNIT * (1.125)));
	}

	public void initializeCanvas() {
		this.customerManagerCanvas = new Canvas(Config.UNIT * (14), Config.UNIT * (1.125));
		this.gc = customerManagerCanvas.getGraphicsContext2D();

		this.add(customerManagerCanvas, 0, 0);
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, 0, (Config.UNIT * 14), (Config.UNIT * (1.125)));
	}

	public GraphicsContext getGc() {
		return gc;
	}
}
