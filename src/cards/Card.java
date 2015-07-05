package cards;

import utils.ImageView;

public class Card {

	protected String path = null;
	private ImageView imageView = null;

	public Card() {

	}

	protected void createImage() {

		this.imageView = new ImageView("cards/" + this.path + ".png");

	}

}
