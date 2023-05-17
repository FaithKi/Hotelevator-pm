package sidebar;

import entity.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import utils.Config;

public class TimeGauge extends Entity{
	
    private final int MAX_TIME = 10_000;
    private int currentTime;
    
    
    public TimeGauge() {
    	currentTime = MAX_TIME;
    	//this.x = ;
    	//this.y = ;
    	//this.z = ;
    }
    
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.CRIMSON);
		gc.fillRect(0, 0, Config.UNIT , Config.UNIT*6*1.125);
	}
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.setCurrentTime(this.getCurrentTime()-1);
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
}