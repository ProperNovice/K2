package weather;

import utils.ImageView;

public class WeatherTile {

	private ImageView imageView = null;

	public WeatherTile(String path) {

		createImage(path);

	}

	private void createImage(String path) {

		this.imageView = new ImageView("weatherTiles/" + path + ".png");

	}

}
