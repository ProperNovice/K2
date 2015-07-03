package controller;

import java.util.ArrayList;

import enums.MountaineerEnum;
import enums.SpaceMountaineerLocationEnum;
import model.AcclimatizationIndicator;
import model.Space;
import mountaineers.Mountaineer;

public class MountaineerController {

	private ArrayList<Mountaineer> mountaineers = new ArrayList<>();
	private AcclimatizationIndicator acclimatizationIndicator = null;

	public MountaineerController(Space spaceStarting) {
		createMountaineers();
		relocateMountaineers(spaceStarting);
		createAcclimatizationIndicator();
	}

	private void createMountaineers() {

		for (MountaineerEnum mountaineerEnum : MountaineerEnum.values())
			this.mountaineers.add(new Mountaineer(mountaineerEnum));

	}

	private void relocateMountaineers(Space space) {

		this.mountaineers.get(0).setMountaineerSpace(space);
		this.mountaineers.get(1).setMountaineerSpace(space);

		space.relocateMountaineer(this.mountaineers.get(0),
				SpaceMountaineerLocationEnum.TOP_LEFT);
		space.relocateMountaineer(this.mountaineers.get(1),
				SpaceMountaineerLocationEnum.BOTTOM_RIGHT);

	}

	private void createAcclimatizationIndicator() {
		this.acclimatizationIndicator = new AcclimatizationIndicator(
				this.mountaineers.get(0), this.mountaineers.get(1));
	}

}
