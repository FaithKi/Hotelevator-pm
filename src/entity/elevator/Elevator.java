package entity.elevator;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Elevator extends Entity{

	private final int capacity = 5;
	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private int currentFloor;
	private int id;
	
	public Elevator(int id, int x, int y) {
		this.id = id;
		this.passengers = new ArrayList<>();
		this.currentFloor = 1;
		this.numberOfPassenger = 0;
		this.x = x;
		this.y = y;
		this.z = 100;
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
		gc.drawImage(RenderableHolder.cabinSprite , x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		return id;
	}
	
}
