package pane;

import java.util.ArrayList;

import input.InputUtility;
import javafx.scene.Cursor;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
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

	public Integer[] getPos() {
		Integer[] pos = new Integer[2];
		pos[0] = getIndex();
		pos[1] = getFloorNumber();
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

	public void addEventListener() {
		this.setOnMouseClicked((e) -> {
//			System.out.println(getPos().toString());
			InputUtility.setHotelGridPressed(getPos(), true);
		});

		// Event handler for mouse enter event
		this.setOnMouseEntered(event -> {
			this.setCursor(Cursor.HAND);
		});

		// Event handler for mouse exit event
		this.setOnMouseExited(event -> {
			this.setCursor(Cursor.DEFAULT);
		});
	}

	public void initializeCustomerPaneStyle() {
		this.setPrefSize(Config.UNIT * 0.75, Config.UNIT * 1.125);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2)),
				null, null));
	}

}
