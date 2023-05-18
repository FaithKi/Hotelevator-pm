package entity.cutomer;

import entity.elevator.InsideCabin;
import sharedObject.RenderableHolder;
import utils.Config;

public class VIPCustomer extends BaseCustomer {

	public VIPCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.VIP_PATIENCE);
		this.patienceLeft = maxPatience;
		this.reward = 10;
		this.punishment = 10;
		this.occupiedSpace = 1;
		setImage(RenderableHolder.fatCustomerHappy);
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
	public boolean canEnterCabin(InsideCabin insideCabin) {

		return false;
	}

}
