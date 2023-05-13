package entity.building;

import java.util.ArrayList;

import entity.cutomer.BaseCustomer;
import entity.elevator.BaseRail;

public class Hotel {
	
	private ArrayList<ArrayList<BaseCustomer>> floors;
	private ArrayList<ArrayList<BaseRail>> shafts;
	
	public Hotel() {
		this.floors = new ArrayList<>();
		for(int i=0;i<7;i++) {
			this.floors.add(new ArrayList<>());
		}
		this.shafts = new ArrayList<>();
		for(int i=0;i<3;i++) {
			this.shafts.add(new ArrayList<>());
		}
	}
}
