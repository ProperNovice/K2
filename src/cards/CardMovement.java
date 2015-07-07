package cards;

import instances.Instances;
import utils.Executor;
import utils.Logger;

public class CardMovement extends Card {

	private int movement;

	public CardMovement(int movement) {

		this.movement = movement;
		super.path = "movement" + this.movement;
		super.createImage();

	}

	public int getMovement() {
		return this.movement;
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("movement " + this.movement);

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().handleCardPressed(this));

	}

}
