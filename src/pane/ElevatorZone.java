package pane;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import utils.Config;

public class ElevatorZone extends HBox {
    GridPane shaft1, shaft2, shaft3;
    private Canvas elevCanvas1,elevCanvas2,elevCanvas3;
    private GraphicsContext gc1,gc2,gc3;
    private ArrayList<GraphicsContext> gcs;
    
    
    public ElevatorZone() {
        this.setPrefSize((Config.UNIT * 4.5), (Config.UNIT * (1.125 * 7)));
//        this.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
        initializeShafts();
    }
    
    public void initializeShafts() {
        shaft1 = new GridPane();
        shaft2 = new GridPane();
        shaft3 = new GridPane();
        shaft1.setPrefSize(Config.UNIT*1.5, Config.UNIT*7*1.125);
        shaft2.setPrefSize(Config.UNIT*1.5, Config.UNIT*7*1.125);
        shaft3.setPrefSize(Config.UNIT*1.5, Config.UNIT*7*1.125);
        shaft1.setBackground(new Background(new BackgroundImage(RenderableHolder.elevatorRailSprite, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, null, null)));
        shaft2.setBackground(new Background(new BackgroundImage(RenderableHolder.elevatorRailSprite, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, null, null)));
        shaft3.setBackground(new Background(new BackgroundImage(RenderableHolder.elevatorRailSprite, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, null, null)));
        
        this.getChildren().addAll(shaft1,shaft2,shaft3);
        
        elevCanvas1 = new Canvas(Config.UNIT*1.5,Config.UNIT*1.125);
        elevCanvas2 = new Canvas(Config.UNIT*1.5,Config.UNIT*1.125);
        elevCanvas3 = new Canvas(Config.UNIT*1.5,Config.UNIT*1.125);
        shaft1.add(elevCanvas1,0,0);
        shaft2.add(elevCanvas2,0,0);
        shaft3.add(elevCanvas3,0,0);
        gc1 = elevCanvas1.getGraphicsContext2D();
        gc2 = elevCanvas2.getGraphicsContext2D();
        gc3 = elevCanvas3.getGraphicsContext2D();
        gcs = new ArrayList<>();
        gcs.add(gc1);
        gcs.add(gc2);
        gcs.add(gc3);
    }

	public ArrayList<GraphicsContext> getGcs() {
		return gcs;
	}

}