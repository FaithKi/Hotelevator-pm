package entity.elevator;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import sidebar.TimeGauge;
import utils.Config;
import utils.CustomerUtils;

public class Elevator extends Entity {

	private boolean isSelected;
	private InsideCabin insideCabin;
	private int currentFloor;
	private int id;
	private KeyCode upKey, downKey;
	private double moveY;
	private double x, y;

	private String lastDeliver;
	private int lastDeliverFloor;
	private boolean hasMoved;
	private int comboCount; // 1-5 note in d minor scale

	public Elevator(int id, double x, double y, KeyCode upKey, KeyCode downKey) {
		this.id = id;
		this.isSelected = false;
		this.currentFloor = 0;
		this.insideCabin = new InsideCabin(this);
		this.x = x;
		this.y = y;
		this.z = 100;
		this.upKey = upKey;
		this.downKey = downKey;
		this.moveY = 0;
		this.lastDeliver = null;
		this.comboCount = 1;
		this.lastDeliverFloor = 0;
		hasMoved = false;
	}

	public int moveUp() {
		this.setCurrentFloor(this.getCurrentFloor() + 1);
		this.hasMoved = true;
		return this.currentFloor;
	}

	public int moveDown() {
		this.setCurrentFloor(this.getCurrentFloor() - 1);
		this.hasMoved = true;
		return this.currentFloor;
	}

	public void move() {
		if (Math.abs(this.y - ((6 - this.getCurrentFloor()) * 1.125 * Config.UNIT)) < 10e-8) {
			this.y = (6 - this.getCurrentFloor()) * 1.125 * Config.UNIT;
			this.moveY = 0;
		} else {
			if (this.moveY > 0) {
//				this.moveY -= 0.0225 * Config.UNIT;
				this.y += Config.ELEV_SPEED;
			}
			if (this.moveY < 0) {
//				this.moveY += 0.0225 * Config.UNIT;
				this.y -= Config.ELEV_SPEED;
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.elevatorRailSprite, 0, 0);
		gc.drawImage(RenderableHolder.cabinSprite, x, y);
		gc.setStroke(Color.rgb(57, 57, 79));
		gc.setLineWidth(5);
		gc.strokeRoundRect(x, y, Config.UNIT * 1.5, Config.UNIT * 1.125, Config.UNIT * 0.1, Config.UNIT * 0.1);
	}

	@Override
	public void update() {
		move();
		insideCabin.update();
		handleKeyPressedUpdate();
		if (isSelected) {
			handleSelectedCabinInteraction();
		}

	}

	private void handleKeyPressedUpdate() {
		if (y == ((6 - currentFloor) * 1.125 * Config.UNIT)) {
			if (InputUtility.getKeyPressed(upKey) && currentFloor != 6) {
				moveUp();
				moveY = -1.125 * Config.UNIT;

			}
			if (InputUtility.getKeyPressed(downKey) && currentFloor != 0) {
				moveDown();
				moveY = 1.125 * Config.UNIT;
			}
		}
	}

	private void handleSelectedCabinInteraction() {

		Integer queue = InputUtility.getPassengerIndexPressed();
		BaseCustomer customer = getCustomerFromQueuePressed(queue);

		if (!(customer == null)) {
			TimeGauge timeGauge = GameLogic.getInstance().getTimeGauge();
			performDestinationCheck(customer, timeGauge);
			setLastDeliver(customer.toString());
			CustomerUtils.removeCustomerFromCabin(customer, insideCabin, queue);
		}
	}

	private BaseCustomer getCustomerFromQueuePressed(Integer queue) {
		return (queue == null) ? null : insideCabin.getPassengers()[queue]; // return Customer if present otherwise
																			// return null
	}

	private void performDestinationCheck(BaseCustomer customer, TimeGauge timeGauge) {
		customer.setCurrentFloor(currentFloor);
		if (customer.getCurrentFloor() == customer.getDestinationFloor()) {
			timeGauge.setTimeLeft(timeGauge.getTimeLeft() + (int) Math.round(Config.MAX_TIME_GAUGE * 0.025));

			int scoreGain = 100;
			if (!hasMoved) {
				setComboCount(getComboCount() + customer.getOccupiedSpace());
				if (customer.toString().equals(lastDeliver)) {
					scoreGain = (int) (scoreGain * (customer.getRewardMultiplier() * comboCount));
				}
				scoreGain = (int) (scoreGain * comboCount);
			} else {
				setComboCount(1);
			}

			System.out.println(
					hasMoved + " " + lastDeliver + " " + customer.toString() + " " + comboCount + " SCORE" + scoreGain);
			this.lastDeliverFloor = currentFloor;
			this.setLastDeliver(customer.toString());
			timeGauge.setScore(timeGauge.getScore() + scoreGain);
		} else {
			timeGauge.setTimeLeft(timeGauge.getTimeLeft() - (int) Math.round(Config.MAX_TIME_GAUGE * 0.05));
		}
		hasMoved = false;
	}

	public int getId() {
		return id;
	}

	public int getLastDeliverFloor() {
		return lastDeliverFloor;
	}

	public void setLastDeliverFloor(int lastDeliverFloor) {
		this.lastDeliverFloor = lastDeliverFloor;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public boolean isSelected() {
		return this.isSelected;
	}

	public void setSelected(boolean select) {
		this.isSelected = select;
	}

	public InsideCabin getInsideCabin() {
		return insideCabin;
	}

	public String getLastDeliver() {
		return lastDeliver;
	}

	public void setLastDeliver(String lastDeliver) {
		this.lastDeliver = lastDeliver;
	}

	public int getComboCount() {
		return comboCount;
	}

	public void setComboCount(int comboCount) {
		this.comboCount = comboCount;
	}

}