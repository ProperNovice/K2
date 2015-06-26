package maps;

import instances.Instances;

import java.util.ArrayList;

import model.Space;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;
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
		createAdjacencies();
	}

	private void createImageView() {

		this.imageView = new ImageView("board/" + this.path + ".jpg");

		this.imageView.setHeight(Dimensions.MAP_GAME.y());
		this.imageView.relocate(Coordinates.MAP.x(), Coordinates.MAP.y());
		this.imageView.setOnMousePressed(this.eventHandler);

	}

	protected void createSpaces() {
		Logger.logNewLine("spaces need to be implemented");
	}

	protected void createAdjacencies() {
		Logger.logNewLine("adjacencies need to be implemented");
	}

	protected void addAdjacentUpUp(int indexOne, int indexTwo) {

		this.spaces.get(indexOne).addAdjacentUp(this.spaces.get(indexTwo));
		this.spaces.get(indexTwo).addAdjacentUp(this.spaces.get(indexOne));

	}

	protected void addAdjacentDownUp(int indexOne, int indexTwo) {

		this.spaces.get(indexOne).addAdjacentUp(this.spaces.get(indexTwo));
		this.spaces.get(indexTwo).addAdjacentDown(this.spaces.get(indexOne));

	}

	@Override
	public void handleMouseButtonPrimary() {

		double ratio = Dimensions.MAP_RATIO.x();

		double x = this.eventHandler.getX() * ratio;
		double y = this.eventHandler.getY() * ratio;

		for (Space space : this.spaces) {

			if (!space.isPressed(x, y))
				continue;

			Instances.getControllerInstance().gameStateController()
					.handleSpacePressed(space);

			break;

		}

	}

}
