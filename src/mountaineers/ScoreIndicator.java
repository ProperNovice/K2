package mountaineers;

import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import enums.Coordinates;
import enums.Dimensions;
import enums.Ratio;
import enums.ScoreLocationEnum;

public class ScoreIndicator {

	private double topLeftX = Coordinates.SCORE_TRACK_EASY_MAP_TOP_LEFT.x();
	private ArrayList<ScoreCoordinates> scoreCoordinates = new ArrayList<>();

	public ScoreIndicator() {

		createCoordinatesY();

	}

	private void createCoordinatesY() {

		this.scoreCoordinates.add(new ScoreCoordinates(1, 1007));
		this.scoreCoordinates.add(new ScoreCoordinates(2, 881));
		this.scoreCoordinates.add(new ScoreCoordinates(3, 763));
		this.scoreCoordinates.add(new ScoreCoordinates(4, 655));
		this.scoreCoordinates.add(new ScoreCoordinates(5, 494));
		this.scoreCoordinates.add(new ScoreCoordinates(6, 352));
		this.scoreCoordinates.add(new ScoreCoordinates(7, 178));
		this.scoreCoordinates.add(new ScoreCoordinates(10, 24));

	}

	private class ScoreCoordinates {

		int score;
		double yCoordinate;

		public ScoreCoordinates(int score, double yCoordinate) {
			this.score = score;
			this.yCoordinate = yCoordinate * Ratio.MAP.ratio()
					+ Coordinates.MAP.y();
		}

		public int getScore() {
			return this.score;
		}

		public double getCoordinate() {
			return this.yCoordinate;
		}

	}

	public void relocateScoreMountaineerSynchronous(Mountaineer mountaineer,
			int score, ScoreLocationEnum scoreLocationEnum) {

		double x = this.topLeftX;
		double y = -1;

		if (scoreLocationEnum.equals(ScoreLocationEnum.RIGHT))
			x += Dimensions.MOUNTAINEER_GAME.x()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

		for (ScoreCoordinates scoreCoordinates : this.scoreCoordinates) {

			if (scoreCoordinates.getScore() != score)
				continue;

			y = scoreCoordinates.getCoordinate();
			break;

		}

		mountaineer.getMountaineerScore().relocate(x, y);

	}

	public void animateScoreMountaineerSynchronous(Mountaineer mountaineer,
			int score, ScoreLocationEnum scoreLocationEnum) {

		double x = this.topLeftX;
		double y = -1;

		if (scoreLocationEnum.equals(ScoreLocationEnum.RIGHT))
			x += Dimensions.MOUNTAINEER_GAME.x()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

		for (ScoreCoordinates scoreCoordinates : this.scoreCoordinates) {

			if (scoreCoordinates.getScore() != score)
				continue;

			y = scoreCoordinates.getCoordinate();
			break;

		}

		Animation.animate(mountaineer.getMountaineerScore(), x, y,
				AnimationSynch.SYNCHRONOUS);

	}
}
