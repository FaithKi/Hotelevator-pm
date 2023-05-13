package entity.elevator;

import java.util.ArrayList;

import logic.game.HotelFloor;
import logic.game.RailSpeed;

public class HyperSpeedRail extends BaseRail{

	public HyperSpeedRail(BaseCabin cabin, ArrayList<HotelFloor> availableFloors) {
		super(cabin, availableFloors);
		this.setRailSpeed(RailSpeed.EXTRA_FAST);
		this.setPriceMultiplier(2);
	}

}
