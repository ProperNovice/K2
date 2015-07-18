package mountaineers;

import instances.Instances;
import utils.ArrayList;
import utils.EventHandler;
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

			System.out.println("1");

			this.movement.setText("");
			System.out.println("1a");
			this.movement.setText("move: " + movement);
			System.out.println("1b");
			setTextVisibleStatus(this.movement, true);
			System.out.println("1c");

		} else {

			System.out.println("2");

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

		if (movement > 0) {

			System.out.println("3");

			this.movementRopeUp.setText("");
			System.out.println("3a");
			this.movementRopeUp.setText("up: " + movement);
			System.out.println("3b");
			setTextVisibleStatus(this.movementRopeUp, true);
			System.out.println("3c");

		} else {

			System.out.println("4");

			this.movementRopeUp.setVisible(false);

			for (TextVisibility textVisibility : this.textVisibility)
				if (textVisibility.getText().equals(this.movementRopeUp)) {

					textVisibility.setMinusButtonVisible(false);
					textVisibility.setVisibleStatus(false);

				}

		}

		relocateTexts();

	}

	public void setMovementRopeDown(int movement) {

		if (movement > 0) {

			System.out.println("5");

			this.movementRopeDown.setText("");
			System.out.println("5a");
			this.movementRopeDown.setText("down: " + movement);
			System.out.println("5b");
			setTextVisibleStatus(this.movementRopeDown, true);
			System.out.println("5c");

		} else {

			System.out.println("6");

			this.movementRopeDown.setVisible(false);

			for (TextVisibility textVisibility : this.textVisibility)
				if (textVisibility.getText().equals(this.movementRopeDown)) {

					textVisibility.setMinusButtonVisible(false);
					textVisibility.setVisibleStatus(false);

				}

		}

		relocateTexts();

	}

	private void setTextVisibleStatus(Text text, boolean value) {

		for (TextVisibility textVisibility : this.textVisibility)
			if (textVisibility.getText().equals(text))
				textVisibility.setVisibleStatus(value);

	}

	private void relocateTexts() {

		double y = this.yFirst;

		System.out.println("s" + this.textVisibility.size());

		for (TextVisibility textVisibility : this.textVisibility) {

			System.out.println("q");

			if (!textVisibility.isVisible())
				continue;

			System.out.println("w");

			textVisibility.relocate(this.x, y);

			System.out.println("e");

			if (y == this.yFirst)
				y = this.ySecond;
			else if (y == this.ySecond)
				y = this.yThird;

			System.out.println("r");

		}

		System.out.println("t");
		boolean ateastOneIsVisible = false;

		for (TextVisibility textVisibility : this.textVisibility) {
			System.out.println("y");
			if (textVisibility.isVisible()) {
				ateastOneIsVisible = true;
				textVisibility.setVisible(true);
			}
		}

		System.out.println("u");

		this.mountaineerText.setVisible(ateastOneIsVisible);

		System.out.println("i");

	}

	public void setVisibleFalse() {

		this.mountaineerText.setVisible(false);

		for (TextVisibility textVisibility : this.textVisibility)
			textVisibility.setVisible(false);

	}

	public void setAllMinusButtonsVisible(boolean value) {

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

			this.minus.setEventHandler(new EventHandler(this));

		}

		@Override
		public void handleMouseButtonPressedPrimary() {

			Executor.runLater(() -> Instances.getControllerInstance()
					.gameStateController()
					.handleMinusButtonPressed(this.runnable));

		}

		public void relocate(double x, double y) {

			System.out.println("/");

			this.text.relocate(x, y);
			System.out.println(".");
			this.minus.relocate(x + this.text.getWidth(), y
					+ (double) Credentials.TEXT_HEIGHT.credential() / 3);
			System.out.println(",");

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
