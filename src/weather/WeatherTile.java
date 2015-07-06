package weather;

import utils.ArrayList;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;
import enums.Dimensions;

public class WeatherTile implements EventHandlerAble {

	private ImageView imageView = null;
	private ArrayList<Weather> arrayList = new ArrayList<>();

	public WeatherTile(String path, Weather first, Weather second, Weather third) {

		createImage(path);

		this.arrayList.add(first);
		this.arrayList.add(second);
		this.arrayList.add(third);

	}

	private void createImage(String path) {

		this.imageView = new ImageView("weatherTiles/" + path + ".png");
		this.imageView.setWidth(Dimensions.WEATHER_TILE_GAME.x());
		this.imageView.setEventHandler(new EventHandler(this));

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void toBack() {
		this.imageView.toBack();
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		int weatherIndex = 0;

		Logger.logNewLine("/*");

		for (Weather weather : this.arrayList) {

			weatherIndex++;

			Logger.logNewLine("weather " + weatherIndex);

			weather.print();

			if (weatherIndex < 3)
				Logger.logNewLine("-");

		}

		Logger.logNewLine("*/");

	}

}
