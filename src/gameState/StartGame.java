package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.START_GAME);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

}
