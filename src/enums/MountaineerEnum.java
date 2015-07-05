package enums;

public enum MountaineerEnum {

	I("I", 70),
	II("II", 271);

	private String fileName = null;
	private double acclimatizationIndicatorY;

	private MountaineerEnum(String fileName, double acclimatizationIndicatorY) {
		this.fileName = fileName;
		this.acclimatizationIndicatorY = acclimatizationIndicatorY;
	}

	public String fileName() {
		return this.fileName;
	}

	public double acclimatizationIndicatorY() {
		return this.acclimatizationIndicatorY;
	}

}
