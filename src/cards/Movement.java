package cards;

public class Movement extends Card {

	private int movement;

	public Movement(int movement) {

		this.movement = movement;
		super.path = "movement" + Integer.toString(this.movement);
		super.createImage();

	}

}
