package entity.building;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.cutomer.StandardCustomer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Hotel extends Entity {

	private ArrayList<ArrayList<BaseCustomer>> floors;

	public Hotel() {
		this.floors = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			this.floors.add(new ArrayList<>());
		}
//		this.x = 0;
//		this.y = 0;
		this.z = 0;

		testCustomer();
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (ArrayList<BaseCustomer> floor : floors) {
			for (BaseCustomer customer : floor) {
				customer.draw(gc);
			}
		}

//		gc.drawImage(RenderableHolder.hotelSprite, x, y);
//		gc.setFill(Color.BLACK);
//		gc.fillRect(0, 0, 20, 20);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<BaseCustomer>> getFloors() {
		return floors;
	}

	private void testCustomer() {
		// TEST
		StandardCustomer customer1 = new StandardCustomer();
		customer1.setCurrentQueue(0);
		StandardCustomer customer2 = new StandardCustomer();
		customer2.setCurrentQueue(1);
		customer2.setPatienceLeft(15550);

		System.out.println(customer1.getCurrentFloor());
		System.out.println(customer2.getCurrentFloor());
		floors.get(customer1.getCurrentFloor() - 1).add(customer1);
		floors.get(customer2.getCurrentFloor() - 1).add(customer2);
	}

}
