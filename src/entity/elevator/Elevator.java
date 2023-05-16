package entity.elevator;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;
import utils.Config;

public class Elevator extends Entity{

	private final int capacity = 5;
	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private int currentFloor;
	private int id;
	private KeyCode upKey, downKey;
	private double moveY;
	
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
		this.moveY = 0;
	}
	
	public int moveUp() {
		this.setCurrentFloor(this.getCurrentFloor()+1);
		return this.currentFloor;
	}
	
	public int moveDown() {
		this.setCurrentFloor(this.getCurrentFloor()-1);
		return this.currentFloor;
	}
	
	public void move() {
		if(this.moveY > 0) {
			this.moveY -= 0.0225*Config.UNIT;
			this.y += 0.0225*Config.UNIT;
		}
		if(this.moveY < 0) {
			this.moveY += 0.0225*Config.UNIT;
			this.y -= 0.0225*Config.UNIT;
		}
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
		move();
		System.out.println(this.y);
		if(this.y - ((7-this.getCurrentFloor())*1.125*Config.UNIT) < 10e-8) {
			if(InputUtility.getKeyPressed(this.upKey)) {
				System.out.println(this.currentFloor);
				moveUp();
				System.out.println(this.currentFloor);
				this.moveY = -1.125*Config.UNIT;
			}
			if(InputUtility.getKeyPressed(this.downKey)) {
				moveDown();
				this.moveY = 1.125*Config.UNIT;
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
}
