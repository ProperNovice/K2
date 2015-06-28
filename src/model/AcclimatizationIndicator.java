package model;

import utils.ImageView;

public class AcclimatizationIndicator {

	private ImageView imageView = null;

	public AcclimatizationIndicator() {
		createImage();
	}

	private void createImage() {

		this.imageView = new ImageView("acclimatizationIndicator.png");

	}

}
