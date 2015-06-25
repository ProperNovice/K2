package maps;

import java.util.ArrayList;

import model.Space;
import utils.ImageView;
import enums.Dimensions;

public class Map {

	private ImageView imageView = null;
	protected String path = null;
	protected ArrayList<Space> spaces = new ArrayList<>();

	public Map() {

	}

	protected void createMap() {
		createImageView();
		createSpaces();
	}

	private void createImageView() {

		this.imageView = new ImageView("board/" + this.path + ".jpg");

		this.imageView.setHeight(Dimensions.MAP.y());
		this.imageView.relocate(Dimensions.GAP_BETWEEN_BORDERS.x(),
				Dimensions.GAP_BETWEEN_BORDERS.y());

	}

	protected void createSpaces() {

	}

}
