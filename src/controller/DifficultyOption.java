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

}
