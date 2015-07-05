package cards;

public class CardRope extends Card {

	private int movementUp, movementDown;

	public CardRope(int movementUp, int movementDown) {

		this.movementUp = movementUp;
		this.movementDown = movementDown;

		super.path = "rope" + Integer.toString(this.movementUp)
				+ Integer.toString(this.movementDown);
		super.createImage();

	}

	public int getMovementUp() {
		return this.movementUp;
	}

	public int getMovementDown() {
		return this.movementDown;
	}

}
