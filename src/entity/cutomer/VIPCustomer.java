package entity.cutomer;

import entity.elevator.InsideCabin;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class VIPCustomer extends BaseCustomer {

	public VIPCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.VIP_PATIENCE);
		this.patienceLeft = maxPatience;
		this.reward = 10;
		this.punishment = 10;
		this.occupiedSpace = 1;
		setImage(RenderableHolder.vipCustomerHappy);
	}

	@Override
	public void successAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void failedAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getOccupiedSpace();
		if (cabinCapacity < currentSpace + spaceNeeded) {
			return false;
		}
		return true;
	}

}
