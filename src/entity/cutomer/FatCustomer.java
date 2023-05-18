package entity.cutomer;

import entity.elevator.InsideCabin;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class FatCustomer extends BaseCustomer {

	public FatCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.INFLUANCER_PATIENCE);
		this.patienceLeft = maxPatience;
		this.reward = 10;
		this.punishment = 10;
		this.occupiedSpace = 2;
		setImage(RenderableHolder.fatCustomerHappy);
	}

	@Override
	public boolean canEnterCabin(InsideCabin insideCabin) {
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
	public void successAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void failedAction() {
		// TODO Auto-generated method stub

	}
}
