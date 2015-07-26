package gui;

import javafx.scene.image.ImageView;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.Logger;
import utils.Parent;

public class Panel extends Parent implements EventHandlerAble {

	private ImageView background = new ImageView("/images/Background.png");
	private PanelGame panelGame = null;

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(new EventHandler(this));

		this.getChildren().add(this.background);

		createNewPanelGame();

	}

	public void restartGame() {

		Logger.logNewLine("restarting");

		removeCurrentPanelGame();
		createNewPanelGame();

	}

	private void removeCurrentPanelGame() {

		this.panelGame.setVisible(false);
		this.getChildren().remove(this.panelGame);

	}

	private void createNewPanelGame() {

		this.panelGame = new PanelGame(this);
		this.getChildren().add(this.panelGame);

	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		restartGame();
	}

}
