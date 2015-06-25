package model;

import java.util.ArrayList;

import utils.Circle;
import enums.AltitudeZone;
import enums.Coordinates;
import enums.Dimensions;
import enums.SpaceSize;

public class Space {

	private int movementCost, acclimatizationIndicator, victoryPoints;
	private AltitudeZone altitudeZone = null;
	private Circle circle = null;
	private ArrayList<Space> adjacentUp = new ArrayList<>();
	private ArrayList<Space> adjacentDown = new ArrayList<>();

	public Space(int movementCost, int acclimatizationIndicator,
			int victoryPoints, AltitudeZone altitudeZone, double topLeftX,
			double topLeftY, SpaceSize spaceSize) {

		this.movementCost = movementCost;
		this.acclimatizationIndicator = acclimatizationIndicator;
		this.victoryPoints = victoryPoints;
		this.altitudeZone = altitudeZone;

		createCircle(topLeftX, topLeftY, spaceSize);

	}

	private void createCircle(double topLeftX, double topLeftY,
			SpaceSize spaceSize) {

		double mapRatio = Dimensions.MAP_RATIO.x();

		double radius = spaceSize.width() * mapRatio / 2;

		this.circle = new Circle(radius);
		this.circle.relocate(Coordinates.MAP.x() + topLeftX * mapRatio,
				Coordinates.MAP.y() + topLeftY * mapRatio);
		
	}

	public boolean isPressed(double x, double y) {
		return this.circle.contains(Coordinates.MAP.x() + x,
				Coordinates.MAP.y() + y);
	}

	public void addAdjacentUp(Space space) {
		this.adjacentUp.add(space);
	}

	public void addAdjacentDown(Space space) {
		this.adjacentDown.add(space);
	}

	public int getMovementCost() {
		return this.movementCost;
	}

	public int getAcclimatizationIndicator() {
		return this.acclimatizationIndicator;
	}

	public int getVictoryPoints() {
		return this.victoryPoints;
	}

	public AltitudeZone getAltitudeZone() {
		return this.altitudeZone;
	}

}
