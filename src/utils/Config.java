package utils;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Config {
	public static final double SCREEN_WIDTH = 1280;
	public static final double SCREEN_HEIGHT = 720;
	public static final double UNIT = (SCREEN_WIDTH / 16); // 16:9
	public static final double FLOOR_HEIGHT = UNIT * 1.125;

	public static final int DECREASE_RATE = 20;
	public static final double MAX_PATIENCE = 100000;
	public static final double MAX_LOW_PATIENCE = MAX_PATIENCE * 0.5;
	public static final double MAX_MEDIUM_PATIENCE = MAX_PATIENCE;
	public static final double MAX_HIGH_PATIENCE = MAX_PATIENCE * 1.3;

	public static final double STANDARD_PATIENCE = 120000;
	public static final double INFLUANCER_PATIENCE = 120000;
	public static final double FAT_PATIENCE = 120000;
	public static final double VIP_PATIENCE = 120000;

	public static final int TOTAL_FLOOR = 7;
	public static final int FIRST_FLOOR = 0;
	public static final int TOP_FLOOR = TOTAL_FLOOR - 1;

	public static final int MAX_CUSTOMER_PER_FLOOR = 10;
	public static final int MAX_CUSTOMER_PER_CABIN = 5;

	public static final int MAX_TIME_GAUGE = 10000;
	public static final int BASE_SCORE_GAIN = 100;
	public static final double TIME_GAIN = MAX_TIME_GAUGE * 0.025;
	public static final double TIME_LOSS = MAX_TIME_GAUGE * 0.05;
	public static final double TIME_GAUGE_DECREASE_PERCENT = 0.04;

	public static final Color PATIENCE_GAUGE = Color.GREEN;
	public static final Color PATIENCE_GAUGE_HIGH_P = Color.GREEN;
	public static final Color PATIENCE_GAUGE_MEDIUM_P = Color.ORANGE;
	public static final Color PATIENCE_GAUGE_LOW_P = Color.RED;

	public static final Color PATIENCE_GAUGE_BORDER = Color.BLACK;

	public static final Color TEXT_FILL = Color.WHITE;
	public static final Color TEXT_STROKE = Color.BLACK;

	public static final double ELEV_SPEED = UNIT * 0.0225;

}
