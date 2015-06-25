package enums;

public enum SpaceSize {

	BIG(134, 134), SMALL(116, 116);

	private double width, height;

	private SpaceSize(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double width() {
		return this.width;
	}

	public double height() {
		return this.height;
	}

}
