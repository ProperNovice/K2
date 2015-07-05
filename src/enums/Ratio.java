package enums;

public enum Ratio {

	MAP((Dimensions.FRAME.y() - 2 * Dimensions.GAP_BETWEEN_BORDERS.y()) / Dimensions. MAP_ORIGINAL.y()),
	ACCLIMATIZATION_INDICATOR(150 / Dimensions.ACCLIMATIZATION_INDICATOR_ORIGINAL.y()),

	;

	private double ratio = -1;

	private Ratio(double ratio) {
		this.ratio = ratio;
	}

	public double ratio() {
		return this.ratio;
	}

}
