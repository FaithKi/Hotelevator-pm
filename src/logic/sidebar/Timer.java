package logic.sidebar;

public class Timer {
	
    private long startTime;
    private long endTime;
    private boolean running;

    public void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        endTime = System.currentTimeMillis();
        running = false;
    }

    public long getTimeElapsed() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        running = false;
    }
}