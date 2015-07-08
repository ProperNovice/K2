package enums;

public enum Coordinates {

	MAP(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	ACCLIMATIZATION_INDICATOR(MAP.x() + Dimensions.MAP_GAME.x() + Dimensions.GAP_BETWEEN_COMPONENTS.x(), Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.ACCLIMATIZATION_INDICATOR_GAME.y()),
	WEATHER_TILES(ACCLIMATIZATION_INDICATOR.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	RISK_TOKEN_DECK(WEATHER_TILES.x(), WEATHER_TILES.y() + Dimensions.WEATHER_TILE_ORIGINAL.y() * Ratio.WEATHER_TILE.ratio() + Dimensions.GAP_BETWEEN_COMPONENTS.y()),
	DECK(RISK_TOKEN_DECK.x(), Coordinates.RISK_TOKEN_DECK.y() + 2 * (Dimensions.RISK_TOKEN_ORIGINAL.y() * Ratio.RISK_TOKEN.ratio() + Dimensions.GAP_BETWEEN_COMPONENTS.y())),
	WEATHER_INDICATOR_GAME(51 * Ratio.WEATHER_TILE.ratio(), 20 * Ratio.WEATHER_TILE.ratio()),
	HAND(ACCLIMATIZATION_INDICATOR.x(), ACCLIMATIZATION_INDICATOR.y() - 2 * (Dimensions.GAP_BETWEEN_COMPONENTS.y() + Dimensions.CARD_GAME.y())),
	RISK_TOKEN_PLAY(HAND.x(), HAND.y() - Dimensions.GAP_BETWEEN_COMPONENTS.y() - Dimensions.RISK_TOKEN_ORIGINAL.y() * Ratio.RISK_TOKEN.ratio()),
	TENT_STARTING_LOCATION(RISK_TOKEN_PLAY.x(), RISK_TOKEN_PLAY.y() - Dimensions.GAP_BETWEEN_COMPONENTS.y() - Dimensions.TENT_ORIGINAL.y() * Dimensions.MOUNTAINEER_GAME.x() / Dimensions.TENT_ORIGINAL.x()),
	TEXT_PANEL(HAND.x() + 3 * (Dimensions.CARD_GAME.x() + Dimensions.GAP_BETWEEN_COMPONENTS.x()), HAND.y()),
	CARD_DISCARD_PILE(MAP.x() + 997 * Ratio.MAP.ratio() + (148 * Ratio.MAP.ratio() - Dimensions.CARD_GAME.x()) / 2, MAP.y() + 1090 * Ratio.MAP.ratio()),
	RISK_TOKEN_DISCARD_PILE(MAP.x() + 997 * Ratio.MAP.ratio() + (148 * Ratio.MAP.ratio() - Dimensions.RISK_TOKEN_GAME.x()) / 2, CARD_DISCARD_PILE.y() + Dimensions.CARD_GAME.y() + 2 * Dimensions.GAP_BETWEEN_COMPONENTS.y()),
	PANEL_MOVEMENT_MOUNTAINEER_I(1230, RISK_TOKEN_PLAY.y() - 40),
	PANEL_MOVEMENT_MOUNTAINEER_II(PANEL_MOVEMENT_MOUNTAINEER_I.x(), PANEL_MOVEMENT_MOUNTAINEER_I.y() + 130),
	
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
