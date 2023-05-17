package pane;

import entity.building.Hotel;
import entity.elevator.Elevator;
import input.InputUtility;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import sidebar.TimeGauge;

public class ContainerPane extends BorderPane {
	private static SideBarPane sideBarPane;
	private static HotelPane hotelPane;
	private static BottomBarPane bottomBarPane;

	public ContainerPane() {
		// TODO: FILL CODE
		sideBarPane = new SideBarPane();
		hotelPane = new HotelPane();
		bottomBarPane = new BottomBarPane();
		this.setRight(sideBarPane);
		this.setCenter(hotelPane);
		this.setBottom(bottomBarPane);
		addListerner();
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public static SideBarPane getSideBarPane() {
		return sideBarPane;
	}

	public static HotelPane getHotelPane() {
		return hotelPane;
	}

	public static BottomBarPane getBottomBarPane() {
		return bottomBarPane;
	}

	public void paintComponent() {
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity instanceof Elevator) {
				Elevator elev = (Elevator) entity;
				elev.draw(ContainerPane.getHotelPane().getElevs().get(elev.getId()).getGraphicsContext2D());
			}
			if (entity instanceof Hotel) {
				Hotel hotel = (Hotel) entity;
				hotel.draw(ContainerPane.getHotelPane().getFloorZone().getGc());
			}
		}
	}
}
