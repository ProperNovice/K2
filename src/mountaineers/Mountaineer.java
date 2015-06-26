package mountaineers;

import model.Space;
import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private MountaineerEnum mountaineerEnum = null;
	private ImageView mountaineerMap = null;
	private Space currentSpace = null;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		this.mountaineerEnum = mountaineerEnum;
		createImage();

	}

	private void createImage() {

		String path = "mountaineers/" + this.mountaineerEnum.fileName()
				+ ".png";

		this.mountaineerMap = new ImageView(path);

		this.mountaineerMap.setHeight(Dimensions.MOUNTAINEER_GAME.y());
		this.mountaineerMap.relocate(50, 50);

	}

	public MountaineerEnum getMountaineerEnum() {
		return this.mountaineerEnum;
	}

	public void relocate(double x, double y) {
		this.mountaineerMap.relocate(x, y);
	}

	public void setCurrentSpace(Space space) {
		this.currentSpace = space;
	}

	public Space getCurrentSpace() {
		return this.currentSpace;
	}

}
