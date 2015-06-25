package maps;

import java.util.ArrayList;

import model.Space;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import enums.Coordinates;
import enums.Dimensions;

public class Map implements EventHandlerAble {

	private ImageView imageView = null;
	protected String path = null;
	protected ArrayList<Space> spaces = new ArrayList<>();
	private EventHandler eventHandler = new EventHandler(this);

	public Map() {

	}

	protected void createMap() {
		createImageView();
		createSpaces();
	}

	private void createImageView() {

		this.imageView = new ImageView("board/" + this.path + ".jpg");

		this.imageView.setHeight(Dimensions.MAP.y());
		this.imageView.relocate(Coordinates.MAP.x(), Coordinates.MAP.y());
		this.imageView.setOnMousePressed(this.eventHandler);

	}

	protected void createSpaces() {

	}

	@Override
	public void handleMouseButtonPrimary() {

		System.out.println("pressed");

		double x = this.eventHandler.getX();
		double y = this.eventHandler.getY();

		System.out.println((int) x + ", " + (int) y);

		for (Space space : this.spaces) {

			if (!space.isPressed(x, y))
				continue;

			System.out.println(space.getMovementCost() + " mo");
			System.out.println(space.getAcclimatizationIndicator() + " ac");
			System.out.println(space.getVictoryPoints() + " vi");

		}

		System.out.println();

	}

}
