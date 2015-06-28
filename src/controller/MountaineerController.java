package controller;

import java.util.ArrayList;

import enums.MountaineerEnum;
import enums.SpaceMountaineerLocationEnum;
import model.Space;
import mountaineers.Mountaineer;

public class MountaineerController {

	private ArrayList<Mountaineer> mountaineers = new ArrayList<>();

	public MountaineerController(Space spaceStarting) {
		createMountaineers();
		relocateMountaineers(spaceStarting);
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

}
