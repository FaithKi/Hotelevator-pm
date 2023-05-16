package entity.cutomer;

import entity.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import logic.game.PatienceLevel;
import utils.Config;
import utils.Randomizer;

public abstract class BaseCustomer extends Entity {

	private int currentFloor;
	private int currentQueue;
	private int destinationFloor;
//	protected PatienceLevel patienceLevel;
	protected double maxPatience;
	protected double patienceLeft;
	protected int reward;// extra time
	protected int punishment;// reduced time
	protected int z;
	protected Image image;

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
			;
		this.currentFloor = currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

//	public PatienceLevel getPatienceLevel() {
//		return patienceLevel;
//	}

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

	protected double setStartingPatience(double startingPatience) {
		double oneTenthDeviation = (10 * Math.random()) / 100;
		return startingPatience - (startingPatience * oneTenthDeviation);
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getCurrentQueue() {
		return currentQueue;
	}

	public void setCurrentQueue(int currentQueue) {
		this.currentQueue = currentQueue;
	}

	public double getMaxPatience() {
		return maxPatience;
	}

	public void draw(GraphicsContext gc) {
		int i = getCurrentQueue(); // starts from 0
		int j = getCurrentFloor(); // starts at 1
		double maxWidth = Config.UNIT * (0.75);
		double currentPatienceWidth = maxWidth * (getPatienceLeft() / getMaxPatience());
		double yFirstFloor = Config.UNIT * (7 * 1.125);
		double XPos = i * maxWidth;
		double YPos = yFirstFloor - ((j - 1) * Config.UNIT); // +5 = space for patienceGauge
		// TODO Auto-generated method stub
		gc.setFill(Config.PATIENCE_GAUGE);
		gc.setStroke(Config.PATIENCE_GAUGE_BORDER);
		gc.drawImage(image, XPos, YPos + 5);
		gc.strokeRect(XPos, XPos + maxWidth, YPos + 5, YPos);
		gc.fillRect(XPos, XPos + currentPatienceWidth, YPos + 5, YPos);

	}
}
