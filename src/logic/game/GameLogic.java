package logic.game;

import java.util.ArrayList;

import entity.Entity;
import entity.building.Hotel;
import entity.elevator.Elevator;
import sharedObject.RenderableHolder;
import sidebar.TimeGauge;

public class GameLogic {
	private ArrayList<Entity> gameObjectContainer;
//	private TimeGauge timeGauge;
	private Hotel hotel;
	private Elevator elevator1;
//	private Elevator elevator2;
//	private Elevator elevator3;
	
	
	private static GameLogic instance = null;
	
	private GameLogic() {
		this.gameObjectContainer = new ArrayList<>();
//		this.timeGauge = new TimeGauge();
		this.hotel = new Hotel();
		this.elevator1 = new Elevator(50,50);
//		this.elevator2 = new Elevator();
//		this.elevator3 = new Elevator();
//		addNewObject(timeGauge);
		addNewObject(hotel);
		addNewObject(elevator1);
//		addNewObject(elevator2);
//		addNewObject(elevator3);
	}
	
	public static GameLogic getInstance() {
        if(instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		
	}

//    public static GameLogic getInstance(int level) {
//        if(instance == null) {
//            instance = new GameLogic(level);
//        }
//        return instance;
//    }
}
