package sharedObject;

import utils.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.building.CustomerGrid;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;

public class RenderableHolder {
	private static RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image hotelSprite;
	public static Image shaftBg;
	public static Image scifiTile;
	public static Image sideBarSprite;
	public static Image bottomBarSprite;
	public static Image hotelFloorSprite;
	public static Image standardCustomerHappy, fatCustomerHappy, vipCustomerHappy;
	public static Image bgSprite;
	public static Image wallpapers;
	public static Image gameName;
	public static Image startBg;
	public static Image instBg;
	public static Image exitBg;
	public static Image healthBar;
	public static WritableImage wallpaper;
	public static WritableImage health;
	public static WritableImage healthContainer;
	public static WritableImage cabinSprite;
	public static WritableImage insBg;
	public static Font pixelStyleFont;

	public static Image standardCustomerHigh, standardCustomerMedium, standardCustomerLow;
	public static Image fatCustomerHigh, fatCustomerMedium, fatCustomerLow;
	public static Image vipCustomerHigh, vipCustomerMedium, vipCustomerLow;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void setInstance() {
		instance = new RenderableHolder();
	}

	public static void loadResource() {
		startBg = new Image(ClassLoader.getSystemResource("button.png").toString(), 240, 68, false, false);
		instBg = new Image(ClassLoader.getSystemResource("button.png").toString(), 246, 36, false, false);
		exitBg = new Image(ClassLoader.getSystemResource("button.png").toString(), 106, 36, false, false);
		gameName = new Image(ClassLoader.getSystemResource("game-name.png").toString(), (Config.UNIT * 10),
				(Config.UNIT * 1.125 * 7), true, false);
		hotelSprite = new Image(ClassLoader.getSystemResource("hotel.png").toString(), (Config.UNIT * 8.5),
				(Config.UNIT * 1.125 * 7), true, false);
		healthBar = new Image(ClassLoader.getSystemResource("healthbar.png").toString(), 23*6, 80*6, false, false);
		health = new WritableImage(healthBar.getPixelReader(),84,48,54,384);
		healthContainer = new WritableImage(healthBar.getPixelReader(),0,0, 54,80*6);
		shaftBg = new Image(ClassLoader.getSystemResource("shaftbg.png").toString(),
				(Config.UNIT * 1.5), (Config.UNIT * 1.125 * 7), true, false);
		scifiTile = new Image(ClassLoader.getSystemResource("scifi_sheet.png").toString(), (491),
				(717), false, false);
		cabinSprite = new WritableImage(scifiTile.getPixelReader(),370,0,120,90);
		sideBarSprite = new Image(ClassLoader.getSystemResource("sidebar.png").toString(), 120, 120, true, false);
		bottomBarSprite = new Image(ClassLoader.getSystemResource("bottombar.png").toString(), 120, 120, true, false);
		hotelFloorSprite = new Image(ClassLoader.getSystemResource("floor.png").toString(), (Config.UNIT * 8.5),
				(Config.UNIT * 1.125), true, false);

		loadCustomer();

		bgSprite = new Image(ClassLoader.getSystemResource("bg-superreduced.gif").toString(), (Config.UNIT * 16),
				(Config.UNIT*8*1.125), true, false);
		wallpapers = new Image(ClassLoader.getSystemResource("wallpapers.png").toString(), (Config.UNIT * 16),
				(1115), true, false);
		wallpaper = new WritableImage(wallpapers.getPixelReader(), 10,258,68,90);
		pixelStyleFont = Font.loadFont(ClassLoader.getSystemResource("pixelFont.ttf").toString(), 20);
	}

	public void add(IRenderable entity) {
//		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
//		for (IRenderable x : entities) {
//			if (x instanceof Hotel)
//				System.out.println("hotel");
//
//		}
	}

	public void update() {

	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	private static void loadCustomer() {
		standardCustomerHappy = new Image(ClassLoader.getSystemResource("StandardCustomer_Happy.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		fatCustomerHappy = new Image(ClassLoader.getSystemResource("FatCustomer_Happy.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		vipCustomerHappy = new Image(ClassLoader.getSystemResource("VIPCustomer_Happy.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);

		standardCustomerHigh = new Image(ClassLoader.getSystemResource("StandardCustomer_High.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		standardCustomerMedium = new Image(ClassLoader.getSystemResource("StandardCustomer_Medium.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		standardCustomerLow = new Image(ClassLoader.getSystemResource("StandardCustomer_Low.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);

		fatCustomerHigh = new Image(ClassLoader.getSystemResource("FatCustomer_High.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		fatCustomerMedium = new Image(ClassLoader.getSystemResource("FatCustomer_Medium.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		fatCustomerLow = new Image(ClassLoader.getSystemResource("FatCustomer_Low.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);

		vipCustomerHigh = new Image(ClassLoader.getSystemResource("VIPCustomer_High.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		vipCustomerMedium = new Image(ClassLoader.getSystemResource("VIPCustomer_Medium.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);
		vipCustomerLow = new Image(ClassLoader.getSystemResource("VIPCustomer_Low.png").toString(),
				(Config.UNIT * 0.75), (Config.UNIT), true, false);

	}
}
