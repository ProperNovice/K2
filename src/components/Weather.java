package components;

import enums.AltitudeZone;
import utils.ImageView;

public class Weather {

	private ImageView imageView = null;

	public Weather(String path) {

		createImage(path);

	}

	private void createImage(String path) {

		this.imageView = new ImageView("weatherTiles/" + path + ".png");

	}

	private class AltitudeZoneModifiers {

		private AltitudeZone altitudeZone = null;

		public AltitudeZoneModifiers(AltitudeZone altitudeZone) {
			this.altitudeZone = altitudeZone;
		}

	}

}
