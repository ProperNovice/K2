package controller;

import javafx.scene.paint.Color;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.Circle;
import utils.Coordinate;
import utils.CoordinatesRelocate;
import utils.CoordinatesRelocateBuilder;
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
	private boolean weatherTilesAreShowing = false;

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

	private void animateWeatherIndicatorSynchronous() {

		double x = Coordinates.WEATHER_TILES.x()
				+ Coordinates.WEATHER_INDICATOR_GAME.x();
		double y = Coordinates.WEATHER_TILES.y()
				+ Coordinates.WEATHER_INDICATOR_GAME.y();

		x += this.weatherIndexActive * this.weatherIndicatorGap;

		Animation.animate(this.weatherIndicator, x, y,
				AnimationSynch.SYNCHRONOUS);

	}

	public int getMovementToEnterSpaceWithAltitude(AltitudeZone altitudeZone) {
		return this.weatherTiles.getFirst().getWeather(this.weatherIndexActive)
				.getMovement(altitudeZone);
	}

	public int getAcclimatizationWithAltitude(AltitudeZone altitudeZone) {
		return this.weatherTiles.getFirst().getWeather(this.weatherIndexActive)
				.getAcclimatization(altitudeZone);
	}

	public void proceedToNextTurnAnimateSynchronous() {

		this.weatherIndexActive++;

		if (this.weatherIndexActive == 3) {

			this.weatherIndexActive = 0;
			this.weatherTiles.getFirst().setVisibleFalse();
			this.weatherTiles.removeFirst();
			this.weatherTiles.getFirst().animateSynchronous(
					Coordinates.WEATHER_TILES.x(),
					Coordinates.WEATHER_TILES.y());

		}

		animateWeatherIndicatorSynchronous();

	}

	public void handleWeatherTilePressed() {

		if (!this.weatherTilesAreShowing) {

			this.weatherTilesAreShowing = true;
			showWeatherTiles();

		} else if (this.weatherTilesAreShowing) {

			this.weatherTilesAreShowing = false;
			relocateWeatherTiles();

		}

	}

	private void showWeatherTiles() {

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(Coordinates.WEATHER_TILES.x())
				.topLeftY(Coordinates.WEATHER_TILES.y())
				.width(Dimensions.WEATHER_TILE_GAME.x())
				.height(Dimensions.WEATHER_TILE_GAME.y()).nodesPerRow(2)
				.gapBetweenNodes(0).create();

		for (WeatherTile weatherTile : this.weatherTiles) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			weatherTile.relocate(coordinate.getX(), coordinate.getY());
			weatherTile.toFront();

		}

		this.weatherIndicator.toFront();

	}

}
