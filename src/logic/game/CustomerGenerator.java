package logic.game;

import utils.Randomizer;

public class CustomerGenerator implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Randomizer random = new Randomizer();
		int customerType = random.getRandomInt(0, 0);
		
		switch(customerType) {
		case 0 :
			
		}
	}

}
