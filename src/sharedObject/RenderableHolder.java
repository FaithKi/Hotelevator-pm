package sharedObject;

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
	public static WritableImage elevatorRailSprite;
	public static Image cabinSprite;
	
	
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
		hotelSprite = new Image(ClassLoader.getSystemResource("Hotel.png").toString(),1000,800,true,false);
		elevatorRailSprite = new WritableImage(new Image(ClassLoader.getSystemResource("Elevator Rail.png").toString(),100,800,true,false).getPixelReader(),0,0,190,799);
		cabinSprite = new Image(ClassLoader.getSystemResource("Box.png").toString(),120,120,true,false);
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof Hotel) System.out.println("hotel");
			
		}
	}

	public void update() {

	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
