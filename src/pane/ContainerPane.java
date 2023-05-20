package pane;

import entity.building.CustomerGrid;
import entity.elevator.Elevator;
import input.InputUtility;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.game.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import sidebar.TimeGauge;
import utils.Config;
import utils.SoundUtils;

public class ContainerPane extends BorderPane {
	private SideBarPane sideBarPane;
	private HotelPane hotelPane;
	private BottomBarPane bottomBarPane;

	public ContainerPane() {
		// TODO: FILL CODE
		sideBarPane = new SideBarPane();
		hotelPane = new HotelPane();
		bottomBarPane = new BottomBarPane();
		this.setRight(sideBarPane);
		this.setCenter(hotelPane);
		this.setBottom(bottomBarPane);
		addListerner();
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public SideBarPane getSideBarPane() {
		return sideBarPane;
	}

	public HotelPane getHotelPane() {
		return hotelPane;
	}

	public BottomBarPane getBottomBarPane() {
		return bottomBarPane;
	}

	public void paintComponent() {
		if (!GameLogic.getInstance().isGameOver()) {
			for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
				if (entity instanceof Elevator) {
					Elevator elev = (Elevator) entity;
					if (elev.isSelected()) {
						elev.getInsideCabin().draw(this.getBottomBarPane().getCustomerManager().getGc());
					}
					elev.draw(this.getHotelPane().getElevs().get(elev.getId() - 1).getGraphicsContext2D());
				}
				if (entity instanceof CustomerGrid) {
					CustomerGrid hotel = (CustomerGrid) entity;
					hotel.draw(this.getHotelPane().getFloorZone().getGc());
				}
				if (entity instanceof TimeGauge) {
					TimeGauge timeGauge = (TimeGauge) entity;
					timeGauge.draw(this.getSideBarPane().getGc());
				}
			}
		} else {
			SoundUtils.playTrack(RenderableHolder.gameOverTrack, 0.4);
			String Score = Integer.toString(GameLogic.getInstance().getTimeGauge().getScore());

			Text gameScoreText = new Text("Your Score:");
			gameScoreText.setStroke(Color.rgb(14, 33, 54));
			gameScoreText.setStrokeWidth(5);
			gameScoreText.setFill(Color.rgb(231, 140, 156));
			gameScoreText.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 80));
			gameScoreText.setWrappingWidth(13 * Config.UNIT);
			gameScoreText.setTextAlignment(TextAlignment.CENTER);

			Text gameOverText = new Text("GameOver!");
			gameOverText.setStroke(Color.rgb(14, 33, 54));
			gameOverText.setStrokeWidth(5);
			gameOverText.setFill(Color.rgb(231, 140, 156));
			gameOverText.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 80));
			gameOverText.setWrappingWidth(13 * Config.UNIT);
			gameOverText.setTextAlignment(TextAlignment.CENTER);

			Text scoreText = new Text(Score);
			scoreText.setStroke(Color.rgb(14, 33, 54));
			scoreText.setStrokeWidth(5);
			scoreText.setFill(Color.rgb(231, 140, 156));
			scoreText.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 80));
			scoreText.setWrappingWidth(13 * Config.UNIT);
			scoreText.setTextAlignment(TextAlignment.CENTER);

			GridPane TextHolderPane = new GridPane();
			TextHolderPane.setPrefSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
			TextHolderPane.add(gameOverText, 0, 0);
			TextHolderPane.add(gameScoreText, 0, 1);
			TextHolderPane.add(scoreText, 0, 2);

			TextHolderPane.setAlignment(Pos.CENTER);
			TextHolderPane.setHgap(Config.UNIT);

			this.setCenter(TextHolderPane);
			this.setRight(null);
			this.setBottom(null);
			this.setOnMouseClicked((e) -> {
				this.getParent().getScene().setRoot(MainMenu.getInstance());
			});
		}
	}
}
