package utils;

import javafx.scene.paint.Color;

public class Config {
//	public static final double SCREEN_WIDTH = 1440;
//	public static final double SCREEN_HEIGHT = 810;
	public static final double SCREEN_WIDTH = 1280;
	public static final double SCREEN_HEIGHT = 720;
	public static final double UNIT = (SCREEN_WIDTH / 16); // 16:9

	public static final double MAX_PATIENCE = 300000;
	public static final double STANDARD_PATIENCE = 60000;
	public static final double INFLUANCER_PATIENCE = 60000;
	public static final double FAT_PATIENCE = 60000;
	public static final double VIP_PATIENCE = 60000;

	public static final int FIRST_FLOOR = 0;
	public static final int TOP_FLOOR = 6;
	public static final int MAX_CUSTOMER_PER_FLOOR = 10;
	public static final int MAX_TIME_GAUGE = 3000;

	public static final Color PATIENCE_GAUGE = Color.GREEN;
	public static final Color PATIENCE_GAUGE_BORDER = Color.BLACK;

}
