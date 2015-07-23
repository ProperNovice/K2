package controller;

import javafx.scene.paint.Color;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.Circle;
import utils.Coordinate;
import utils.CoordinatesRelocate;
import utils.CoordinatesRelocateBuilder;
import weather.WeatherTile;
import weather.WeatherTilesSummer;
import weather.WeatherTilesWinter;
import enums.AltitudeZone;
import enums.Coordinates;
import enums.DifficultyWeather;
import enums.Dimensions;
import enums.Ratio;

public class WeatherTileController {

	private ArrayList<WeatherTile> weatherTiles = new ArrayList<>();
	private int weatherIndexActive = 0;
	private double weatherIndicatorGap = 125 * Ratio.WEATHER_TILE.ratio();
	private Circle weatherIndicator = null;
	private boolean weatherTilesAreShowing = false;
	private WeatherTile weatherTileDiscarded = null;

	public WeatherTileController(DifficultyWeather difficultyWeather) {

		switch (difficultyWeather) {

		case SUMMER:
			this.weatherTiles.addAll(WeatherTilesSummer.getTiles());
			break;

		case WINTER:
			this.weatherTiles.addAll(WeatherTilesWinter.getTiles());
			break;

		}

		this.weatherTiles.shuffle();
		relocateWeatherTiles();
		createWeatherIndicator();
		relocateWeatherIndicator();

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
			this.weatherTileDiscarded = this.weatherTiles.removeFirst();
			this.weatherTiles.getFirst().animateSynchronous(
					Coordinates.WEATHER_TILES.x(),
					Coordinates.WEATHER_TILES.y());

		}

		animateWeatherIndicatorSynchronous();

	}

	public void setWeatherTileDiscardedVisibleFalse() {
		this.weatherTileDiscarded.setVisibleFalse();
	}

	public void handleWeatherTilePressed() {

		if (!this.weatherTilesAreShowing) {

			this.weatherTilesAreShowing = true;
			showWeatherTiles();

		} else if (this.weatherTilesAreShowing) {

			this.weatherTilesAreShowing = false;

			hideWeatherTiles();

		}

	}

	public void hideWeatherTiles() {
		relocateWeatherTiles();
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
