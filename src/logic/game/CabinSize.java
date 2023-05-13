package logic.game;

public enum CabinSize {
	BIG(8),
	MEDIUM(5),
	SMALL(3);
	
	private final int capacity;
	
	CabinSize(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
}
