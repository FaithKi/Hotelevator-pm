package pane;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Config;

public class FloorZone extends VBox {
	private ArrayList<HBox> floors;
	
	public FloorZone() {
		super((Config.UNIT * 1.5), (Config.UNIT * (1.125 * 7)));
		floors = new ArrayList<>();
		for(int i = 0; i < 7; i++) {
			floors.add(new HBox());
		}
	}
}
