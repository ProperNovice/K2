package mountaineers;

import model.Space;
import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private MountaineerEnum mountaineerEnum = null;
	private ImageView mountaineerMap = null, tent = null;
	private Space mountaineerSpace = null;
	private int acclimatization = 1;
	private int movement = 0;
	private int movementRopeUp = 0;
	private int movementRopeDown = 0;
	private PanelMovement panelMovement = null;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		this.mountaineerEnum = mountaineerEnum;

		createTent();
		createMountaineer();
		createPanelMovement();

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

	private void createPanelMovement() {
		this.panelMovement = new PanelMovement(this);
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

	public void addAcclimatization(int acclimatization) {

		this.acclimatization += acclimatization;
		this.acclimatization = (int) Math.min(10, this.acclimatization);

	}

	public int getAcclimatization() {
		return this.acclimatization;
	}

	public void addMovementPanelMovementUpdate(int movement) {

		this.movement += movement;
		this.panelMovement.setMovement(this.movement);

	}

	public void addMovementRopeUpPanelMovementUpdate(int movement) {

		this.movementRopeUp += movement;
		this.panelMovement.setMovementRopeUp(this.movementRopeUp);

	}

	public void addMovementRopeDownPanelMovementUpdate(int movement) {

		this.movementRopeDown += movement;
		this.panelMovement.setMovementRopeDown(this.movementRopeDown);

	}

	public void panelMovementSetVisible() {
		this.panelMovement.setVisibleFalse();
	}

	public void panelMovementReset() {
		this.panelMovement.resetPanel();
	}

	public void setMinusButtonVisible(boolean value) {
		this.panelMovement.setMinusButtonVisible(value);
	}

}
