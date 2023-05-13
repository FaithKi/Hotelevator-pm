package entity.elevator;

import java.util.ArrayList;

import logic.game.HotelFloor;
import logic.game.RailSpeed;

public class NormalRail extends BaseRail{

	public NormalRail(BaseCabin cabin, ArrayList<HotelFloor> availableFloors) {
		super(cabin, availableFloors);
		this.setRailSpeed(RailSpeed.NORMAL);
		this.setPriceMultiplier(1);
	}
}
