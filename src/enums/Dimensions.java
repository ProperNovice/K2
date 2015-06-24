package enums;

public enum Dimensions {

	FRAME(1366, 1000),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	MAP_ORIGINAL(1163, 1500),
	MAP_RATIO((FRAME.y() - 2 * GAP_BETWEEN_BORDERS.y()) / MAP_ORIGINAL.y(), (FRAME.y() - 2 * GAP_BETWEEN_BORDERS.y()) / MAP_ORIGINAL.y()),
	MAP(MAP_ORIGINAL.x() * MAP_RATIO.x(), MAP_ORIGINAL.y() * MAP_RATIO.y()),
	
	
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
