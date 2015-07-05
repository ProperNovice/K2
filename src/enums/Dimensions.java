package enums;

public enum Dimensions {

	FRAME(1366, 1000),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(20, 20),
	GAP_BETWEEN_COMPONENTS(10, 10),
	MAP_ORIGINAL(1163, 1500),
	TENT_ORIGINAL(229, 155),
	CARD_ORIGINAL(102, 102),
	ACCLIMATIZATION_INDICATOR_ORIGINAL(1654, 591),
	RISK_TOKEN_ORIGINAL(40, 40),
	WEATHER_TILE_ORIGINAL(1181, 591),
	MAP_GAME(MAP_ORIGINAL.x() * Ratio.MAP.ratio(), MAP_ORIGINAL.y() * Ratio.MAP.ratio()),
	MOUNTAINEER_GAME(SpaceSize.SMALL.height() * Ratio.MAP.ratio() / 2, SpaceSize.SMALL.height() * Ratio.MAP.ratio() / 2),
	ACCLIMATIZATION_INDICATOR_GAME(ACCLIMATIZATION_INDICATOR_ORIGINAL.x() * Ratio.ACCLIMATIZATION_INDICATOR.ratio(), ACCLIMATIZATION_INDICATOR_ORIGINAL.y() * Ratio.ACCLIMATIZATION_INDICATOR.ratio()),
	TENT_GAME(MOUNTAINEER_GAME.x(), TENT_ORIGINAL.y() * MOUNTAINEER_GAME.x() / TENT_ORIGINAL.x()),
	CARD_GAME(CARD_ORIGINAL.x() * Ratio.CARD.ratio(), CARD_ORIGINAL.y() * Ratio.CARD.ratio()),
	RISK_TOKEN_GAME(RISK_TOKEN_ORIGINAL.x() * Ratio.RISK_TOKEN.ratio(), RISK_TOKEN_ORIGINAL.y() * Ratio.RISK_TOKEN.ratio()),

	;

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
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
