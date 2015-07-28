package gameState;

import javafx.scene.input.KeyCode;
import enums.GameStateEnum;
import enums.KeyCodeEnum;
import enums.RopeMovement;
import enums.TextEnum;

public class ChooseRopeDirection extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.UP);
		super.controller.textController().showText(TextEnum.DOWN);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		RopeMovement ropeMovement = null;

		switch (textEnum) {

		case UP:
			ropeMovement = RopeMovement.UP;
			break;

		case DOWN:
			ropeMovement = RopeMovement.DOWN;
			break;

		default:
			break;

		}

		super.controller.cardController().setRopeMovementPlayAs(ropeMovement);

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_MOUNTAINEER_TO_APPLY_CARD);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCodeEnum.FIRST_OPTION.keyCode()))
			handleTextOptionPressed(TextEnum.UP);

		else if (keyCode.equals(KeyCodeEnum.SECOND_OPTION.keyCode()))
			handleTextOptionPressed(TextEnum.DOWN);

	}

	@Override
	public boolean restartButtonIsVisible() {
		return true;
	}

}
