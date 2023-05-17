package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {

	public static double mouseX, mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	private static int[] hotelGridPressed = new int[2];

	public static boolean getKeyPressed(KeyCode keycode) {
		return keyPressed.contains(keycode);
	}

	public static void setKeyPressed(KeyCode keycode, boolean pressed) {
		if (pressed) {
			if (!keyPressed.contains(keycode)) {
				keyPressed.add(keycode);
			}
		} else {
			keyPressed.remove(keycode);
		}
		System.out.println(keyPressed);
	}

	public static int[] getHotelGridPressed() {
		int[] grid = (int[]) hotelGridPressed;
		hotelGridPressed = new int[2];
		return grid;
	}

	public static void setHotelGridPressed(int[] hotelGrid, boolean pressed) {
		if (pressed) {
			if (!hotelGridPressed.equals(hotelGrid)) {
				hotelGridPressed = hotelGrid;
			}
		} else {
			hotelGridPressed = new int[2];
		}
		System.out.println("InputUtil Grid P:" + hotelGridPressed[0] + "-" + hotelGridPressed[1]);
	}

	public static void mouseLeftDown() {
		isLeftDown = true;
		isLeftClickedLastTick = true;
	}

	public static void mouseLeftRelease() {
		isLeftDown = false;
	}

	public static boolean isLeftClickTriggered() {
		return isLeftClickedLastTick;
	}

	public static void updateInputState() {
		isLeftClickedLastTick = false;
	}

}
