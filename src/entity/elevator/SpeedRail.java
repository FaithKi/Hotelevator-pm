package entity.elevator;

import java.util.ArrayList;

import logic.game.HotelFloor;
import logic.game.RailSpeed;

public class SpeedRail extends BaseRail {

	public SpeedRail(BaseCabin cabin, ArrayList<HotelFloor> availableFloors) {
		super(cabin, availableFloors);
		this.setRailSpeed(RailSpeed.FAST);
		this.setPriceMultiplier(1.5d);
	}

}
