package logic.game;

public enum PatienceLevel {
	HIGH(10),
	MEDIUM(8),
	LOW(6);
	
	private final int time;
	
	PatienceLevel(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return this.time;
	}
}
