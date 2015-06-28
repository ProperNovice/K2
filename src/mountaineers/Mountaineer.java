package mountaineers;

import model.Space;
import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private MountaineerEnum mountaineerEnum = null;
	private ImageView mountaineerMap = null;
	private ImageView tent = null;
	private Space mountaineerSpace = null;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		this.mountaineerEnum = mountaineerEnum;

		createMountaineer();
		createTent();

	}

	private void createMountaineer() {

		String path = "mountaineers/" + this.mountaineerEnum.fileName()
				+ ".png";

		this.mountaineerMap = new ImageView(path);

		this.mountaineerMap.setHeight(Dimensions.MOUNTAINEER_GAME.y());
		this.mountaineerMap.relocate(50, 50);

	}

	private void createTent() {

		String path = "tents/" + this.mountaineerEnum.fileName() + ".png";

		this.tent = new ImageView(path);
		this.tent.setWidth(Dimensions.TENT_GAME.x());

	}

	public MountaineerEnum getMountaineerEnum() {
		return this.mountaineerEnum;
	}

	public void relocateMountaineer(double x, double y) {
		this.mountaineerMap.relocate(x, y);
	}

	public void setMountaineerSpace(Space space) {
		this.mountaineerSpace = space;
	}

	public Space getMountaineerSpace() {
		return this.mountaineerSpace;
	}

	public void relocateTent(double x, double y) {
		this.tent.relocate(x, y);
	}

	public ImageView getTent() {
		return this.tent;
	}

}
