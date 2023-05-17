package pane;

import input.InputUtility;
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
	}

	public void initializePassengerPaneStyle() {
		this.setPrefSize(Config.UNIT * 0.75, Config.UNIT * 1.125);
//		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2)),
				null, null));
	}

}
