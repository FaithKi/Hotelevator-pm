package entity.elevator;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.CustomerUtils;

public class InsideCabin extends Entity {
	private final int capacity = 5;
	private int numberOfPassenger;
	private BaseCustomer[] passengers;
	private Elevator elevator;

	public InsideCabin(Elevator elevator) {
		this.numberOfPassenger = 0;
		this.passengers = new BaseCustomer[Config.MAX_CUSTOMER_PER_FLOOR];
		this.elevator = elevator;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 80));
		gc.fillText(Integer.toString(this.getElevator().getId()), 0.2 * Config.UNIT, Config.UNIT);
		for (int i = 0; i < passengers.length - 1; i++) {
			if (!(passengers[i] == null))
				passengers[i].drawInCabin(gc);
		}
	}

	@Override
	public void update() {
		for (int i = 0; i < passengers.length; i++) {
			if (!(passengers[i] == null)) {
				BaseCustomer customer = passengers[i];
				customer.update();
				if (customer.getPatienceLeft() == 0) {
					CustomerUtils.removeCustomerFromCabin(customer, this, i);
					GameLogic.getInstance().getTimeGauge()
							.setTimeLeft(GameLogic.getInstance().getTimeGauge().getTimeLeft()
									- (int) Math.round(Config.MAX_TIME_GAUGE * 0.05));
				}
			}

		}

	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		if (numberOfPassenger < 0)
			numberOfPassenger = 0;
		this.numberOfPassenger = numberOfPassenger;
	}

	public int getCapacity() {
		return capacity;
	}

	public BaseCustomer[] getPassengers() {
		return passengers;
	}

	public Elevator getElevator() {
		return elevator;
	}

}
