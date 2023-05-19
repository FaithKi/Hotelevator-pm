package entity.cutomer;

import entity.elevator.InsideCabin;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class FatCustomer extends BaseCustomer {

	public FatCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.INFLUANCER_PATIENCE);
		this.patienceLeft = maxPatience;
		this.occupiedSpace = 2;
		setImage(RenderableHolder.fatCustomerHappy);
	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getOccupiedSpace();
		if (CustomerUtils.containVIP(insideCabin.getPassengers()))
			return false;
		if (cabinCapacity < currentSpace + spaceNeeded) {
			return false;
		}
		return true;

	}

	@Override
	public void setCustomerPatienceType(PatienceLevel patienceLevel) {
		// TODO Auto-generated method stub
		
	}


}
