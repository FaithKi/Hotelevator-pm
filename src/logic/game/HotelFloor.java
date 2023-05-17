package logic.game;

public enum HotelFloor {
	FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7);

	private final int floorNumber;

	HotelFloor(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getFloorNumber() {
		return this.floorNumber;
	}

	public static HotelFloor toHotelFloor(int floorNumber) {
		switch (floorNumber) {
		case 1:
			return HotelFloor.FIRST;
		case 2:
			return HotelFloor.SECOND;
		case 3:
			return HotelFloor.THIRD;
		case 4:
			return HotelFloor.FOURTH;
		case 5:
			return HotelFloor.FIFTH;
		case 6:
			return HotelFloor.SIXTH;
		case 7:
			return HotelFloor.SEVENTH;
		}
		return null;
	}
}
