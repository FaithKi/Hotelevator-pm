package entity.cutomer;

import entity.Entity;
import logic.game.PatienceLevel;
import utils.Randomizer;

public abstract class BaseCustomer extends Entity{

	private int currentFloor;
	private int destinationFloor;
	private PatienceLevel pateinceLevel;
	protected int reward;//extra time
	protected int punishment;//reduced time
	protected int z;
	
	public BaseCustomer() {
		currentFloor = Randomizer.getRandomInt(1, 7);
		do {
			destinationFloor = Randomizer.getRandomInt(1, 7);
		} while(destinationFloor == currentFloor);
	}
	
	public abstract void successAction();
	public abstract void failedAction();

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public PatienceLevel getPateinceLevel() {
		return pateinceLevel;
	}
}
