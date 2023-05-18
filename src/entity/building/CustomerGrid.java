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
import utils.CustomerUtils;

public class CustomerGrid extends Entity {

	private BaseCustomer[][] customersGrid;

	public CustomerGrid() {
		customersGrid = new BaseCustomer[10][7];
		this.z = 0;

		testCustomer();
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

//		gc.drawImage(RenderableHolder.hotelSprite, x, y);
//		gc.setFill(Color.BLACK);
//		gc.fillRect(0, 0, 20, 20);
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
		// update everycustomer loop

		Integer[] grid = InputUtility.getHotelGridPressed();
		if (grid[0] == null)
			return;
		Integer queue = grid[0];
		Integer floor = grid[1];
		Elevator selectedElevator = GameLogic.selectedElev;

		if (selectedElevator.getCurrentFloor() == floor) {
			BaseCustomer customer = getCustomer((int) queue, (int) floor);
			if (customer == null)
				return;
			boolean isAdded = addCustomerToCabin(customer, selectedElevator);
			if (isAdded) {
				CustomerUtils.removeCustomerFromFloor(customer, customersGrid, queue, floor);
			}

		}

//		return customer;
//		addtoCabin(customer, GameLogic.getInstance().something);
	}

	public BaseCustomer[][] getFloors() {
		return customersGrid;
	}

	public void transferCustomer(int x, int y) {
		boolean hasSpace = true; // IMPLEMENT METHOD check if target elevator have enough space
		boolean isMoving = false; // IMPLEMENT METHOD check if target elevator is moving
		if (hasSpace && !isMoving) {

		}

	}

	public BaseCustomer getCustomer(int x, int y) {
		if (customersGrid[x][y] == null)
			return null;
		return customersGrid[x][y];

	}

	public static boolean addCustomerToCabin(BaseCustomer customer, Elevator elevator) {
		InsideCabin insideCabin = elevator.getInsideCabin();
		boolean isFull = insideCabin.getCapacity() < (insideCabin.getNumberOfPassenger() + customer.getOccupiedSpace());
		if (isFull)
			return false; // Implement new interface Enterable to check if condition is valid?
		CustomerUtils.addPassengerToFirstToFirstEmptyQueueOfCabin(customer, insideCabin);
		return true;
	}

	private void testCustomer() {
		// TEST
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);
		CustomerUtils.addCustomerToFloorFromGenerator(new StandardCustomer(), customersGrid);

	}
}
