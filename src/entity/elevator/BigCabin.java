package entity.elevator;

import logic.game.CabinSize;
import logic.game.HotelFloor;

public class BigCabin extends BaseCabin {

	public BigCabin(HotelFloor currentFloor, BaseRail rail) {
		super(currentFloor, rail);
		this.setCabinSize(CabinSize.BIG);
		this.setBuyPrice(3);
		this.setPriceMultiplier(2d);
	}

}
