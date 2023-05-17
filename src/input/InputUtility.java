package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {

	public static double mouseX, mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	private static Integer[] hotelGridPressed = new Integer[2];
	private static Integer passengerIndexPressed;

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

	public static Integer[] getHotelGridPressed() {
		Integer[] grid = (Integer[]) hotelGridPressed;
		hotelGridPressed = new Integer[2];
		return grid;
	}

	public static void setHotelGridPressed(Integer[] hotelGrid, boolean pressed) {
		if (pressed) {
			if (!hotelGridPressed.equals(hotelGrid)) {
				hotelGridPressed = hotelGrid;
			}
		} else {
			hotelGridPressed = new Integer[2];
		}
		System.out.println("InputUtil Grid P:" + hotelGridPressed[0] + "-" + hotelGridPressed[1]);
	}

	public static Integer getPassengerIndexPressed() {
		Integer index = (Integer) passengerIndexPressed;
		passengerIndexPressed = null;
		return index;
	}

	public static void setPassengerIndexPressed(Integer Index, boolean pressed) {
		if (pressed) {
			if (!(passengerIndexPressed == Index)) {
				passengerIndexPressed = Index;
			}
		} else {
			passengerIndexPressed = null;
		}
		System.out.println("InputUtil Index P:" + passengerIndexPressed);
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
