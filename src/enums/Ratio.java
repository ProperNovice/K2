package enums;

public enum Ratio {

	MAP((Dimensions.FRAME.y() - 2 * Dimensions.GAP_BETWEEN_BORDERS.y()) / Dimensions. MAP_ORIGINAL.y()),
	ACCLIMATIZATION_INDICATOR((Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x() - Dimensions.GAP_BETWEEN_COMPONENTS.x() - Dimensions.MAP_ORIGINAL.x() * MAP.ratio()) / Dimensions.ACCLIMATIZATION_INDICATOR_ORIGINAL.x()),
	CARD((Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x() - Dimensions.MAP_ORIGINAL.x() * MAP.ratio() - 9 * Dimensions.GAP_BETWEEN_COMPONENTS.x()) / (9 * Dimensions.CARD_ORIGINAL.x())),
	RISK_TOKEN((Dimensions.FRAME.x() - 2 * Dimensions.GAP_BETWEEN_BORDERS.x() - Dimensions.MAP_ORIGINAL.x() * MAP.ratio() - 10 * Dimensions.GAP_BETWEEN_COMPONENTS.x()) / (10 * Dimensions.RISK_TOKEN_ORIGINAL.x())),
	
	;

	private double ratio = -1;

	private Ratio(double ratio) {
		this.ratio = ratio;
	}

	public double ratio() {
		return this.ratio;
	}

}
