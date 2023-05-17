package entity.building;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import entity.cutomer.StandardCustomer;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;

public class Hotel extends Entity {

	private BaseCustomer[][] floors;

	public Hotel() {
		floors = new BaseCustomer[10][7];
		this.z = 0;

		testCustomer();
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 7; col++) {
				if (!(floors[row][col] == null))
					floors[row][col].draw(gc);
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

		System.out.println(InputUtility.getHotelGridPressed()[0]);
	}

	public BaseCustomer[][] getFloors() {
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

		floors[0][customer1.getCurrentFloor()] = customer1;
		floors[1][customer2.getCurrentFloor()] = customer2;

//		floors.get(customer1.getCurrentFloor() - 1).add(customer1);
//		floors.get(customer2.getCurrentFloor() - 1).add(customer2);
	}

}
