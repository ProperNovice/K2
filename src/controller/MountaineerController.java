package controller;

import model.Space;
import mountaineers.AcclimatizationIndicator;
import mountaineers.Mountaineer;
import utils.ArrayList;
import enums.Coordinates;
import enums.Dimensions;
import enums.MountaineerEnum;
import enums.SpaceMountaineerLocationEnum;

public class MountaineerController {

	private Mountaineer mountaineerI = null, mountaineerII = null;
	private AcclimatizationIndicator acclimatizationIndicator = null;
	private ArrayList<MountaineerEnum> dealtCardThisTurn = new ArrayList<>();

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

	public void animateMountaineerToSpace(Mountaineer mountaineer, Space space) {

		if (this.mountaineerI.getMountaineerSpace().equals(space)
				|| this.mountaineerII.getMountaineerSpace().equals(space))

			space.animateMountaineerAsynchronous(mountaineer,
					SpaceMountaineerLocationEnum.BOTTOM_RIGHT);

		else {

			space.animateMountaineerAsynchronous(mountaineer,
					SpaceMountaineerLocationEnum.TOP_LEFT);

			if (mountaineer.equals(this.mountaineerI))
				this.mountaineerII.getMountaineerSpace()
						.animateMountaineerAsynchronous(this.mountaineerII,
								SpaceMountaineerLocationEnum.TOP_LEFT);
			else if (mountaineer.equals(this.mountaineerII))
				this.mountaineerI.getMountaineerSpace()
						.animateMountaineerAsynchronous(this.mountaineerI,
								SpaceMountaineerLocationEnum.TOP_LEFT);

		}

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

	public Mountaineer getMountaineer(MountaineerEnum mountaineerEnum) {

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

	public void addAcclimatizationToMountaineerAnimateSynchronous(
			MountaineerEnum mountaineerEnum, int acclimatization) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);

		mountaineer.addAcclimatization(acclimatization);
		this.acclimatizationIndicator
				.animateTotalAcclimatizationSynchronous(mountaineer);

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

	public void setAllMinusButtonsVisible(boolean value) {

		this.mountaineerI.setMinusButtonVisible(value);
		this.mountaineerII.setMinusButtonVisible(value);

	}

	public boolean mountaineerAcclimatizationIsZero(
			MountaineerEnum mountaineerEnum) {

		Mountaineer mountaineer = getMountaineer(mountaineerEnum);
		return (mountaineer.getAcclimatization() == 0);

	}

	public void setDealtCardThisTurn(MountaineerEnum mountaineerEnum) {

		if (this.dealtCardThisTurn.contains(mountaineerEnum))
			return;

		this.dealtCardThisTurn.add(mountaineerEnum);

	}

	public boolean wasDealtCardThisTurn(MountaineerEnum mountaineerEnum) {
		return this.dealtCardThisTurn.contains(mountaineerEnum);
	}

	public boolean atLeastOneMountaineerHasMovementPoint() {

		if (this.mountaineerI.hasAtLeastOneMovementPoint())
			return true;

		if (this.mountaineerII.hasAtLeastOneMovementPoint())
			return true;

		return false;

	}

	public Mountaineer getMountaineerMoving() {

		if (this.mountaineerI.hasAtLeastOneMovementPoint())
			return this.mountaineerI;
		else
			return this.mountaineerII;

	}

}
