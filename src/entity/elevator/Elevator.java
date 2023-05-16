package entity.elevator;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import utils.Config;

public class Elevator extends Entity{

	private final int capacity = 5;
	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private int currentFloor;
	private int id;
	private KeyCode upKey, downKey;
	
	public Elevator(int id, double x, double y, KeyCode upKey, KeyCode downKey) {
		this.id = id;
		this.passengers = new ArrayList<>();
		this.currentFloor = 1;
		this.numberOfPassenger = 0;
		this.x = x;
		this.y = y;
		this.z = 100;
		this.upKey = upKey;
		this.downKey = downKey;
	}
	
	public int moveUp() {
		this.currentFloor += 1;
		return this.currentFloor;
	}
	
	public int moveDown() {
		this.currentFloor -= 1;
		return this.currentFloor;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.elevatorRailSprite, 0, 0);
		gc.drawImage(RenderableHolder.cabinSprite , x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(InputUtility.getKeyPressed(this.upKey)) {
			this.y -= (1.125*Config.UNIT);
			this.setCurrentFloor(this.getCurrentFloor()+1);
		}
		if(InputUtility.getKeyPressed(this.downKey)) {
			this.y += (1.125*Config.UNIT);
			this.setCurrentFloor(this.getCurrentFloor()-1);
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
}
