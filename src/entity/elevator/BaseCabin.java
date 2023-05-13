package entity.elevator;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import logic.game.CabinSize;
import logic.game.HotelFloor;

public abstract class BaseCabin {
	
	private BaseRail rail;
	private CabinSize cabinSize;
//	private int numberOfPassenger;
	private ArrayList<BaseCustomer> passengers;
	private HotelFloor currentFloor;
	private HotelFloor destinationFloor;
	private int buyPrice;
	private double priceMultiplier;
	
	public CabinSize getCabinSize() {
		return cabinSize;
	}

	public void setCabinSize(CabinSize cabinSize) {
		this.cabinSize = cabinSize;
	}

	public BaseCabin(HotelFloor currentFloor, BaseRail rail) {
		this.currentFloor = currentFloor;
		this.rail = rail;
//		this.numberOfPassenger = 0;
		this.passengers = new ArrayList<BaseCustomer>();
	}
	
	public void goToFloor(HotelFloor destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	public boolean isMoving() {
		return this.destinationFloor != null;
	}
	
	public HotelFloor getDestinationFloor() {
		return this.destinationFloor;
	}
	
	public BaseRail getRail() {
		return this.rail;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getPriceMultiplier() {
		return priceMultiplier;
	}

	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}
	
}
