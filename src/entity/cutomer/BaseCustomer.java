package entity.cutomer;

import entity.Entity;
import javafx.scene.image.Image;
import logic.game.PatienceLevel;
import utils.Config;
import utils.Randomizer;

public abstract class BaseCustomer extends Entity {

	private int currentFloor;
	private int destinationFloor;
	private PatienceLevel patienceLevel;
	private double patienceLeft;
	protected int reward;// extra time
	protected int punishment;// reduced time
	protected int z;
	private Image image;

	public BaseCustomer() {
		currentFloor = Randomizer.getRandomInt(1, 7);
		do {
			destinationFloor = Randomizer.getRandomInt(1, 7);
		} while (destinationFloor == currentFloor);
		this.patienceLeft = Config.MAX_PATIENCE;
		this.reward = 0;
		this.punishment = 0;
		this.z = 100; // layer of the guy

	}

	public abstract void successAction();

	public abstract void failedAction();

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		if (Config.FIRST_FLOOR <= currentFloor && currentFloor <= Config.TOP_FLOOR)
			this.currentFloor = currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public PatienceLevel getPateinceLevel() {
		return patienceLevel;
	}

	public double getPatienceLeft() {
		return patienceLeft;
	}

	public void setPatienceLeft(double patienceLeft) {
		if (patienceLeft <= 0)
			patienceLeft = 0;
		this.patienceLeft = patienceLeft;
	}

	public int getReward() {
		return reward;
	}

	public int getPunishment() {
		return punishment;
	}

	public int getZ() {
		return z;
	}

	public Image getImage() {
		return image;
	}

}
