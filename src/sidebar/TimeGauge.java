package sidebar;

import entity.Entity;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public class TimeGauge extends Entity{
	
    private final int MAX_TIME = 100;
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
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}