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
	protected int occupiedSpace; // final?
	protected double maxPatience;
	protected double patienceLeft;
	protected int reward;// extra time
	protected int punishment;// reduced time
	protected int z;

	protected Image image;

	public BaseCustomer() {
		currentFloor = Randomizer.getRandomInt(0, 6);
		do {
			destinationFloor = Randomizer.getRandomInt(0, 6);
		} while (destinationFloor == currentFloor);
		this.patienceLeft = Config.MAX_PATIENCE;
		this.reward = 0;
		this.punishment = 0;
		this.z = 100; // layer of the guy
		this.occupiedSpace = 1;

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

	public int getOccupiedSpace() {
		return occupiedSpace;
	}

	public void draw(GraphicsContext gc) {
		int index = getCurrentQueue(); // starts from 0
		int currentFloor = getCurrentFloor(); // starts at 1
		double LeftPadding = Config.UNIT * (0.2);
		double widthWithPadding = Config.UNIT * (0.8);
		double allowedWidth = Config.UNIT * (0.75);
		double currentPatienceWidth = allowedWidth * (getPatienceLeft() / getMaxPatience());
		double floorHeight = Config.UNIT * 1.125;
		double yFirstFloor = floorHeight * 7;
		double XPos = index * widthWithPadding;
		double YPos = yFirstFloor - ((currentFloor) * floorHeight); // +5 = space for patienceGauge
		double oneEightUnit = (Config.UNIT * 1 / 8);
		// TODO Auto-generated method stub
		gc.setFill(Config.PATIENCE_GAUGE);
		gc.setStroke(Config.PATIENCE_GAUGE_BORDER);
		gc.drawImage(image, LeftPadding + XPos, YPos - (floorHeight)); // image draws from top left -> down right
		gc.strokeRect(LeftPadding + XPos, YPos - oneEightUnit, allowedWidth, oneEightUnit); // (startx,starty,width,height)
		gc.fillRect(LeftPadding + XPos, YPos - oneEightUnit, currentPatienceWidth, oneEightUnit);
	}
	
	public void drawInCabin(GraphicsContext gc) {
		int index = getCurrentQueue(); // starts from 0
		double LeftPadding = Config.UNIT * (1.5);
		double widthWithPadding = Config.UNIT * (0.75+0.4);
		double allowedWidth = Config.UNIT * (0.75);
		double currentPatienceWidth = allowedWidth * (getPatienceLeft() / getMaxPatience());
		double floorHeight = Config.UNIT * 1.125;
		double yFirstFloor = floorHeight;
		double XPos = index * widthWithPadding;
		double YPos = yFirstFloor; // +5 = space for patienceGauge
		double oneEightUnit = (Config.UNIT * 1 / 8);
		// TODO Auto-generated method stub
		gc.setFill(Config.PATIENCE_GAUGE);
		gc.setStroke(Config.PATIENCE_GAUGE_BORDER);
		gc.drawImage(image, LeftPadding + XPos, YPos - (floorHeight)); // image draws from top left -> down right
		gc.strokeRect(LeftPadding + XPos, YPos - oneEightUnit, allowedWidth, oneEightUnit); // (startx,starty,width,height)
		gc.fillRect(LeftPadding + XPos, YPos - oneEightUnit, currentPatienceWidth, oneEightUnit);
	}

}
