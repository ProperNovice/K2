package shelter;

import enums.MountaineerEnum;

public class Tent extends Shelter {

	public Tent(MountaineerEnum mountaineerEnum) {

		super(mountaineerEnum);
		createShelter("tents");

	}

}
