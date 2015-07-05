package cards;

public class Rope extends Card {

	private int movementUp, movementDown;

	public Rope(int movementUp, int movementDown) {

		this.movementUp = movementUp;
		this.movementDown = movementDown;

		super.path = "rope" + Integer.toString(this.movementUp)
				+ Integer.toString(this.movementDown);
		super.createImage();

	}

}
