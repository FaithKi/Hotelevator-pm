package entity.cutomer;

import entity.elevator.InsideCabin;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class VIPCustomer extends BaseCustomer {

	public VIPCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.VIP_PATIENCE);
		this.patienceLeft = maxPatience;
		this.occupiedSpace = 1;
		setImage(RenderableHolder.vipCustomerHappy);
	}

	public VIPCustomer(PatienceLevel patienceLevel) {
		super();
		setCustomerPatienceType(patienceLevel);
	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getOccupiedSpace();
		BaseCustomer[] passengers = insideCabin.getPassengers();

		for (int i = 0; i < passengers.length; i++) {
			if (!(passengers[i] == null)) {
				if (!(passengers[i] instanceof VIPCustomer))
					return false;
			}
		}
		if (cabinCapacity < currentSpace + spaceNeeded) {
			return false;
		}
		return true;
	}

	@Override
	public void setCustomerPatienceType(PatienceLevel patienceLevel) {
		switch (patienceLevel) {
		case LOW: {
			this.maxPatience = Config.MAX_LOW_PATIENCE;
			this.setImage(RenderableHolder.vipCustomerLow);
			System.out.println("Enter: LOW");
			break;
		}

		case MEDIUM: {
			this.maxPatience = Config.MAX_MEDIUM_PATIENCE;
			this.setImage(RenderableHolder.vipCustomerMedium);
			System.out.println("Enter: ME");
			break;
		}

		case HIGH: {
			this.maxPatience = Config.MAX_HIGH_PATIENCE;
			this.setImage(RenderableHolder.vipCustomerHigh);
			System.out.println("Enter: HI");
			break;
		}

		}
		this.setPatienceLeft(maxPatience);

	}

}
