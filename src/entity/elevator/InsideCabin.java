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
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

		for (int col = 0; col < Config.MAX_CUSTOMER_PER_FLOOR; col++) {
			if (!(passengers[col] == null))
				passengers[col].draw(gc);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		for (int col = 0; col < Config.MAX_CUSTOMER_PER_FLOOR; col++) {
			if (!(passengers[col] == null))
				passengers[col].update();
		}
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return super.getZ();
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
