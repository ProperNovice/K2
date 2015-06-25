package controller;

import java.util.ArrayList;

import model.Space;

public class SpaceController {

	private ArrayList<Space> spaces = new ArrayList<>();

	public SpaceController() {

	}

	public void addSpace(Space space) {
		this.spaces.add(space);
	}

}
