package mountaineers;

import utils.ArrayList;
import utils.ImageView;
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
	private ArrayList<TextVisibility> textVisibility = new ArrayList<>();

	public PanelMovement(MountaineerEnum mountaineerEnum) {

		createTexts(mountaineerEnum);
		createTextVisibility();
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

	}

	private void createTextVisibility() {

		this.textVisibility.add(new TextVisibility(this.mountaineer));
		this.textVisibility.add(new TextVisibility(this.movement));
		this.textVisibility.add(new TextVisibility(this.movementRopeUp));
		this.textVisibility.add(new TextVisibility(this.movementRopeDown));

	}

	public void setMovement(int movement) {
		this.movement.setText("move: " + movement);
		setTextVisibleStatusTrue(this.movement);
		relocateTexts();
	}

	public void setMovementRopeUp(int movement) {
		this.movementRopeUp.setText("up: " + movement);
		setTextVisibleStatusTrue(this.movementRopeUp);
		relocateTexts();
	}

	public void setMovementRopeDown(int movement) {
		this.movementRopeDown.setText("down: " + movement);
		setTextVisibleStatusTrue(this.movementRopeDown);
		relocateTexts();
	}

	private void setTextVisibleStatusTrue(Text text) {

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.getText().equals(text))
				textVisibility.setVisibleStatus(true);

	}

	private void relocateTexts() {

		this.mountaineer.setVisible(true);

		double y = this.yFirst;

		for (TextVisibility textVisibility : this.textVisibility) {

			if (!textVisibility.isVisible())
				continue;

			textVisibility.relocate(this.x, y);

			if (y == this.yFirst)
				y = this.ySecond;
			else if (y == this.ySecond)
				y = this.yThird;

		}

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.isVisible())
				textVisibility.setVisible(true);

	}

	public void setVisibleFalse() {

		for (TextVisibility textVisibility : this.textVisibility)
			textVisibility.setVisible(false);

	}

	public void setMinusButtonVisible(boolean value) {

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.isVisible())
				textVisibility.setMinusButtonVisible(value);

	}

	public void setVisibleStatusFalse() {

		for (TextVisibility textVisibility : this.textVisibility)
			textVisibility.setVisibleStatus(false);

	}

	private class TextVisibility {

		private Text text = null;
		private boolean isVisible = false;
		private ImageView minus = null;

		public TextVisibility(Text text) {

			this.text = text;
			this.minus = new ImageView("-.png");
			this.minus.setHeight(Credentials.TEXT_HEIGHT.credential() / 2);
			this.minus.setVisible(false);

		}

		public void relocate(double x, double y) {

			this.text.relocate(x, y);
			this.minus.relocate(x + this.text.getWidth(), y
					+ Credentials.TEXT_HEIGHT.credential() / 3);

		}

		public void setMinusButtonVisible(boolean value) {
			this.minus.setVisible(value);
		}

		public void setVisibleStatus(boolean value) {
			this.isVisible = value;
		}

		public void setVisible(boolean value) {
			this.text.setVisible(value);
		}

		public boolean isVisible() {
			return this.isVisible;
		}

		public Text getText() {
			return this.text;
		}

	}

}
