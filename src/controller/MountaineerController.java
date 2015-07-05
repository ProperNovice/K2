package controller;

import model.AcclimatizationIndicator;
import model.Space;
import mountaineers.Mountaineer;
import enums.MountaineerEnum;
import enums.SpaceMountaineerLocationEnum;

public class MountaineerController {

	private Mountaineer mountaineerI = null, mountaineerII = null;
	private AcclimatizationIndicator acclimatizationIndicator = null;

	public MountaineerController(Space spaceStarting) {

		createMountaineers();
		relocateMountaineers(spaceStarting);
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

	private void createAcclimatizationIndicator() {
		this.acclimatizationIndicator = new AcclimatizationIndicator(
				this.mountaineerI, this.mountaineerII);
	}

}
