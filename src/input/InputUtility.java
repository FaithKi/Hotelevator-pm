package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {

	public static double mouseX, mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	private static ArrayList<Integer> hotelGridPressed = new ArrayList<>();

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

	public static ArrayList<Integer> getHotelGridPressed() {
		ArrayList<Integer> hotelGrid = hotelGridPressed;
		hotelGridPressed = null;
		return hotelGrid;
	}

	public static void setHotelGridPressed(ArrayList<Integer> hotelGrid, boolean pressed) {
		if (pressed) {
			if (!hotelGridPressed.equals(hotelGrid)) {
				hotelGridPressed = hotelGrid;
			}
		} else {
			hotelGridPressed = null;
		}
		System.out.println("InputUtil Grid P:" + hotelGridPressed);
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
