package entity.building;

import java.util.ArrayList;

import entity.Entity;
import entity.cutomer.BaseCustomer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Hotel extends Entity {
	
	private ArrayList<ArrayList<BaseCustomer>> floors;
	
	public Hotel() {
		this.floors = new ArrayList<>();
		for(int i=0;i<7;i++) {
			this.floors.add(new ArrayList<>());
		}
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.hotelSprite, x, y);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 20, 20);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ArrayList<BaseCustomer>> getFloors() {
		return floors;
	}
	
	
}
