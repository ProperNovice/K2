package mountaineers;

import utils.Executor;
import utils.Text;
import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;
import enums.MountaineerEnum;

public class PanelMovement {

	private Text mountaineer = null;
	private Text movementRopeUp = null;
	private Text movement = null;
	private Text movementRopeDown = null;
	private double x, yFirst, ySecond, yThird;

	public PanelMovement(MountaineerEnum mountaineerEnum) {

		createTexts(mountaineerEnum);
		setVisibleFalse();

	}

	private void createTexts(MountaineerEnum mountaineerEnum) {

		String mountaineerNumber = mountaineerEnum.fileName();

		if (mountaineerNumber.length() == 1)
			mountaineerNumber = " " + mountaineerNumber;

		this.mountaineer = new Text(mountaineerNumber + "  ");
		this.mountaineer.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movement = new Text("move: 0");
		this.movement.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movementRopeUp = new Text("up: 0");
		this.movementRopeUp.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movementRopeDown = new Text("down: 0");
		this.movementRopeDown.setHeight(Credentials.TEXT_HEIGHT.credential());

		Coordinates coordinates = mountaineerEnum
				.coordinatesPanelMovementMountaineer();

		this.mountaineer.relocate(coordinates.x(), coordinates.y());

		this.x = this.mountaineer.getLayoutX() + this.mountaineer.getWidth()
				+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

		this.yFirst = coordinates.y();
		this.ySecond = coordinates.y() + Credentials.TEXT_HEIGHT.credential()
				- 12;
		this.yThird = coordinates.y() + 2
				* Credentials.TEXT_HEIGHT.credential() - 22;

		this.movement.relocate(this.x, this.yFirst);
		this.movementRopeUp.relocate(this.x, this.ySecond);
		this.movementRopeDown.relocate(this.x, this.yThird);

	}

	public void setMovement(int movement) {
		this.movement.setText("move: " + movement);
		this.movement.setVisible(true);
		relocateTexts();
	}

	public void setMovementRopeUp(int movement) {
		this.movementRopeUp.setText("up: " + movement);
		this.movementRopeUp.setVisible(true);
		relocateTexts();
	}

	public void setMovementRopeDown(int movement) {
		this.movementRopeDown.setText("down: " + movement);
		this.movementRopeDown.setVisible(true);
		relocateTexts();
	}

	private void relocateTexts() {

		Executor.sleep(2);

		System.out.println("st");

		this.mountaineer.setVisible(true);

		double y = this.yFirst;

		System.out.println(this.movement.isVisible());

		if (this.movement.isVisible()) {

			System.out.println("1");

			this.movement.relocate(this.x, y);
			y = this.ySecond;

		}

		if (this.movementRopeUp.isVisible()) {

			System.out.println("2");

			this.movementRopeUp.relocate(this.x, y);

			if (y == this.yFirst)
				y = this.ySecond;
			else if (y == this.ySecond)
				y = this.yThird;

		}

		if (this.movementRopeDown.isVisible()) {
			System.out.println("3");
			this.movementRopeUp.relocate(this.x, y);
		}

	}

	public void setVisibleFalse() {

		this.mountaineer.setVisible(false);
		this.movement.setVisible(false);
		this.movementRopeUp.setVisible(false);
		this.movementRopeDown.setVisible(false);

	}

	public void reset() {

		this.movement.setText("move: 0");
		this.movementRopeUp.setText("up: 0");
		this.movementRopeDown.setText("down: 0");

	}

}
