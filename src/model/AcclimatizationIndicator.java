package model;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;
import mountaineers.Mountaineer;
import utils.Circle;
import utils.ImageView;
import enums.Coordinates;
import enums.Dimensions;
import enums.Ratio;

public class AcclimatizationIndicator {

	private ImageView imageView = null;
	private double zeroX = 45 * Ratio.ACCLIMATIZATION_INDICATOR.ratio();
	private double circleRadius = 59 * Ratio.ACCLIMATIZATION_INDICATOR.ratio();
	private double distanceBetweenNumbers = 142 * Ratio.ACCLIMATIZATION_INDICATOR
			.ratio();
	private HashMap<Mountaineer, Circle> indicators = new HashMap<>();

	public AcclimatizationIndicator(Mountaineer mountaineerI,
			Mountaineer mountaineerII) {

		createImage();
		createIndicators(mountaineerI, mountaineerII);
		relocateIndicators();

	}

	private void createImage() {

		this.imageView = new ImageView("acclimatizationIndicator.png");
		this.imageView.setHeight(Dimensions.ACCLIMATIZATION_INDICATOR_GAME.y());
		this.imageView.relocate(Coordinates.ACCLIMATIZATION_INDICATOR.x(),
				Coordinates.ACCLIMATIZATION_INDICATOR.y());

	}

	private void createIndicators(Mountaineer mountaineerI,
			Mountaineer mountaineerII) {

		Circle circle = null;

		circle = new Circle(this.circleRadius);
		circle.setFill(Color.BLACK);
		this.indicators.put(mountaineerI, circle);

		circle = new Circle(this.circleRadius);
		circle.setFill(Color.BLACK);
		this.indicators.put(mountaineerII, circle);

	}

	private void relocateIndicators() {

		for (Map.Entry<Mountaineer, Circle> entry : this.indicators.entrySet()) {

			Mountaineer mountaineer = entry.getKey();
			Circle circle = entry.getValue();

			double circleY = mountaineer.getMountaineerEnum()
					.acclimatizationIndicatorY();
			circleY *= Ratio.ACCLIMATIZATION_INDICATOR.ratio();

			circle.relocate(Coordinates.ACCLIMATIZATION_INDICATOR.x()
					+ this.zeroX + this.distanceBetweenNumbers,
					Coordinates.ACCLIMATIZATION_INDICATOR.y() + circleY);

		}

	}

}
