package entity.elevator;

import logic.game.CabinSize;
import logic.game.HotelFloor;

public class SmallCabin extends BaseCabin {
	
	public SmallCabin(HotelFloor currentFloor, BaseRail rail) {
		super(currentFloor, rail);
		this.setCabinSize(CabinSize.SMALL);
		this.setBuyPrice(1);
		this.setPriceMultiplier(2d);
	}
}
