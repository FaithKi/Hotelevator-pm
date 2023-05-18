package utils;

import entity.building.CustomerGrid;
import entity.cutomer.BaseCustomer;
import entity.elevator.Elevator;

public class CustomerUtils {

	public static boolean addCustomerToFloorFromGenerator(BaseCustomer customer, BaseCustomer[][] customerGrid) { // BaseCustomer[queue][floor]
		int floorIndex = customer.getCurrentFloor();
		if (customerQueueIsFull(customerGrid, floorIndex)) {
			System.out.println("customer NOT addded");
			return false;
		}
		addCustomerToFirstEmptyQueueOfFloor(customer, customerGrid, floorIndex);
		System.out.println("customer addded");
		return true;
	}

	public static boolean customerQueueIsFull(BaseCustomer[][] customerGrid, int floorIndex) {

		for (int row = customerGrid[0].length - 1; row >= 0; row--) {
			BaseCustomer customer = customerGrid[row][floorIndex];
			// Perform operations with the element of the desired row
			if (customer == null)
				return false; // grid is empty
		}
		return true;

	}

	public static void addCustomerToFirstEmptyQueueOfFloor(BaseCustomer customer, BaseCustomer[][] customerGrid,
			int floorIndex) {

		for (int queue = 0; queue < customerGrid.length; queue++) {
			if (customerGrid[queue][floorIndex] == null) {
				customer.setCurrentQueue(queue);
				customerGrid[queue][floorIndex] = customer;
				break;
			}
		}

	}

	public static void removeCustomerFromFloor(BaseCustomer customer, BaseCustomer[][] customerGrid, int queueIndex,
			int floorIndex) { // tries to fill the empty space in the front first
		customerGrid[queueIndex][floorIndex] = null;
		// Perform the rearrangement
		int nonNullRow = 0;

		for (int row = 0; row < customerGrid.length; row++) {
			if (customerGrid[row][floorIndex] != null) {
				BaseCustomer tempCustomer = customerGrid[row][floorIndex];
				tempCustomer.setCurrentQueue(nonNullRow);
				customerGrid[row][floorIndex] = customerGrid[nonNullRow][floorIndex];
				customerGrid[nonNullRow][floorIndex] = tempCustomer;
				nonNullRow++;
			}
		}

	}

	public static void addPassengerToFirstToFirstEmptyQueueOfCabin(BaseCustomer customer, BaseCustomer[] passengers) {

		for (int queue = 0; queue < passengers.length; queue++) {
			if (passengers[queue] == null) {
				customer.setCurrentQueue(queue);
				passengers[queue] = customer;
				break;
			}
		}

	}

}
