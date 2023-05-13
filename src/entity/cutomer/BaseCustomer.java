package entity.cutomer;

import logic.game.HotelFloor;
import logic.game.PatienceLevel;

public abstract class BaseCustomer {

	private PatienceLevel patienceLevel;
	private int remainingTime;
	private HotelFloor currentFloor; 
	private HotelFloor destinationFloor;
	private int payAmount;
	private int difficulty;
	
	public BaseCustomer(PatienceLevel patienceLevel, HotelFloor destinationFloor, HotelFloor currentFloor, int payAmount) {
		this.patienceLevel = patienceLevel;
		this.remainingTime = patienceLevel.getTime();
		this.currentFloor = currentFloor;
		this.destinationFloor = destinationFloor;
		this.payAmount = payAmount; 
	}
	
	public abstract void successAction();
	public abstract void failedAction();

	public PatienceLevel getPatienceLevel() {
		return patienceLevel;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}
