package entity.cutomer;

import entity.elevator.InsideCabin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.game.PatienceLevel;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class StandardCustomer extends BaseCustomer {

//	private int currentFloor; --SETTED
//	private int destinationFloor; --SETTED
////	protected PatienceLevel patienceLevel;
//	protected double patienceLeft;
//	protected int reward;// extra time
//	protected int punishment;// reduced time 
//	protected int z; --SETTED
//	protected Image image;

	public StandardCustomer() {
		super();
		this.maxPatience = setStartingPatience(Config.STANDARD_PATIENCE);
		this.patienceLeft = maxPatience;
		this.reward = 1;
		this.punishment = 10;
		setImage(RenderableHolder.standardCustomerHappy);
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
	public boolean canEnterCabin(InsideCabin insideCabin) {
		int cabinCapacity = insideCabin.getCapacity();
		int currentSpace = insideCabin.getNumberOfPassenger();
		int spaceNeeded = this.getOccupiedSpace();
		if (CustomerUtils.containVIP(insideCabin.getPassengers()))
			return false;
		if (cabinCapacity < currentSpace + spaceNeeded) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
