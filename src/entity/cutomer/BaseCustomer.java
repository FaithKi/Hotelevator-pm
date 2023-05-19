package entity.cutomer;

import entity.Entity;
import entity.elevator.InsideCabin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.Randomizer;

public abstract class BaseCustomer extends Entity {

	private int currentFloor;
	private int currentQueue;
	private int destinationFloor;
	protected int occupiedSpace;
	protected double maxPatience;
	protected double patienceLeft;
//	protected int reward;// extra time
//	protected int punishment;// reduced time
	protected int z;
	protected Image image;
	protected Color gaugeColor;

	public BaseCustomer() {
		currentFloor = Randomizer.getRandomInt(0, 6);
		do {
			destinationFloor = Randomizer.getRandomInt(0, 6);
		} while (destinationFloor == currentFloor);
		this.patienceLeft = Config.MAX_PATIENCE;
		this.z = 100; // layer of the guy
		this.occupiedSpace = 1;
		this.gaugeColor = Config.PATIENCE_GAUGE_HIGH_P;
	}

	public abstract boolean canEnter(InsideCabin insideCabin);

	public abstract void setCustomerPatienceType(PatienceLevel patienceLevel);

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

	public double getPatienceLeft() {
		return patienceLeft;
	}

	public void setPatienceLeft(double patienceLeft) {
		if (patienceLeft <= 0)
			patienceLeft = 0;
		this.patienceLeft = patienceLeft;
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.setPatienceLeft(getPatienceLeft() - Config.DECREASE_RATE);
	}

	public void draw(GraphicsContext gc) {
		int currentQueue = getCurrentQueue();
		int currentFloor = getCurrentFloor();
		drawCleaner(gc, currentQueue, currentFloor, Config.UNIT * (0.2), Config.UNIT * (0.8), 7);
	}

	public void drawInCabin(GraphicsContext gc) {
		int currentQueue = getCurrentQueue();
		drawCleaner(gc, currentQueue, 0, Config.UNIT * (3), Config.UNIT * (0.75 + 1), 1);
	}

	private void drawCleaner(GraphicsContext gc, int currentQueue, int currentFloor,
			double leftPaddingOfTheClickingPane, double customerWidthIncludePaneSpacing, int totalFloor) {

		double allowedWidth = Config.UNIT * (0.75);
		double currentPatienceWidth = allowedWidth * (getPatienceLeft() / getMaxPatience());
		double floorHeight = Config.UNIT * 1.125;
		double yFirstFloor = floorHeight * totalFloor;
		double XPos = currentQueue * customerWidthIncludePaneSpacing;
		double YPos = yFirstFloor - ((currentFloor) * floorHeight); // +5 = space for patienceGauge
		double oneEightUnit = (Config.UNIT * 1 / 8);
		gc.setFill(this.gaugeColor);
		gc.setStroke(Config.PATIENCE_GAUGE_BORDER);
		gc.drawImage(image, leftPaddingOfTheClickingPane + XPos, YPos - (floorHeight)); // image draws from top left ->
																						// // down right
		gc.strokeRect(leftPaddingOfTheClickingPane + XPos, YPos - oneEightUnit, allowedWidth, oneEightUnit); // (startx,starty,width,height)
		gc.fillRect(leftPaddingOfTheClickingPane + XPos, YPos - oneEightUnit, currentPatienceWidth, oneEightUnit);

		gc.setFont(RenderableHolder.pixelStyleFont);

		// Set fill color
		gc.setFill(Config.TEXT_FILL);
		gc.setStroke(Config.TEXT_STROKE);

		gc.fillText(Integer.toString(getDestinationFloor() + 1),
				leftPaddingOfTheClickingPane + XPos + (Config.UNIT * 0.025), YPos - (floorHeight * 0.8));
		gc.strokeText(Integer.toString(getDestinationFloor() + 1),
				leftPaddingOfTheClickingPane + XPos + (Config.UNIT * 0.025), YPos - (floorHeight * 0.8));

	}
}
