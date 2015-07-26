package controller;

import enums.DifficultyMap;
import enums.DifficultyWeather;

public class DifficultyOption {

	private DifficultyMap difficultyMap = null;
	private DifficultyWeather difficultyWeather = null;

	public DifficultyOption() {

	}

	public void setDifficultyMap(DifficultyMap difficultyMap) {
		this.difficultyMap = difficultyMap;
	}

	public DifficultyMap getDifficultyMap() {
		return this.difficultyMap;
	}

	public void setDifficultyWeather(DifficultyWeather difficultyWeather) {
		this.difficultyWeather = difficultyWeather;
	}

	public DifficultyWeather getDiffficultyWeather() {
		return this.difficultyWeather;
	}

	public int getPointsNeededToWin() {

		if (this.difficultyMap.equals(DifficultyMap.EASY)) {
			if (this.difficultyWeather.equals(DifficultyWeather.SUMMER))
				return 20;
			else if (this.difficultyWeather.equals(DifficultyWeather.WINTER))
				return 17;

		} else if (this.difficultyMap.equals(DifficultyMap.HARD)) {
			if (this.difficultyWeather.equals(DifficultyWeather.SUMMER))
				return 17;
			else if (this.difficultyWeather.equals(DifficultyWeather.WINTER))
				return 16;

		}

		return -1;

	}

}
