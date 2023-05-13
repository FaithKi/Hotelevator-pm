package logic.game;

public enum RailSpeed {
	NORMAL(1),
	FAST(2),
	EXTRA_FAST(3);
	
	private final int speed;
	
	RailSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
}
