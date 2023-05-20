package entity.cutomer;

import entity.elevator.InsideCabin;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class VIPCustomer extends BaseCustomer {

//	public VIPCustomer() {
//		super();
//		this.maxPatience = setStartingPatience(Config.VIP_PATIENCE);
//		this.patienceLeft = maxPatience;
//		this.occupiedSpace = 1;
//		this.rewardMultiplier = 1.5;
//		setImage(RenderableHolder.vipCustomerHappy);
//	}

	public VIPCustomer(PatienceLevel patienceLevel) {
		super();
		this.rewardMultiplier = 1.5;
		setCustomerPatienceType(patienceLevel);
	}

	@Override
	public String toString() {
		return "VIPCustomer";
	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getSpaceNeeded();
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
			this.gaugeColor = Config.PATIENCE_GAUGE_LOW_P;
			this.setImage(RenderableHolder.vipCustomerLow);
			break;
		}

		case MEDIUM: {
			this.maxPatience = Config.MAX_MEDIUM_PATIENCE;
			this.gaugeColor = Config.PATIENCE_GAUGE_MEDIUM_P;
			this.setImage(RenderableHolder.vipCustomerMedium);
			break;
		}

		case HIGH: {
			this.maxPatience = Config.MAX_HIGH_PATIENCE;
			this.gaugeColor = Config.PATIENCE_GAUGE_HIGH_P;
			this.setImage(RenderableHolder.vipCustomerHigh);
			break;
		}

		}
		this.setPatienceLeft(maxPatience);

	}

}
