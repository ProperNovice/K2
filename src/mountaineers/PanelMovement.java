package mountaineers;

import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.ImageView;
import utils.Text;
import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;
import enums.MountaineerEnum;

public class PanelMovement {

	private Mountaineer mountaineer = null;
	private Text mountaineerText = null;
	private Text movementRopeUp = null;
	private Text movement = null;
	private Text movementRopeDown = null;
	private double x, yFirst, ySecond, yThird;
	private ArrayList<TextVisibility> textVisibility = new ArrayList<>();

	public PanelMovement(Mountaineer mountaineer) {

		this.mountaineer = mountaineer;

		createTexts(mountaineer.getMountaineerEnum());
		createTextVisibility();
		setVisibleFalse();

	}

	private void createTexts(MountaineerEnum mountaineerEnum) {

		String mountaineerNumber = mountaineerEnum.fileName();

		if (mountaineerNumber.length() == 1)
			mountaineerNumber = " " + mountaineerNumber;

		this.mountaineerText = new Text(mountaineerNumber + "  ");
		this.mountaineerText.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movement = new Text("move: 0");
		this.movement.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movementRopeUp = new Text("up: 0");
		this.movementRopeUp.setHeight(Credentials.TEXT_HEIGHT.credential());

		this.movementRopeDown = new Text("down: 0");
		this.movementRopeDown.setHeight(Credentials.TEXT_HEIGHT.credential());

		Coordinates coordinates = mountaineerEnum
				.coordinatesPanelMovementMountaineer();

		this.mountaineerText.relocate(coordinates.x(), coordinates.y());

		this.x = this.mountaineerText.getLayoutX()
				+ this.mountaineerText.getWidth()
				+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

		this.yFirst = coordinates.y();
		this.ySecond = coordinates.y() + Credentials.TEXT_HEIGHT.credential()
				- 12;
		this.yThird = coordinates.y() + 2
				* Credentials.TEXT_HEIGHT.credential() - 22;

	}

	private void createTextVisibility() {

		this.textVisibility.add(new TextVisibility(this.movement,
				() -> this.mountaineer.addMovementPanelMovementUpdate(-1)));

		this.textVisibility
				.add(new TextVisibility(this.movementRopeUp,
						() -> this.mountaineer
								.addMovementRopeUpPanelMovementUpdate(-1)));

		this.textVisibility.add(new TextVisibility(this.movementRopeDown,
				() -> this.mountaineer
						.addMovementRopeDownPanelMovementUpdate(-1)));

	}

	public void setMovement(int movement) {

		if (movement > 0) {

			this.movement.setText("move: " + movement);
			setTextVisibleStatus(this.movement, true);

		} else {

			this.movement.setVisible(false);

			for (TextVisibility textVisibility : this.textVisibility)
				if (textVisibility.getText().equals(this.movement)) {

					textVisibility.setMinusButtonVisible(false);
					textVisibility.setVisibleStatus(false);

				}

		}

		relocateTexts();

	}

	public void setMovementRopeUp(int movement) {

		this.movementRopeUp.setText("up: " + movement);
		setTextVisibleStatus(this.movementRopeUp, true);
		relocateTexts();

	}

	public void setMovementRopeDown(int movement) {

		this.movementRopeDown.setText("down: " + movement);
		setTextVisibleStatus(this.movementRopeDown, true);
		relocateTexts();

	}

	private void setTextVisibleStatus(Text text, boolean value) {

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.getText().equals(text))
				textVisibility.setVisibleStatus(value);

	}

	private void relocateTexts() {

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

		boolean ateastOneIsVisible = false;

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.isVisible()) {
				ateastOneIsVisible = true;
				textVisibility.setVisible(true);
			}

		this.mountaineerText.setVisible(ateastOneIsVisible);

	}

	public void setVisibleFalse() {

		this.mountaineerText.setVisible(false);

		for (TextVisibility textVisibility : this.textVisibility)
			textVisibility.setVisible(false);

	}

	public void setMinusButtonVisible(boolean value) {

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.isVisible())
				textVisibility.setMinusButtonVisible(value);

	}

	public void resetPanel() {

		for (TextVisibility textVisibility : this.textVisibility) {

			textVisibility.setVisibleStatus(false);
			textVisibility.setVisible(false);

		}

	}

	private class TextVisibility implements EventHandlerAble {

		private Text text = null;
		private boolean isVisible = false;
		private ImageView minus = null;
		private Runnable runnable = null;

		public TextVisibility(Text text, Runnable runnable) {

			this.text = text;
			this.runnable = runnable;
			this.minus = new ImageView("-.png");
			this.minus.setHeight(Credentials.TEXT_HEIGHT.credential() / 2);
			this.minus.setVisible(false);

			this.minus.setEventHandler(new utils.EventHandler(this));

		}

		@Override
		public void handleMouseButtonPressedPrimary() {
			Executor.runLater(this.runnable);
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
