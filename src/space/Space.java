package space;

import java.util.ArrayList;

import mountaineers.Mountaineer;
import shelter.Shelter;
import utils.Circle;
import utils.Logger;
import enums.AltitudeZone;
import enums.Coordinates;
import enums.Dimensions;
import enums.Ratio;
import enums.SpaceMountaineerLocationEnum;
import enums.SpaceSize;

public class Space {

	private int movementCost, acclimatizationIndicator, maximumMountaineers,
			victoryPoints;
	private AltitudeZone altitudeZone = null;
	private Circle circle = null;
	private double topLeftX, topLeftY;
	private SpaceSize spaceSize = null;
	private ArrayList<Space> adjacentUp = new ArrayList<>();
	private ArrayList<Space> adjacentDown = new ArrayList<>();
	private boolean containsTent = false;

	public Space(int movementCost, int acclimatizationIndicator,
			int maximumMountaineers, int victoryPoints,
			AltitudeZone altitudeZone, double topLeftX, double topLeftY,
			SpaceSize spaceSize) {

		this.movementCost = movementCost;
		this.acclimatizationIndicator = acclimatizationIndicator;
		this.maximumMountaineers = maximumMountaineers;
		this.victoryPoints = victoryPoints;
		this.altitudeZone = altitudeZone;
		this.spaceSize = spaceSize;

		this.topLeftX = Coordinates.MAP.x() + topLeftX * Ratio.MAP.ratio();
		this.topLeftY = Coordinates.MAP.y() + topLeftY * Ratio.MAP.ratio();

		createCircle();

	}

	private void createCircle() {

		double radius = this.spaceSize.width() * Ratio.MAP.ratio() / 2;

		this.circle = new Circle(radius);
		this.circle.relocate(this.topLeftX, this.topLeftY);

		this.circle.setVisible(false);

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

	public boolean isAdjacentUp(Space space) {
		return this.adjacentUp.contains(space);
	}

	public boolean isAdjacentDown(Space space) {
		return this.adjacentDown.contains(space);
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

	public void print() {

		Logger.log("movement " + this.movementCost);
		Logger.log("acclimatization " + this.acclimatizationIndicator);
		Logger.log("altitude " + this.altitudeZone);
		Logger.log("points " + this.victoryPoints);
		Logger.log("maximum mountaineers " + this.maximumMountaineers);
		Logger.newLine();

	}

	public void relocateMountaineer(Mountaineer mountaineer,
			SpaceMountaineerLocationEnum spaceMountaineerLocationEnum) {

		double mountaineerWidth = Dimensions.MOUNTAINEER_GAME.x();
		double mountaineerHeight = Dimensions.MOUNTAINEER_GAME.y();

		double radius = this.circle.getRadius();

		double x = 0, y = 0;

		if (spaceMountaineerLocationEnum
				.equals(SpaceMountaineerLocationEnum.TOP_LEFT)) {

			x = this.topLeftX + radius - mountaineerWidth;
			y = this.topLeftY + radius - mountaineerHeight;

		} else if (spaceMountaineerLocationEnum
				.equals(SpaceMountaineerLocationEnum.BOTTOM_RIGHT)) {

			x = this.topLeftX + radius;
			y = this.topLeftY + radius;

		}

		mountaineer.relocateMountaineer(x, y);

	}

	public void animateMountaineerSynchronous(Mountaineer mountaineer,
			SpaceMountaineerLocationEnum spaceMountaineerLocationEnum) {

		double mountaineerWidth = Dimensions.MOUNTAINEER_GAME.x();
		double mountaineerHeight = Dimensions.MOUNTAINEER_GAME.y();

		double radius = this.circle.getRadius();

		double x = 0, y = 0;

		if (spaceMountaineerLocationEnum
				.equals(SpaceMountaineerLocationEnum.TOP_LEFT)) {

			x = this.topLeftX + radius - mountaineerWidth;
			y = this.topLeftY + radius - mountaineerHeight;

		} else if (spaceMountaineerLocationEnum
				.equals(SpaceMountaineerLocationEnum.BOTTOM_RIGHT)) {

			x = this.topLeftX + radius;
			y = this.topLeftY + radius;

		}

		mountaineer.animateMountaineerSynchronous(x, y);

	}

	public void addShelterAnimateSynchronous(Shelter shelter) {

		this.containsTent = true;

		double tentHeight = Dimensions.TENT_GAME.y();

		double radius = this.circle.getRadius();

		double x = 0, y = 0;

		x = this.topLeftX + radius + 2;
		y = this.topLeftY + radius - tentHeight;

		shelter.animateSynchronous(x, y);

	}

	public boolean containsTent() {
		return this.containsTent;
	}

	public void setContainsTentFalse() {
		this.containsTent = false;
	}

	public int getMaximumMountaineers() {
		return this.maximumMountaineers;
	}

}
