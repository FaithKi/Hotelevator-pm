package pane;

import entity.elevator.Elevator;
import javafx.scene.layout.BorderPane;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

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
		for(IRenderable entity: RenderableHolder.getInstance().getEntities()) {
			if(entity instanceof Elevator) {
				Elevator elev = (Elevator) entity;
				System.out.println(elev.getId());
				entity.draw(ContainerPane.getHotelPane().getElevatorZone().getGcs().get(elev.getId()));
			}
		}
	}
}
