package entity.building;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.cutomer.StandardCustomer;
import entity.elevator.Elevator;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameLogic;

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
		Integer x = grid[0];
		Integer y = grid[1];

		if (GameLogic.selectedElev.getCurrentFloor() == y) {
			BaseCustomer customer = getCustomer((int) x, (int) y);
			if (customer == null)
				return;
			customersGrid[x][y] = null;
			GameLogic.selectedElev.getInsideCabin().getPassengers()[1] = customer; // FIXTHIS
			GameLogic.selectedElev.getInsideCabin()
					.setNumberOfPassenger(GameLogic.selectedElev.getInsideCabin().getNumberOfPassenger() + 1);
		}

//		return customer;
//		addtoCabin(customer, GameLogic.getInstance().something);
	}

	public BaseCustomer[][] getFloors() {
		return customersGrid;
	}

	private void testCustomer() {
		// TEST
		StandardCustomer customer1 = new StandardCustomer();
		customer1.setCurrentQueue(0);
		StandardCustomer customer2 = new StandardCustomer();
		customer2.setCurrentQueue(1);
		customer2.setPatienceLeft(15550);

		System.out.println(customer1.getCurrentFloor());
		System.out.println(customer2.getCurrentFloor());

		customersGrid[0][customer1.getCurrentFloor()] = customer1;
		customersGrid[1][customer2.getCurrentFloor()] = customer2;

//		floors.get(customer1.getCurrentFloor() - 1).add(customer1);
//		floors.get(customer2.getCurrentFloor() - 1).add(customer2);
	}

	public BaseCustomer[][] getCustomersGrid() {
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

	public void addToCabin(BaseCustomer baseCustomer, Elevator elevator) {

	}
	
	

}
