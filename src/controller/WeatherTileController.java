package controller;

import javafx.scene.paint.Color;
import utils.ArrayList;
import utils.Circle;
import weather.Weather;
import weather.WeatherTile;
import enums.AltitudeZone;
import enums.Coordinates;
import enums.Dimensions;
import enums.Ratio;

public class WeatherTileController {

	private ArrayList<WeatherTile> weatherTiles = new ArrayList<>();
	private int weatherIndexActive = 0;
	private double weatherIndicatorGap = 125 * Ratio.WEATHER_TILE.ratio();
	private Circle weatherIndicator = null;

	public WeatherTileController() {

		createWeatherTilesSummer();
		this.weatherTiles.shuffle();
		relocateWeatherTiles();
		createWeatherIndicator();
		relocateWeatherIndicator();

	}

	private void createWeatherTilesSummer() {

		Weather first, second, third;

		// 1

		first = new Weather();
		first.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);
		first.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		first.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		this.weatherTiles
				.add(new WeatherTile("summer/1", first, second, third));

		// 2

		first = new Weather();
		first.setAltitudeZoneAcclimatization(-2, AltitudeZone.OVER_8000);

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-2, AltitudeZone.OVER_8000);

		third = new Weather();

		this.weatherTiles
				.add(new WeatherTile("summer/2", first, second, third));

		// 3

		first = new Weather();

		second = new Weather();

		third = new Weather();

		this.weatherTiles
				.add(new WeatherTile("summer/3", first, second, third));

		// 4

		first = new Weather();

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);

		this.weatherTiles
				.add(new WeatherTile("summer/4", first, second, third));

		// 5

		first = new Weather();

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_6000_AND_7000);
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-2, AltitudeZone.OVER_8000);

		third = new Weather();

		this.weatherTiles
				.add(new WeatherTile("summer/5", first, second, third));

		// 6

		first = new Weather();
		first.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);

		second = new Weather();

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_6000_AND_7000);

		this.weatherTiles
				.add(new WeatherTile("summer/6", first, second, third));

	}

	private void relocateWeatherTiles() {

		double x = Coordinates.WEATHER_TILES.x();
		double y = Coordinates.WEATHER_TILES.y();
		int index = 0;

		for (WeatherTile weatherTile : this.weatherTiles) {

			weatherTile.relocate(x, y);
			weatherTile.toBack();

			if (index == 0)
				x += Dimensions.WEATHER_TILE_GAME.x();

			index++;

		}

	}

	private void createWeatherIndicator() {

		this.weatherIndicator = new Circle(
				Dimensions.WEATHER_INDICATOR_GAME.x() / 2);
		this.weatherIndicator.setFill(Color.BLACK);

	}

	private void relocateWeatherIndicator() {

		double x = Coordinates.WEATHER_TILES.x()
				+ Coordinates.WEATHER_INDICATOR_GAME.x();
		double y = Coordinates.WEATHER_TILES.y()
				+ Coordinates.WEATHER_INDICATOR_GAME.y();

		x += this.weatherIndexActive * this.weatherIndicatorGap;

		this.weatherIndicator.relocate(x, y);

	}

	public int getMovementToEnterSpaceWithAltitude(AltitudeZone altitudeZone) {
		return this.weatherTiles.getFirst().getWeather(this.weatherIndexActive)
				.getMovement(altitudeZone);
	}

	public int getAcclimatizationWithAltitude(AltitudeZone altitudeZone) {
		return this.weatherTiles.getFirst().getWeather(this.weatherIndexActive)
				.getAcclimatization(altitudeZone);
	}

}
