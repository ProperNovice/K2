package controller;

import java.util.ArrayList;

import enums.MountaineerEnum;
import mountaineers.Mountaineer;

public class MountaineerController {

	private ArrayList<Mountaineer> mountaineers = new ArrayList<>();

	public MountaineerController() {
		createMountaineers();
	}

	private void createMountaineers() {

		for (MountaineerEnum mountaineerEnum : MountaineerEnum.values())
			this.mountaineers.add(new Mountaineer(mountaineerEnum));

	}

}
