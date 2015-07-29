package gameState;

import javafx.scene.input.KeyCode;
import enums.DifficultyWeather;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseDifficultyWeather extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_WEATHER_DIFFICULTY);
		super.controller.textController().showText(TextEnum.SUMMER);
		super.controller.textController().showText(TextEnum.WINTER);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		DifficultyWeather difficultyWeather = null;

		switch (textEnum) {

		case SUMMER:
			difficultyWeather = DifficultyWeather.SUMMER;
			break;

		case WINTER:
			difficultyWeather = DifficultyWeather.WINTER;
			break;

		default:
			break;

		}

		super.controller.difficultyOption().setDifficultyWeather(
				difficultyWeather);
		super.controller.createWeatherTiles(difficultyWeather);

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_GAME);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.Q))
			handleTextOptionPressed(TextEnum.SUMMER);
		else if (keyCode.equals(KeyCode.W))
			handleTextOptionPressed(TextEnum.WINTER);

	}

}
