package model;

import java.util.ArrayList;

import enums.AltitudeZone;
import enums.SpaceSize;

public class Space {

	private int movementCost, acclimatizationIndicator, victoryPoints;
	private AltitudeZone altitudeZone = null;
	private double topLeftX, topLeftY;
	private SpaceSize spaceSize = null;
	private ArrayList<Space> adjacentUp = new ArrayList<>();
	private ArrayList<Space> adjacentDown = new ArrayList<>();

	public Space(int movementCost, int acclimatizationIndicator,
			int victoryPoints, AltitudeZone altitudeZone, double centerX,
			double centerY, SpaceSize spaceSize) {

		this.movementCost = movementCost;
		this.acclimatizationIndicator = acclimatizationIndicator;
		this.victoryPoints = victoryPoints;
		this.altitudeZone = altitudeZone;
		this.topLeftX = centerX;
		this.topLeftY = centerY;
		this.spaceSize = spaceSize;

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

}
