package cards;

import instances.Instances;
import utils.Executor;
import utils.Logger;

public class CardRope extends Card {

	private int movementUp, movementDown;

	public CardRope(int movementUp, int movementDown) {

		this.movementUp = movementUp;
		this.movementDown = movementDown;

		super.path = "rope" + this.movementUp + this.movementDown;
		super.createImage();

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("rope " + this.movementUp + "/" + this.movementDown);

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().handleCardPressed(this));

	}

	public int getMovementUp() {
		return this.movementUp;
	}

	public int getMovementDown() {
		return this.movementDown;
	}

}
