package logic.game;

public enum HotelFloor {
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	FIFTH(5),
	SIXTH(6),
	SEVENTH(7);
	
	private final int floorNumber;
	
	HotelFloor(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public int getFloorNumber() {
		return this.floorNumber;
	}
	
	public static HotelFloor toHotelFloor(int floorNumber) {
		switch(floorNumber) {
		case 1:
			return HotelFloor.FIRST;
		}
		return null;
	}
	
}
