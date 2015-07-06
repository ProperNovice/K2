package enums;

public enum Coordinates {

	TEXT_PANEL(50, 50),
	MAP(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	ACCLIMATIZATION_INDICATOR(MAP.x() + Dimensions.MAP_GAME.x() + Dimensions.GAP_BETWEEN_COMPONENTS.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.ACCLIMATIZATION_INDICATOR_GAME.y()),
	WEATHER_TILES(ACCLIMATIZATION_INDICATOR.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	RISK_TOKEN_PILE(WEATHER_TILES.x(), WEATHER_TILES.y() + Dimensions.WEATHER_TILE_ORIGINAL.y() * Ratio.WEATHER_TILE.ratio() + Dimensions.GAP_BETWEEN_COMPONENTS.y()),
	DECK(RISK_TOKEN_PILE.x(), Coordinates.RISK_TOKEN_PILE.y() + 2 * (Dimensions.RISK_TOKEN_ORIGINAL.y() * Ratio.RISK_TOKEN.ratio() + Dimensions.GAP_BETWEEN_COMPONENTS.y())),
	WEATHER_INDICATOR(51 * Ratio.WEATHER_TILE.ratio(), 20 * Ratio.WEATHER_TILE.ratio()),
	
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
