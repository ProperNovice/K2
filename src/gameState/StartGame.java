package gameState;

import javafx.scene.input.KeyCode;
import enums.GameStateEnum;
import enums.TextEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.createSaveGameController();

		super.controller.textController().showText(TextEnum.START_GAME);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.S))
			handleTextOptionPressed(TextEnum.START_GAME);

	}

}
