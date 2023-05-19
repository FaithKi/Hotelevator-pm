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
		setImage(RenderableHolder.standardCustomerHappy);
	}

	public StandardCustomer(PatienceLevel patienceLevel) {
		super();
		setCustomerPatienceType(patienceLevel);
	}

	@Override
	public boolean canEnter(InsideCabin insideCabin) {
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
	public void setCustomerPatienceType(PatienceLevel patienceLevel) {
		switch (patienceLevel) {
		case LOW: {
			this.maxPatience = Config.MAX_LOW_PATIENCE;
			this.setImage(RenderableHolder.standardCustomerLow);
			System.out.println("Enter: LOW");
			break;
		}

		case MEDIUM: {
			this.maxPatience = Config.MAX_MEDIUM_PATIENCE;
			this.setImage(RenderableHolder.standardCustomerMedium);
			System.out.println("Enter: ME");
			break;
		}

		case HIGH: {
			this.maxPatience = Config.MAX_HIGH_PATIENCE;
			this.setImage(RenderableHolder.standardCustomerHigh);
			System.out.println("Enter: HI");
			break;
		}

		}
		this.setPatienceLeft(maxPatience);

	}

}
