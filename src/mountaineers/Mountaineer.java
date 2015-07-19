package mountaineers;

import model.Space;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;
import enums.Dimensions;
import enums.MountaineerEnum;

public class Mountaineer {

	private MountaineerEnum mountaineerEnum = null;
	private ImageView mountaineerMap = null, mountaineerScore = null,
			tent = null;
	private Space mountaineerSpace = null;
	private Space mountaineerSpaceStarting = null;
	private int acclimatization = 1;
	private int acclimatizationStarting = 1;
	private int movement = 0;
	private int movementRopeUp = 0;
	private int movementRopeDown = 0;
	private PanelMovement panelMovement = null;
	private double tentStartingX, tentStartingY;
	private boolean hasPlacedHisTent = false;
	private boolean hasPlacedHisTentThisRound = false;
	private Space tentSpace = null;
	private int victoryPoints = 1;
	private int victoryPointsStarting = 1;

	public Mountaineer(MountaineerEnum mountaineerEnum) {

		this.mountaineerEnum = mountaineerEnum;

		createTent();
		createMountaineers();
		createPanelMovement();

	}

	private void createMountaineers() {

		String path = "mountaineers/" + this.mountaineerEnum.fileName()
				+ ".png";

		this.mountaineerMap = new ImageView(path);
		this.mountaineerScore = new ImageView(path);

		this.mountaineerMap.setHeight(Dimensions.MOUNTAINEER_GAME.y());
		this.mountaineerScore.setHeight(Dimensions.MOUNTAINEER_GAME.y());

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

	public void animateMountaineerSynchronous(double endingX, double endingY) {
		Animation.animate(this.mountaineerMap, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public void setMountaineerSpace(Space space) {
		this.mountaineerSpace = space;
	}

	public Space getMountaineerSpace() {
		return this.mountaineerSpace;
	}

	public void relocateTent(double x, double y) {

		this.tentStartingX = x;
		this.tentStartingY = y;

		this.tent.relocate(x, y);

	}

	public ImageView getTentAndSetHasBeenPlaced(Space space) {
		this.tentSpace = space;
		this.hasPlacedHisTent = true;
		this.hasPlacedHisTentThisRound = true;
		return this.tent;
	}

	public void addAcclimatization(int acclimatization) {

		this.acclimatization += acclimatization;
		this.acclimatization = (int) Math.min(10, this.acclimatization);
		this.acclimatization = (int) Math.max(0, this.acclimatization);

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

	public int getMovement() {
		return this.movement;
	}

	public int getMovementRopeUp() {
		return this.movementRopeUp;
	}

	public int getMovementRopeDown() {
		return this.movementRopeDown;
	}

	public boolean hasAtLeastOneMovementPoint() {

		if (this.movement > 0)
			return true;

		if (this.movementRopeUp > 0)
			return true;

		if (this.movementRopeDown > 0)
			return true;

		return false;

	}

	public void panelMovementSetVisible() {
		this.panelMovement.setVisibleFalse();
	}

	public void panelMovementReset() {
		this.panelMovement.resetPanel();
	}

	public void setMinusButtonVisible(boolean value) {
		this.panelMovement.setAllMinusButtonsVisible(value);
	}

	public void resetMovement() {

		this.movement = 0;
		this.movementRopeUp = 0;
		this.movementRopeDown = 0;

		this.panelMovement.setMovement(this.movement);
		this.panelMovement.setMovementRopeUp(this.movementRopeUp);
		this.panelMovement.setMovementRopeDown(this.movementRopeDown);

	}

	public boolean hasPlacedHisTent() {
		return this.hasPlacedHisTent;
	}

	public void resetStartingSpace() {
		this.mountaineerSpaceStarting = this.mountaineerSpace;
	}

	public void resetStartingAcclimatization() {
		this.acclimatizationStarting = this.acclimatization;
	}

	public void resetStartingVictoryPoints() {
		this.victoryPointsStarting = this.victoryPoints;
	}

	public void resetToStartingSpace() {
		this.mountaineerSpace = this.mountaineerSpaceStarting;
	}

	public void resetToStartingVictoryPoints() {
		this.victoryPoints = this.victoryPointsStarting;
	}

	public int getAcclimatizationDifferenceFromStrarting() {
		return this.acclimatizationStarting - this.acclimatization;
	}

	public boolean hasPlayedHisTentThisRound() {
		return this.hasPlacedHisTentThisRound;
	}

	public void setHasPlayedHisTentThisRoundFalse() {
		this.hasPlacedHisTentThisRound = false;
	}

	public void resetTent() {

		this.hasPlacedHisTent = false;
		this.hasPlacedHisTentThisRound = false;
		this.tentSpace.setContainsTentFalse();

		Animation.animate(this.tent, this.tentStartingX, this.tentStartingY,
				AnimationSynch.SYNCHRONOUS);

	}

	public ImageView getMountaineerScore() {
		return this.mountaineerScore;
	}

	public int getCurrentVictoryPoints() {
		return this.victoryPoints;
	}

	public void setCurrentVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}
