package controller;

import model.Space;
import mountaineers.AcclimatizationIndicator;
import mountaineers.Mountaineer;
import enums.Coordinates;
import enums.Dimensions;
import enums.MountaineerEnum;
import enums.SpaceMountaineerLocationEnum;

public class MountaineerController {

	private Mountaineer mountaineerI = null, mountaineerII = null;
	private AcclimatizationIndicator acclimatizationIndicator = null;

	public MountaineerController(Space spaceStarting) {

		createMountaineers();
		relocateMountaineers(spaceStarting);
		relocateTents();
		createAcclimatizationIndicator();

	}

	private void createMountaineers() {

		this.mountaineerI = new Mountaineer(MountaineerEnum.I);
		this.mountaineerII = new Mountaineer(MountaineerEnum.II);

	}

	private void relocateMountaineers(Space space) {

		this.mountaineerI.setMountaineerSpace(space);
		this.mountaineerII.setMountaineerSpace(space);

		space.relocateMountaineer(this.mountaineerI,
				SpaceMountaineerLocationEnum.TOP_LEFT);
		space.relocateMountaineer(this.mountaineerII,
				SpaceMountaineerLocationEnum.BOTTOM_RIGHT);

	}

	private void relocateTents() {

		double x = Coordinates.TENT_STARTING_LOCATION.x();
		double y = Coordinates.TENT_STARTING_LOCATION.y();

		this.mountaineerI.relocateTent(x, y);

		x += Dimensions.TENT_GAME.x() + Dimensions.GAP_BETWEEN_COMPONENTS.x();

		this.mountaineerII.relocateTent(x, y);

	}

	private void createAcclimatizationIndicator() {
		this.acclimatizationIndicator = new AcclimatizationIndicator(
				this.mountaineerI, this.mountaineerII);
	}

	private Mountaineer getMountaineer(MountaineerEnum mountaineerEnum) {

		Mountaineer mountaineer = null;

		switch (mountaineerEnum) {

		case I:
			mountaineer = this.mountaineerI;
			break;

		case II:
			mountaineer = this.mountaineerII;
			break;

		}

		return mountaineer;

	}

	public void addAcclimatizationToMountaineerAnimateAsynchronous(
			MountaineerEnum mountaineerEnum, int acclimatization) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);

		mountaineer.addAcclimatization(acclimatization);
		this.acclimatizationIndicator
				.animateTotalAcclimatizationAsynchronous(mountaineer);

	}

	public void addMovementToMountaineer(MountaineerEnum mountaineerEnum,
			int movement) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);
		mountaineer.addMovementPanelMovementUpdate(movement);

	}

	public void addMovementRopeUpToMountaineer(MountaineerEnum mountaineerEnum,
			int movement) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);
		mountaineer.addMovementRopeUpPanelMovementUpdate(movement);

	}

	public void addMovementRopeDownToMountaineer(
			MountaineerEnum mountaineerEnum, int movement) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);
		mountaineer.addMovementRopeDownPanelMovementUpdate(movement);

	}

	public void setMinusButtonVisible(boolean value) {

		this.mountaineerI.setMinusButtonVisible(value);
		this.mountaineerII.setMinusButtonVisible(value);

	}

}
