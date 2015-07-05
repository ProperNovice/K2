package mountaineers;

import model.Space;
import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private ImageView mountaineerMap = null;
	private ImageView tent = null;
	private Space mountaineerSpace = null;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		createTent(mountaineerEnum);
		createMountaineer(mountaineerEnum);

	}

	private void createMountaineer(MountaineerEnum mountaineerEnum) {

		String path = "mountaineers/" + mountaineerEnum.fileName() + ".png";

		this.mountaineerMap = new ImageView(path);

		this.mountaineerMap.setHeight(Dimensions.MOUNTAINEER_GAME.y());
		this.mountaineerMap.relocate(50, 50);

	}

	private void createTent(MountaineerEnum mountaineerEnum) {

		String path = "tents/" + mountaineerEnum.fileName() + ".png";

		this.tent = new ImageView(path);
		this.tent.setWidth(Dimensions.TENT_GAME.x());

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
