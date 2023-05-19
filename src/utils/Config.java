package utils;

import javafx.scene.paint.Color;

public class Config {
//	public static final double SCREEN_WIDTH = 1440;
//	public static final double SCREEN_HEIGHT = 810;
	public static final double SCREEN_WIDTH = 1280;
	public static final double SCREEN_HEIGHT = 720;
	public static final double UNIT = (SCREEN_WIDTH / 16); // 16:9

	public static final int DECREASE_RATE = 20;
	public static final double MAX_PATIENCE = 30000;
	public static final double STANDARD_PATIENCE = 120000;
	public static final double INFLUANCER_PATIENCE = 120000;
	public static final double FAT_PATIENCE = 120000;
	public static final double VIP_PATIENCE = 120000;

	public static final int FIRST_FLOOR = 0;
	public static final int TOP_FLOOR = 6;
	public static final int MAX_CUSTOMER_PER_FLOOR = 10;
	public static final int MAX_CUSTOMER_PER_CABIN = 5;
	public static final int MAX_TIME_GAUGE = 4000;

	public static final Color PATIENCE_GAUGE = Color.GREEN;
	public static final Color PATIENCE_GAUGE_BORDER = Color.BLACK;
	public static final Color TEXT_FILL = Color.WHITE;
	public static final Color TEXT_STROKE = Color.BLACK;
	
	public static final double ELEV_SPEED = UNIT * 0.01125;

}
