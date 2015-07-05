package enums;

public enum Coordinates {

	TEXT_PANEL(50, 50),
	MAP(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	ACCLIMATIZATION_INDICATOR(MAP.x() + Dimensions.MAP_GAME.x() + Dimensions.GAP_BETWEEN_COMPONENTS.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.ACCLIMATIZATION_INDICATOR_GAME.y()),
	DECK(ACCLIMATIZATION_INDICATOR.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	RISK_TOKEN_PILE(DECK.x(), Coordinates.DECK.y() + 2 * (Dimensions.CARD_ORIGINAL.x() * Ratio.CARD.ratio() + Dimensions.GAP_BETWEEN_COMPONENTS.y())),
	
	;

	private double x = -1, y = -1;

	private Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
