package entity.elevator;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import logic.game.HotelFloor;

public class Elevator {

	private final int capacity = 5;
	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private int currentFloor;
	
	public Elevator() {
		this.passengers = new ArrayList<>();
		this.currentFloor = 1;
		this.numberOfPassenger = 0;
	}
	
	public int moveUp() {
		this.currentFloor += 1;
		return this.currentFloor;
	}
	
	public int moveDown() {
		this.currentFloor -= 1;
		return this.currentFloor;
	}
}
