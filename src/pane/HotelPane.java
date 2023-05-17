package pane;

import utils.Config;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class HotelPane extends GridPane {
	
	private ArrayList<ElevatorZone> elevs;
	private ElevatorZone elevatorZone1,elevatorZone2,elevatorZone3;
	private FloorZone floorZone;

	public HotelPane() {
		this.elevs = new ArrayList<>();
		this.elevatorZone1 = new ElevatorZone(0);
		this.elevatorZone2 = new ElevatorZone(1);
		this.elevatorZone3 = new ElevatorZone(2);
		this.floorZone = new FloorZone();

		this.setPadding(new Insets(0, Config.UNIT, 0, Config.UNIT));
		this.setPrefSize(Config.UNIT * 15, Config.UNIT * (1.125 * 7));
//		this.elevatorZone.setPrefSize((Config.UNIT * 4.5), (Config.UNIT * (1.125 * 7)));

//		elevatorZone.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
//		elevatorZone.setBackground(new Background(new BackgroundImage(RenderableHolder.elevatorRailSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));
//		floorZone.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite,
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null)));

//		this.setBackground(new Background(new BackgroundImage(RenderableHolder.hotelSprite, null, null, null, null)));
//		this.getChildren().addAll(elevatorZone, floorZone);
		this.elevs.add(elevatorZone1);
		this.elevs.add(elevatorZone2);
		this.elevs.add(elevatorZone3);
		
		this.add(elevatorZone1, 0, 0);
		this.add(elevatorZone2, 1, 0);
		this.add(elevatorZone3, 2, 0);
		this.add(floorZone, 3, 0);

	}

//	public ElevatorZone getElevatorZone() {
//		return elevatorZone;
//	}

	public FloorZone getFloorZone() {
		return floorZone;
	}

	public ArrayList<ElevatorZone> getElevs() {
		return elevs;
	}

}
