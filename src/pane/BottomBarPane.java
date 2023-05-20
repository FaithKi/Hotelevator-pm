package pane;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.game.GameLogic;
import sharedObject.RenderableHolder;
import utils.Config;
import utils.SoundUtils;

public class BottomBarPane extends BorderPane {

	private CustomerManager customerManager;
	private StackPane menuBtn;

	public BottomBarPane() {
		this.setPrefSize(Config.UNIT * 16, Config.UNIT * 1.125);
//		this.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));
		this.customerManager = new CustomerManager();
		this.setCenter(customerManager);
		initializeMenuBtn();
	}

	public void initializeMenuBtn() {
		this.menuBtn = new StackPane();
		this.menuBtn.setPrefSize(2 * Config.UNIT, Config.FLOOR_HEIGHT);
		this.menuBtn.setAlignment(Pos.CENTER);
		Text pauseTxt = new Text("Pause");
		pauseTxt.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 24));
		this.getMenuBtn().getChildren().add(pauseTxt);

		this.getMenuBtn()
				.setBackground(new Background(new BackgroundImage(RenderableHolder.pausePaneBackground,
						BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
						new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
		this.setRight(this.getMenuBtn());
		this.getMenuBtn().setOnMouseClicked((e) -> {
			SoundUtils.playTrack(RenderableHolder.buttonClickTrack);
			GameLogic.getInstance().getCustomerGenerator().stop();
			PausePane pausePane = (PausePane) this.getParent().getParent().getChildrenUnmodifiable().get(2);
			pausePane.setVisible(true);
			pausePane.requestFocus();
			System.out.println("menu clicked!");
		});
		this.getMenuBtn().setOnMouseEntered(e -> {
			SoundUtils.playTrack(RenderableHolder.buttonHoverTrack, 0.3);
			this.getMenuBtn().setCursor(Cursor.HAND);
			pauseTxt.setFill(Color.GOLDENROD);
			pauseTxt.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 28));
		});

		this.getMenuBtn().setOnMouseExited(e -> {
			this.getMenuBtn().setCursor(Cursor.DEFAULT);
			pauseTxt.setFill(Color.BLACK);
			pauseTxt.setFont(Font.font(RenderableHolder.pixelStyleFont.getFamily(), 24));
		});

	}

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public StackPane getMenuBtn() {
		return menuBtn;
	}
}
