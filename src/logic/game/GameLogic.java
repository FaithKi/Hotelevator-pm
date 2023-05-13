package logic.game;

import entity.building.Hotel;
import logic.sidebar.Wallet;

public class GameLogic {
	private Hotel hotel;
	private Wallet wallet;
	
	private static GameLogic instance = null;
	
	private GameLogic(Hotel hotel) {
		this.hotel = hotel;
		this.wallet = new Wallet();
	}
	
	public static GameLogic getInstance() {
        if(instance == null) {
            instance = new GameLogic(new Hotel());
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
