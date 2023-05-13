package entity.cutomer;

import logic.game.HotelFloor;
import logic.game.PatienceLevel;

public class NormalCustomer extends BaseCustomer {

	public NormalCustomer(PatienceLevel patienceLevel, HotelFloor destinationFloor, HotelFloor currentFloor,
			int payAmount) {
		super(patienceLevel, destinationFloor, currentFloor, payAmount);
		this.setDifficulty(this.getPatienceLevel().getTime());
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
