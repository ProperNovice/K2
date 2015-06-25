package maps;

import instances.Instances;

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

		double x = this.eventHandler.getX();
		double y = this.eventHandler.getY();

		double ratio = Dimensions.MAP_RATIO.x();

		for (Space space : this.spaces) {

			if (!space.isPressed(x * ratio, y * ratio))
				continue;

			Instances.getControllerInstance().gameStateController()
					.handleSpacePressed(space);

		}

	}

}
