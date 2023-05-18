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

		addCustomerToFirstEmptyIndex(customer, customerGrid, floorIndex);
		System.out.println("customer addded");
		return true;
	}

	public static void addElement(Integer[] floor) {

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

	public static void addCustomerToFirstEmptyIndex(BaseCustomer customer, BaseCustomer[][] customerGrid,
			int floorIndex) {

		for (int col = 0; col < customerGrid[floorIndex].length; col++) {
			if (customerGrid[floorIndex][col] == null) {
				customer.setCurrentQueue(col);
				customerGrid[floorIndex][col] = customer;
				break;
			}
		}

	}

}
