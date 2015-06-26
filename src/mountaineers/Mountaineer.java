package mountaineers;

import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private MountaineerEnum mountaineerEnum = null;
	private ImageView imageView = null;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		this.mountaineerEnum = mountaineerEnum;
		createImage();

	}

	private void createImage() {

		String path = "mountaineers/" + this.mountaineerEnum.fileName()
				+ ".png";

		this.imageView = new ImageView(path);

		this.imageView.setHeight(Dimensions.MOUNTAINEER_GAME.y());
		this.imageView.relocate(50, 50);

	}

	public MountaineerEnum getMountaineerEnum() {
		return this.mountaineerEnum;
	}

}
