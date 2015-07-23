package weather;

import utils.ArrayList;
import enums.AltitudeZone;

public class WeatherTilesWinter {

	public static ArrayList<WeatherTile> getTiles() {

		ArrayList<WeatherTile> weatherTiles = new ArrayList<>();

		Weather first, second, third;

		// 1

		first = new Weather();
		first.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);
		first.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		first.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		second = new Weather();
		second.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneMovement(1, AltitudeZone.OVER_8000);

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		weatherTiles.add(new WeatherTile("winter/1", first, second, third));

		// 2

		first = new Weather();
		first.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-2, AltitudeZone.OVER_8000);

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);
		third.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		third.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);
		third.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_6000_AND_7000);
		third.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_7000_AND_8000);
		third.setAltitudeZoneMovement(1, AltitudeZone.OVER_8000);

		weatherTiles.add(new WeatherTile("winter/2", first, second, third));

		// 3

		first = new Weather();

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-1, AltitudeZone.UNDER_6000);
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		third = new Weather();

		weatherTiles.add(new WeatherTile("winter/3", first, second, third));

		// 4

		first = new Weather();
		first.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_7000_AND_8000);

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-1, AltitudeZone.UNDER_6000);
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_6000_AND_7000);
		second.setAltitudeZoneAcclimatization(-1,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-1, AltitudeZone.OVER_8000);

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);

		weatherTiles.add(new WeatherTile("winter/4", first, second, third));

		// 5

		first = new Weather();

		second = new Weather();
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_6000_AND_7000);
		second.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_7000_AND_8000);
		second.setAltitudeZoneAcclimatization(-2, AltitudeZone.OVER_8000);

		third = new Weather();
		third.setAltitudeZoneMovement(1, AltitudeZone.UNDER_6000);
		third.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_6000_AND_7000);
		third.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_7000_AND_8000);
		third.setAltitudeZoneMovement(1, AltitudeZone.OVER_8000);

		weatherTiles.add(new WeatherTile("winter/5", first, second, third));

		// 6

		first = new Weather();
		first.setAltitudeZoneMovement(1, AltitudeZone.BETWEEN_6000_AND_7000);

		second = new Weather();

		third = new Weather();
		third.setAltitudeZoneAcclimatization(-2,
				AltitudeZone.BETWEEN_6000_AND_7000);

		weatherTiles.add(new WeatherTile("winter/6", first, second, third));

		// return

		return weatherTiles;

	}

}
