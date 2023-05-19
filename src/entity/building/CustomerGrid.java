package entity.building;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.elevator.Elevator;
import entity.elevator.InsideCabin;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameLogic;
import sidebar.TimeGauge;
import utils.Config;
import utils.CustomerUtils;

public class CustomerGrid extends Entity {
	private final BaseCustomer[][] customersGrid;

	public CustomerGrid() {
		customersGrid = new BaseCustomer[Config.MAX_CUSTOMER_PER_FLOOR][Config.TOP_FLOOR + 1];
		z = 100;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		for (BaseCustomer[] row : customersGrid) {
			for (BaseCustomer customer : row) {
				if (customer != null)
					customer.draw(gc);
			}
		}
	}

	@Override
	public void update() {
		for (int row = 0; row < customersGrid.length; row++) {
			for (int column = 0; column < customersGrid[0].length; column++) {
				BaseCustomer customer = customersGrid[row][column];
				if (customer != null) {
					customer.update();
					if (customer.getPatienceLeft() == 0) {
						CustomerUtils.removeCustomerFromFloor(customer, customersGrid, row, column);

						TimeGauge timeGauge = GameLogic.getInstance().getTimeGauge();
						timeGauge.setTimeLeft(timeGauge.getTimeLeft() - (int) Math.round(Config.MAX_TIME_GAUGE * 0.04));
					}
				}
			}
		}

		Integer[] grid = InputUtility.getHotelGridPressed();
		if (grid[0] == null)
			return;

		Integer queue = grid[0];
		Integer floor = grid[1];
		Elevator selectedElevator = GameLogic.getInstance().selectedElev;

		if (selectedElevator.getCurrentFloor() == floor) {
			BaseCustomer customer = getCustomer(queue, floor);
			if (customer == null)
				return;
			boolean isAdded = addCustomerToCabin(customer, selectedElevator);
			if (isAdded) {
				CustomerUtils.removeCustomerFromFloor(customer, customersGrid, queue, floor);
			}
		}
	}

	public BaseCustomer[][] getFloors() {
		return customersGrid;
	}

	public BaseCustomer getCustomer(int x, int y) {
		if (x < 0 || x >= customersGrid.length || y < 0 || y >= customersGrid[0].length)
			return null;
		return customersGrid[x][y];
	}

	public static boolean addCustomerToCabin(BaseCustomer customer, Elevator elevator) {
		InsideCabin insideCabin = elevator.getInsideCabin();
		if (!customer.canEnter(insideCabin))
			return false;
		CustomerUtils.addPassengerToFirstToFirstEmptyQueueOfCabin(customer, insideCabin);
		return true;
	}

	public BaseCustomer[][] getCustomersGrid() {
		return customersGrid;
	}
}
