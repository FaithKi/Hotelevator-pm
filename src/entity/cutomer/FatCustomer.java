package entity.cutomer;

import entity.elevator.InsideCabin;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class FatCustomer extends BaseCustomer {
//
//	public FatCustomer() {
//		super();
//		this.maxPatience = setStartingPatience(Config.INFLUANCER_PATIENCE);
//		this.patienceLeft = maxPatience;
//		this.occupiedSpace = 2;
//		this.rewardMultiplier = 1;
//		setImage(RenderableHolder.fatCustomerHappy);
//	}

	public FatCustomer(PatienceLevel patienceLevel) {
		super();
		this.spaceNeeded = 2;
		this.rewardMultiplier = 2;
		setCustomerPatienceType(patienceLevel);
	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getSpaceNeeded();
		if (CustomerUtils.containVIP(insideCabin.getPassengers()))
			return false;
		if (cabinCapacity < currentSpace + spaceNeeded) {
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		return "FatCustomer";
	}

	@Override
	public void setCustomerPatienceType(PatienceLevel patienceLevel) {
		switch (patienceLevel) {
		case LOW: {
			this.maxPatience = Config.MAX_LOW_PATIENCE;
			this.gaugeColor = Config.PATIENCE_GAUGE_LOW_P;
			this.setImage(RenderableHolder.fatCustomerLow);
			break;
		}

		case MEDIUM: {
			this.maxPatience = Config.MAX_MEDIUM_PATIENCE;
			this.gaugeColor = Config.PATIENCE_GAUGE_MEDIUM_P;
			this.setImage(RenderableHolder.fatCustomerMedium);
			break;
		}

		case HIGH: {
			this.maxPatience = Config.MAX_HIGH_PATIENCE;
			this.gaugeColor = Config.PATIENCE_GAUGE_HIGH_P;
			this.setImage(RenderableHolder.fatCustomerHigh);
			break;
		}

		}
		this.setPatienceLeft(maxPatience);

	}

}