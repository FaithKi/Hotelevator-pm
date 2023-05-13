package entity.elevator;

import logic.game.CabinSize;
import logic.game.HotelFloor;

public class MediumCabin extends BaseCabin {
	
	public MediumCabin(HotelFloor currentFloor, BaseRail rail) {
		super(currentFloor, rail);
		this.setCabinSize(CabinSize.MEDIUM);
		this.setBuyPrice(2);
		this.setPriceMultiplier(1.4d);
	}
}
