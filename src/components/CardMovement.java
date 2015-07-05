package components;

import utils.Logger;

public class CardMovement extends Card {

	private int movement;

	public CardMovement(int movement) {

		this.movement = movement;
		super.path = "movement" + Integer.toString(this.movement);
		super.createImage();

	}

	public int getMovement() {
		return this.movement;
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("movement " + this.movement);

	}

}
