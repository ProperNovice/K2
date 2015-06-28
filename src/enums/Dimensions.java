package enums;

public enum Dimensions {

	FRAME(1366, 1000),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	MAP_ORIGINAL(1163, 1500),
	MAP_RATIO((FRAME.y() - 2 * GAP_BETWEEN_BORDERS.y()) / MAP_ORIGINAL.y(), (FRAME.y() - 2 * GAP_BETWEEN_BORDERS.y()) / MAP_ORIGINAL.y()),
	MAP_GAME(MAP_ORIGINAL.x() * MAP_RATIO.x(), MAP_ORIGINAL.y() * MAP_RATIO.y()),
	MOUNTAINEER_ORIGINAL(228, 367),
	MOUNTAINEER_RATIO(SpaceSize.SMALL.height() * Dimensions.MAP_RATIO.x() / (2.5 * MOUNTAINEER_ORIGINAL.y()), SpaceSize.SMALL.height() * Dimensions.MAP_RATIO.x() / (2.5 * MOUNTAINEER_ORIGINAL.y())),
	MOUNTAINEER_GAME(MOUNTAINEER_ORIGINAL.x() * MOUNTAINEER_RATIO.x(), MOUNTAINEER_ORIGINAL.y() * MOUNTAINEER_RATIO.y()),
	TENT_ORIGINAL(229, 155),
	TENT_GAME(MOUNTAINEER_GAME.x(), TENT_ORIGINAL.y() * MOUNTAINEER_GAME.x() / TENT_ORIGINAL.x()),
	
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
