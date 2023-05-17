package pane;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import utils.Config;

public class CustomerPane extends GridPane {
	private int index;
	private int floorNumber;

	public CustomerPane(int index, int floorNumber) {
		this.index = index;
		this.floorNumber = floorNumber;
		initializeCustomerPaneStyle();
		addEventListener();
	}

	public ArrayList<Integer> getPos() {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		pos.add(getIndex());
		pos.add(getFloorNumber());
		return pos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void addEventListener() {
		this.setOnMouseClicked((e) -> {
			System.out.println(getPos().toString());
			System.out.println("what the hellllll");
		});
	}

	public void initializeCustomerPaneStyle() {
		this.setPrefSize(Config.UNIT * 0.75, Config.UNIT * 1.125);
//		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, null, null, null)));
	}

}
