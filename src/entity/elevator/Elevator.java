package entity.elevator;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;
import utils.Config;

public class Elevator extends Entity {

	private boolean isSelected;
	private final int capacity = 5;
	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private int currentFloor;
	private int id;
	private KeyCode upKey, downKey;
	private double moveY;

	public Elevator(int id, double x, double y, KeyCode upKey, KeyCode downKey) {
		this.id = id;
		this.isSelected = false;
		this.passengers = new ArrayList<>();
		this.currentFloor = 0;
		this.numberOfPassenger = 0;
		this.x = x;
		this.y = y;
		this.z = 100;
		this.upKey = upKey;
		this.downKey = downKey;
		this.moveY = 0;
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
				this.moveY -= 0.0225 * Config.UNIT;
				this.y += 0.0225 * Config.UNIT;
			}
			if (this.moveY < 0) {
				this.moveY += 0.0225 * Config.UNIT;
				this.y -= 0.0225 * Config.UNIT;
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
		if(this.y == ((6-this.getCurrentFloor())*1.125*Config.UNIT)) {
			if(InputUtility.getKeyPressed(this.upKey) && this.currentFloor != 6) {
				moveUp();
				this.moveY = -1.125*Config.UNIT;
			}
			if (InputUtility.getKeyPressed(this.downKey) && this.currentFloor != 0) {
				moveDown();
				this.moveY = 1.125 * Config.UNIT;
			}
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

	public ArrayList<BaseCustomer> getPassengers() {
		return passengers;
	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}
}