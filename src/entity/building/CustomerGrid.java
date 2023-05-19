package entity.building;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.cutomer.StandardCustomer;
import entity.elevator.Elevator;
import entity.elevator.InsideCabin;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameLogic;
import utils.Config;
import utils.CustomerUtils;

public class CustomerGrid extends Entity {

	private final BaseCustomer[][] customersGrid;

	public CustomerGrid() {
		customersGrid = new BaseCustomer[Config.MAX_CUSTOMER_PER_FLOOR][(Config.TOP_FLOOR + 1)];
		this.z = 100;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 7; col++) {
				if (!(customersGrid[row][col] == null))
					customersGrid[row][col].draw(gc);
			}
		}

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public void update() {

		for (int row = 0; row < customersGrid.length; row++) {
			for (int column = 0; column < customersGrid[0].length; column++) {
				if (!(customersGrid[row][column] == null)) {
					BaseCustomer customer = customersGrid[row][column];
					customer.update();
					if (customer.getPatienceLeft() == 0) {
						CustomerUtils.removeCustomerFromFloor(customer, customersGrid, row, column);
						GameLogic.getInstance().getTimeGauge()
								.setTimeLeft(GameLogic.getInstance().getTimeGauge().getTimeLeft()
										- (int) Math.round(Config.MAX_TIME_GAUGE * 0.05));
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
			BaseCustomer customer = getCustomer((int) queue, (int) floor);
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
		if (customersGrid[x][y] == null)
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
