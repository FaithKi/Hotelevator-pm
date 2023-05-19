package sidebar;

import entity.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import logic.game.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import utils.Config;

public class TimeGauge extends Entity {

	private final int MAX_TIME = Config.MAX_TIME_GAUGE;
	private int timeLeft;
	private double height;
	private int score;
	private double y;

	public TimeGauge() {
		timeLeft = MAX_TIME;
		// this.x = ;
//		this.y = Config.UNIT;
		this.y = Config.UNIT * 1.5 + 48;
		// this.z = ;
//		this.height = Config.UNIT * 6 * 1.125;
		this.height = 384;
		this.score = 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		gc.setFill(Color.GOLDENROD);
//		gc.fillRect(0, 0, Config.UNIT * 1, Config.UNIT * (7 * 1.125));
//		gc.setFill(Color.CRIMSON);
//		gc.fillRect(Config.UNIT / 4, this.y, Config.UNIT / 2, this.height);
//		gc.setStroke(Color.BLACK);
//		gc.setLineWidth(2);
//		gc.strokeRect(Config.UNIT / 4, Config.UNIT, Config.UNIT / 2, Config.UNIT * 6 * 1.125);
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, Config.UNIT * 0.3, Config.UNIT, Config.UNIT * 0.5);
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 14));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText(Integer.toString(this.getScore()), Config.UNIT * 0.5, Config.UNIT * 0.7, Config.UNIT * 0.9);

		gc.drawImage(RenderableHolder.healthContainer, 0, Config.UNIT * 1.5);
		gc.drawImage(RenderableHolder.health, 0, this.y, 54, this.height);
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
		this.height = this.getTimeLeft() * 384 / MAX_TIME;
		this.y = Config.UNIT * 1.5 + 48 + (MAX_TIME - this.getTimeLeft()) * 384 / MAX_TIME;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int d) {
		this.timeLeft = d;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}