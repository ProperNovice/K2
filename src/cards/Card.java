package cards;

import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import enums.Dimensions;

public class Card implements EventHandlerAble {

	protected String path = null;
	protected ImageView imageView = null;

	public Card() {

	}

	protected void createImage() {

		this.imageView = new ImageView("cards/" + this.path + ".png");
		this.imageView.setWidth(Dimensions.CARD_GAME.x());
		this.imageView.setEventHandler(new EventHandler(this));

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

}
