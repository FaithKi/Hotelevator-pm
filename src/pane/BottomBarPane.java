package pane;

import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
		this.setBackground(new Background(new BackgroundFill(Color.SALMON, null, null)));
		this.customerManager = new CustomerManager();
		this.setCenter(customerManager);
		initializeMenuBtn();
	}

	public void initializeMenuBtn() {
		this.menuBtn = new StackPane();

		this.menuBtn.getChildren().add(new Text("PAUSE"));
		this.getMenuBtn().setPrefWidth(2 * Config.UNIT);
		this.getMenuBtn().setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
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
		});

		this.getMenuBtn().setOnMouseExited(e -> {
			this.getMenuBtn().setCursor(Cursor.DEFAULT);
		});

	}

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public StackPane getMenuBtn() {
		return menuBtn;
	}
}
