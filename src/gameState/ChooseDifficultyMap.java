package gameState;

import enums.DifficultyMap;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseDifficultyMap extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(
				TextEnum.CHOOSE_DIFFICULTY_MAP);
		super.controller.textController().showText(TextEnum.EASY);
		super.controller.textController().showText(TextEnum.HARD);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		DifficultyMap difficultyMap = null;

		switch (textEnum) {

		case EASY:
			difficultyMap = DifficultyMap.EASY;
			break;

		case HARD:
			difficultyMap = DifficultyMap.HARD;
			break;

		default:
			break;

		}

		super.controller.difficultyOption().setDifficultyMap(difficultyMap);
		super.controller.createMap(difficultyMap);

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_DIFFICULTY_WEATHER);

	}

}
