package space;

import enums.AltitudeZone;
import enums.SpaceSize;

public class SpaceBuilder {

	private int movementCost, acclimatizationIndicator, victoryPoints,
			maximumMountaineers;
	private AltitudeZone altitudeZone = null;
	private double topLeftX, topLeftY;
	private SpaceSize spaceSize = null;

	public SpaceBuilder() {

	}

	public SpaceBuilder movementCost(int movementCost) {
		this.movementCost = movementCost;
		return this;
	}

	public SpaceBuilder acclimatizationIndicator(int acclimatizationIndicator) {
		this.acclimatizationIndicator = acclimatizationIndicator;
		return this;
	}

	public SpaceBuilder victoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
		return this;
	}

	public SpaceBuilder altitudeZone(AltitudeZone altitudeZone) {
		this.altitudeZone = altitudeZone;
		return this;
	}

	public SpaceBuilder topLeftCoordinates(double topLeftX, double topLeftY) {
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		return this;
	}

	public SpaceBuilder spaceSize(SpaceSize spaceSize) {
		this.spaceSize = spaceSize;
		return this;
	}

	public SpaceBuilder maximumMountaineers(int maximumMountaineers) {
		this.maximumMountaineers = maximumMountaineers;
		return this;
	}

	public Space create() {
		return new Space(this.movementCost, this.acclimatizationIndicator,
				this.maximumMountaineers, this.victoryPoints,
				this.altitudeZone, this.topLeftX, this.topLeftY, this.spaceSize);
	}

}
