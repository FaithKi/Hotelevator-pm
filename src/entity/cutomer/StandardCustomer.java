package entity.cutomer;

import javafx.scene.canvas.GraphicsContext;

public class StandardCustomer extends BaseCustomer {

	public StandardCustomer() {
		reward = 1;
		punishment = 10;
		
	}

	@Override
	public void successAction() {
		// TODO Auto-generated method stub
		System.out.println("successAction for StandartCustomer");
	}

	@Override
	public void failedAction() {
		// TODO Auto-generated method stub
		System.out.println("failedAction for StandartCustomer");
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
