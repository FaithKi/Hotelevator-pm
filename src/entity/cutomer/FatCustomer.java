package entity.cutomer;

import sharedObject.RenderableHolder;
import utils.Config;

public class FatCustomer extends BaseCustomer {

	public FatCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.INFLUANCER_PATIENCE);
		this.patienceLeft = maxPatience;
		this.reward = 10;
		this.punishment = 10;
		setImage(RenderableHolder.standardCustomerHappy);
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
