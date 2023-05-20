package entity.building;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.elevator.Elevator;
import entity.elevator.InsideCabin;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import sidebar.TimeGauge;
import utils.Config;
import utils.CustomerUtils;
import utils.SoundUtils;

public class CustomerGrid extends Entity {
	private final BaseCustomer[][] customerGrid;

	public CustomerGrid() {
		super(100);
		customerGrid = new BaseCustomer[Config.MAX_CUSTOMER_PER_FLOOR][Config.TOTAL_FLOOR];
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

		for (BaseCustomer[] queue : customerGrid) {
			for (BaseCustomer customer : queue) {
				if (customer != null)
					customer.draw(gc);
			}
		}
	}

	@Override
	public void update() {

		handleCustomerUpdates();
		handleAddPassengerToCabin();

	}

	private void handleCustomerUpdates() {
		for (int queue = 0; queue < customerGrid.length; queue++) {
			for (int floor = 0; floor < customerGrid[0].length; floor++) {

				BaseCustomer customer = customerGrid[queue][floor];
				if (customer != null) {
					customer.update();
					if (customer.getPatienceLeft() <= 0) {
						CustomerUtils.removeCustomerFromFloor(customer, customerGrid, queue, floor);

						TimeGauge timeGauge = GameLogic.getInstance().getTimeGauge();
						int timeDeducted = (int) Math.round(Config.MAX_TIME_GAUGE * Config.TIME_GAUGE_DECREASE_PERCENT);
						timeGauge.setTimeLeft(timeGauge.getTimeLeft() - timeDeducted);
					}
				}

			}
		}
	}

	private void handleAddPassengerToCabin() {

		Integer[] grid = InputUtility.getHotelGridPressed();
		if (grid[0] == null)
			return;

		Integer queue = grid[0], floor = grid[1];
		Elevator selectedElevator = GameLogic.getInstance().selectedElev;

		if (selectedElevator.getCurrentFloor() == floor) {
			BaseCustomer customer = getCustomer(queue, floor);
			if (customer == null)
				return;
			boolean isAdded = addCustomerToCabin(customer, selectedElevator.getInsideCabin());
			if (isAdded) {
				CustomerUtils.removeCustomerFromFloor(customer, customerGrid, queue, floor);
			}
		}

	}

	public BaseCustomer[][] getFloors() {
		return customerGrid;
	}

	public BaseCustomer getCustomer(int x, int y) {
		if (x < 0 || x >= customerGrid.length || y < 0 || y >= customerGrid[0].length)
			return null;
		return customerGrid[x][y];
	}

	public static boolean addCustomerToCabin(BaseCustomer customer, InsideCabin insideCabin) {
		if (!customer.canEnter(insideCabin)) {
			SoundUtils.playTrack(RenderableHolder.addPassengerFailedTrack, 0.5);
			return false;
		}
		SoundUtils.playTrack(RenderableHolder.addPassengerSucceedTrack, 0.2);
		CustomerUtils.addPassengerToFirstToFirstEmptyQueueOfCabin(customer, insideCabin);
		return true;
	}

	public BaseCustomer[][] getCustomersGrid() {
		return customerGrid;
	}
}
