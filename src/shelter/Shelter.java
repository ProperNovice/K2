package shelter;

import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;
import enums.MountaineerEnum;

public class Shelter {

	private ImageView shelter = null;
	private MountaineerEnum mountaineerEnum = null;

	public Shelter(MountaineerEnum mountaineerEnum) {
		this.mountaineerEnum = mountaineerEnum;
	}

	protected void createShelter(String path) {

		path = "/shelters/" + path + "/" + this.mountaineerEnum.fileName()
				+ ".png";
		this.shelter = new ImageView(path);

	}

	public void relocate(double x, double y) {
		this.shelter.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.shelter, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

}
