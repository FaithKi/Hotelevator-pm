package entity.elevator;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import pane.CustomerManager;
import logic.game.GameLogic;
import logic.game.GameLogic;
import pane.CustomerManager;
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
//	private CustomerManager customerManager;

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
//		customerManager = new CustomerManager(passengers);
	}

	public int moveUp() {
		this.setCurrentFloor(this.getCurrentFloor() + 1);
		return this.currentFloor;
	}

	public int moveDown() {
		this.setCurrentFloor(this.getCurrentFloor() - 1);
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
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.elevatorRailSprite, 0, 0);
		gc.drawImage(RenderableHolder.cabinSprite, x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
		if (this.y == ((6 - this.getCurrentFloor()) * 1.125 * Config.UNIT)) {
			if (InputUtility.getKeyPressed(this.upKey) && this.currentFloor != 6) {
				moveUp();
				this.moveY = -1.125 * Config.UNIT;
			}
			if (InputUtility.getKeyPressed(this.downKey) && this.currentFloor != 0) {
				moveDown();
				this.moveY = 1.125 * Config.UNIT;
			}
		}

		getInsideCabin().update();
		if (this.isSelected) {
			Integer queue = InputUtility.getPassengerIndexPressed();
			if (queue == null)
				return;

			BaseCustomer customer = this.getInsideCabin().getPassengers()[queue];
			if (customer == null)
				return;
			customer.setCurrentFloor(currentFloor);
			// perform effect then remove TODO
			TimeGauge timeGauge = GameLogic.getInstance().getTimeGauge();
			if (customer.getCurrentFloor() == customer.getDestinationFloor()) {
				timeGauge.setTimeLeft(timeGauge.getTimeLeft() + (int) Math.round(Config.MAX_TIME_GAUGE * 0.025));
				timeGauge.setScore(timeGauge.getScore() + 100);
			} else {
				timeGauge.setTimeLeft(timeGauge.getTimeLeft() - (int) Math.round(Config.MAX_TIME_GAUGE * 0.05));
			}

			// remove passenger from cabin

			CustomerUtils.removeCustomerFromCabin(customer, getInsideCabin(), queue);

//			BaseCustomer customer = this.getInsideCabin().getPassengers()[index]; // TODO

		}
	}

	public int getId() {
		return id;
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

}