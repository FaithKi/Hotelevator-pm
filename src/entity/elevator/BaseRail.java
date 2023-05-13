package entity.elevator;

import java.util.ArrayList;

import logic.game.HotelFloor;
import logic.game.RailSpeed;

public abstract class BaseRail {

	private BaseCabin cabin;
	private ArrayList<HotelFloor> availableFloors;
	private RailSpeed railSpeed;
	private double priceMultiplier;
	
	public RailSpeed getRailSpeed() {
		return railSpeed;
	}

	public void setRailSpeed(RailSpeed railSpeed) {
		this.railSpeed = railSpeed;
	}

	public double getPriceMultiplier() {
		return priceMultiplier;
	}

	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}

	public BaseRail(BaseCabin cabin, ArrayList<HotelFloor> availableFloors) {
		this.cabin = cabin;
		this.availableFloors = availableFloors;
	}
	
	public BaseCabin getCabin() {
		return this.cabin;
	}
	
}