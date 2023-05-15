package logic.game;

import entity.building.Hotel;
import logic.sidebar.Wallet;

public class GameLogic {
	private Hotel hotel;
	private Wallet wallet;
	
	private static GameLogic instance = null;
	
	private GameLogic() {
		this.hotel = new Hotel();
	}
	
	public static GameLogic getInstance() {
        if(instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

//    public static GameLogic getInstance(int level) {
//        if(instance == null) {
//            instance = new GameLogic(level);
//        }
//        return instance;
//    }
}
