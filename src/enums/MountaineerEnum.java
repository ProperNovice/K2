package enums;

public enum MountaineerEnum {

	I("I", 70, Coordinates.PANEL_MOVEMENT_MOUNTAINEER_I),
	II("II", 271, Coordinates.PANEL_MOVEMENT_MOUNTAINEER_II);

	private String fileName = null;
	private double acclimatizationIndicatorY;
	private Coordinates coordinatesPanelMovementMountaineer;

	private MountaineerEnum(String fileName, double acclimatizationIndicatorY,
			Coordinates coordinatesPanelMountaineer) {

		this.fileName = fileName;
		this.acclimatizationIndicatorY = acclimatizationIndicatorY;
		this.coordinatesPanelMovementMountaineer = coordinatesPanelMountaineer;

	}

	public String fileName() {
		return this.fileName;
	}

	public double acclimatizationIndicatorY() {
		return this.acclimatizationIndicatorY;
	}

	public Coordinates coordinatesPanelMovementMountaineer() {
		return this.coordinatesPanelMovementMountaineer;
	}

}
