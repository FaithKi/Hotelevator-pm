package sharedObject;

import utils.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.building.Hotel;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image hotelSprite;
	public static Image elevatorRailSprite;
	public static Image cabinSprite;
	public static Image sideBarSprite;
	public static Image bottomBarSprite;

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

	public static void loadResource() {
		hotelSprite = new Image(ClassLoader.getSystemResource("hotel.png").toString(), (Config.UNIT * 8.5),
				(Config.UNIT * 1.125 * 7), true, false);
		elevatorRailSprite = new Image(ClassLoader.getSystemResource("elevatorshaft.png").toString(), (Config.UNIT * 1.5), (Config.UNIT * 1.125 * 7), true, false);
		cabinSprite = new Image(ClassLoader.getSystemResource("cabin.png").toString(), 120, 120, true, false);
		sideBarSprite = new Image(ClassLoader.getSystemResource("sidebar.png").toString(), 120, 120, true, false);
		bottomBarSprite = new Image(ClassLoader.getSystemResource("bottombar.png").toString(), 120, 120, true, false);
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for (IRenderable x : entities) {
			if (x instanceof Hotel)
				System.out.println("hotel");

		}
	}

	public void update() {

	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
