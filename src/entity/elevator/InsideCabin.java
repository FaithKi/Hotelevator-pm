package entity.elevator;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import javafx.scene.canvas.GraphicsContext;
import utils.Config;

public class InsideCabin extends Entity {
	private final int capacity = 5;
	private int numberOfPassenger;
	private BaseCustomer[] passengers;

	public InsideCabin() {
		this.numberOfPassenger = 0;
		this.passengers = new BaseCustomer[Config.MAX_CUSTOMER_PER_FLOOR];
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < passengers.length - 1; i++) {
			if (!(passengers[i] == null))
				passengers[i].drawInCabin(gc);

		}
	}

	@Override
	public void update() {
		// TODO update all customer state

	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}

	public int getCapacity() {
		return capacity;
	}

	public BaseCustomer[] getPassengers() {
		return passengers;
	}

}
