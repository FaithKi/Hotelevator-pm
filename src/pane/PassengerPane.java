package pane;

import input.InputUtility;
import javafx.scene.Cursor;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import utils.Config;

public class PassengerPane extends GridPane {
	private int index;

	public PassengerPane(int index) {
		// TODO Auto-generated constructor stub
		this.index = index;
		initializePassengerPaneStyle();
		addEventListener();
	}

	public Integer getIndex() {
		return (Integer) index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void addEventListener() {
		this.setOnMouseClicked((e) -> {
//			System.out.println(getPos().toString());
			InputUtility.setPassengerIndexPressed(getIndex(), true);
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

	public void initializePassengerPaneStyle() {
		this.setPrefSize(Config.UNIT * 0.75, Config.UNIT * 1.125);
//		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2)),
//				null, null));
	}

}
