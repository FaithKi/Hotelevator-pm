package pane;

import entity.Entity;
import entity.elevator.Elevator;
import javafx.scene.canvas.Canvas;
import logic.game.GameLogic;
import utils.Config;

public class ElevatorZone extends Canvas{

	private int id;
	
	public ElevatorZone(int id) {
		super((Config.UNIT * 1.5), (Config.UNIT * (1.125 * 7)));
		this.id = id;
		addListener();
	}
	
	private void addListener() {
		GameLogic logic = GameLogic.getInstance();
		this.setOnMouseClicked((e) -> {
			for(Entity entity: logic.getGameObjectContainer()) {
				if(entity instanceof Elevator) {
					Elevator elev = (Elevator) entity;
					if(elev.getId() == this.id) {
						elev.setSelected(true);
						System.out.println("select elev " + elev.getId());
					} else {
						elev.setSelected(false);
						System.out.println("unselect elev " + elev.getId());
					}
				}
			}
		});
	}
}
