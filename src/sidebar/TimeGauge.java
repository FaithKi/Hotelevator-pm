package sidebar;

import entity.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.game.GameLogic;
import sharedObject.IRenderable;
import utils.Config;

public class TimeGauge extends Entity {

	private final int MAX_TIME = Config.MAX_TIME_GAUGE;
	private int timeLeft;
	private double height;

	public TimeGauge() {
		timeLeft = MAX_TIME;
		// this.x = ;
		this.y = Config.UNIT;
		// this.z = ;
		this.height = Config.UNIT * 6 * 1.125;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.GOLDENROD);
		gc.fillRect(0, 0, Config.UNIT * 1, Config.UNIT * (7 * 1.125));
		gc.setFill(Color.CRIMSON);
		gc.fillRect(Config.UNIT / 4, this.y, Config.UNIT / 2, this.height);
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (this.getTimeLeft() > 0) {
			this.setTimeLeft(this.getTimeLeft() - 1);
//			this.y += Config.UNIT * 6 * 1.125 / MAX_TIME;
//			this.height -= Config.UNIT * 6 * 1.125 / MAX_TIME;
		} else {
			GameLogic.getInstance().setGameOver(true);
		}
		this.height = this.getTimeLeft() * Config.UNIT * 6 * 1.125 / MAX_TIME;
		this.y = Config.UNIT + (MAX_TIME-this.getTimeLeft()) * Config.UNIT * 6 * 1.125 / MAX_TIME;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int d) {
		this.timeLeft = d;
	}
}