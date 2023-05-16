package pane;

import javafx.scene.layout.BorderPane;

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
		this.hotelPane.paintComponent();
	}
}
