package model;

import mountaineers.Mountaineer;
import enums.Coordinates;
import enums.Dimensions;
import utils.ImageView;

public class AcclimatizationIndicator {

	private ImageView imageView = null;

	public AcclimatizationIndicator(Mountaineer mountaineerI,
			Mountaineer mountaineerII) {
		createImage();
	}

	private void createImage() {

		this.imageView = new ImageView("acclimatizationIndicator.png");
		this.imageView.setHeight(Dimensions.ACCLIMATIZATION_INDICATOR_GAME.y());
		this.imageView.relocate(Coordinates.ACCLIMATIZATION_INDICATOR.x(),
				Coordinates.ACCLIMATIZATION_INDICATOR.y());

	}

}
