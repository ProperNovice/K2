package controller;

import instances.Instances;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Lock;
import utils.Logger;
import enums.Coordinates;
import enums.Dimensions;
import enums.GameStateEnum;

public class RestartButtonController implements EventHandlerAble {

	private ImageView imageView = null;
	private Controller controller = Instances.getControllerInstance();

	public RestartButtonController() {
		createImageView();
	}

	private void createImageView() {

		this.imageView = new ImageView("restart.png");
		this.imageView.setWidth(Dimensions.RESTART_BUTTON.x());
		this.imageView.relocate(Coordinates.RESTART_BUTTON.x(),
				Coordinates.RESTART_BUTTON.y());
		this.imageView.setVisible(false);
		this.imageView.setEventHandler(new EventHandler(this));

	}

	public void handleMouseButtonPressedPrimary() {
		this.controller.gameStateController().handleRestartButtonPressed();
	}

	public void handleRestartTurn() {

		Logger.logNewLine("restarting turn");

		this.controller.textController().concealText();
		this.controller.mountaineerController()
				.resetMountaineerMovementAndPanel();

		this.controller.saveGameController().loadTurn();

		Lock.lock();

		this.controller.saveGameController().resetTurn();

		this.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

}
