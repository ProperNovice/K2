package weather;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Logger;
import utils.ShutDown;
import enums.AltitudeZone;

public class Weather {

	private ArrayList<AltitudeZoneModifiers> altitudeZoneModifiers = new ArrayList<>();

	public Weather() {

		createAltitudeZoneModifiers();

	}

	private void createAltitudeZoneModifiers() {

		for (AltitudeZone altitudeZone : AltitudeZone.values())
			this.altitudeZoneModifiers.add(new AltitudeZoneModifiers(
					altitudeZone));

	}

	public void setAltitudeZoneMovement(int movement,
			AltitudeZone... altitudeZones) {

		for (AltitudeZoneModifiers altitudeZoneModifiers : this.altitudeZoneModifiers)
			if (Arrays.asList(altitudeZones).contains(
					altitudeZoneModifiers.getAltitudeZone()))
				altitudeZoneModifiers.setMovement(movement);

	}

	public void setAltitudeZoneAcclimatization(int acclimatization,
			AltitudeZone... altitudeZones) {

		for (AltitudeZoneModifiers altitudeZoneModifiers : this.altitudeZoneModifiers)
			if (Arrays.asList(altitudeZones).contains(
					altitudeZoneModifiers.getAltitudeZone()))
				altitudeZoneModifiers.setAcclimatization(acclimatization);

	}

	public int getMovement(AltitudeZone altitudeZone) {

		for (AltitudeZoneModifiers altitudeZoneModifiers : this.altitudeZoneModifiers)
			if (altitudeZoneModifiers.getAltitudeZone().equals(altitudeZone))
				return altitudeZoneModifiers.getMovement();

		Logger.logNewLine(("shouldn't be here, public int getMovement() @ class Weather"));
		ShutDown.execute();

		return -1;

	}

	public int getAcclimatization(AltitudeZone altitudeZone) {

		for (AltitudeZoneModifiers altitudeZoneModifiers : this.altitudeZoneModifiers)
			if (altitudeZoneModifiers.getAltitudeZone().equals(altitudeZone))
				return altitudeZoneModifiers.getAcclimatization();

		Logger.logNewLine(("shouldn't be here, public int getAcclimatization() @ class Weather"));
		ShutDown.execute();

		return -1;

	}

	public void print() {

		boolean isClear = true;

		for (AltitudeZoneModifiers altitudeZoneModifiers : this.altitudeZoneModifiers) {

			int movement = altitudeZoneModifiers.getMovement();
			int acclimatization = altitudeZoneModifiers.getAcclimatization();

			if (movement == 0 && acclimatization == 0)
				continue;

			Logger.logNewLine(altitudeZoneModifiers.getAltitudeZone());

			if (movement != 0) {
				isClear = false;
				Logger.log("movement " + altitudeZoneModifiers.getMovement());
			}

			if (acclimatization != 0) {
				isClear = false;
				Logger.log("acclimatization "
						+ altitudeZoneModifiers.getAcclimatization());
			}

			Logger.newLine();

		}

		if (isClear)
			Logger.logNewLine("clear");

	}

	private class AltitudeZoneModifiers {

		private AltitudeZone altitudeZone = null;
		private int movement = 0;
		private int acclimatization = 0;

		public AltitudeZoneModifiers(AltitudeZone altitudeZone) {
			this.altitudeZone = altitudeZone;
		}

		public AltitudeZone getAltitudeZone() {
			return this.altitudeZone;
		}

		public void setMovement(int movement) {
			this.movement = movement;
		}

		public void setAcclimatization(int acclimatization) {
			this.acclimatization = acclimatization;
		}

		public int getMovement() {
			return this.movement;
		}

		public int getAcclimatization() {
			return this.acclimatization;
		}

	}

}
