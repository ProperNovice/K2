package cards;

import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Card implements EventHandlerAble {

	protected String path = null;
	protected ImageView imageView = null;

	public Card() {

	}

	protected void createImage() {

		this.imageView = new ImageView("cards/" + this.path + ".png");
		this.imageView.setEventHandler(new EventHandler(this));

	}

}
