package model;

import enums.SpaceSize;

public class Space {

	private int movementCost, acclimatizationIndicator;
	private double centerX, centerY;
	private SpaceSize spaceSize = null;

	public Space(int movementCost, int acclimatizationIndicator,
			double centerX, double centerY, SpaceSize spaceSize) {

		this.movementCost = movementCost;
		this.acclimatizationIndicator = acclimatizationIndicator;
		this.centerX = centerX;
		this.centerY = centerY;
		this.spaceSize = spaceSize;

	}

}
