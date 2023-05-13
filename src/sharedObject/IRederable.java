package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRederable {
	public int getZ();
	public void draw(GraphicsContext gc);
	public boolean isDestroyed();
	public boolean isVisible();
}
