package pane;

import entity.building.CustomerGrid;
import entity.elevator.Elevator;
import input.InputUtility;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.game.GameLogic;
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
		if (!GameLogic.isGameOver) {
			for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
				if (entity instanceof Elevator) {
					Elevator elev = (Elevator) entity;
					if (elev.isSelected()) {
						elev.getInsideCabin().draw(ContainerPane.getBottomBarPane().getCustomerManager().getGc());
					}
					elev.draw(ContainerPane.getHotelPane().getElevs().get(elev.getId()).getGraphicsContext2D());
				}
				if (entity instanceof CustomerGrid) {
					CustomerGrid hotel = (CustomerGrid) entity;
					hotel.draw(ContainerPane.getHotelPane().getFloorZone().getGc());
				}
				if (entity instanceof TimeGauge) {
					TimeGauge timeGauge = (TimeGauge) entity;
					timeGauge.draw(ContainerPane.getSideBarPane().getGc());
				}
			}
		} else {
			Text gameOverText = new Text("GameOver!");
			gameOverText.setFont(new Font(100));
			this.setCenter(gameOverText);
			this.setRight(null);
			this.setBottom(null);
		}
	}
}
