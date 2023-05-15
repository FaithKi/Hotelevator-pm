package entity.building;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;

public class Hotel {
	
	private ArrayList<ArrayList<BaseCustomer>> floors;
	
	public Hotel() {
		this.floors = new ArrayList<>();
		for(int i=0;i<7;i++) {
			this.floors.add(new ArrayList<>());
		}
	}
}
