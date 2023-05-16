package entity.cutomer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.game.PatienceLevel;
import utils.CustomerUtils;

public class StandardCustomer extends BaseCustomer {

//	private int currentFloor; --SETTED
//	private int destinationFloor; --SETTED
////	protected PatienceLevel patienceLevel;
//	protected double patienceLeft;
//	protected int reward;// extra time
//	protected int punishment;// reduced time
//	protected int z;
//	protected Image image;
	
	public StandardCustomer() {
		super();
		
		reward = 1;
		punishment = 10;
	}

	@Override
	public void successAction() {
		// TODO Auto-generated method stub
		System.out.println("successAction for StandartCustomer");
	}

	@Override
	public void failedAction() {
		// TODO Auto-generated method stub
		System.out.println("failedAction for StandartCustomer");
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
