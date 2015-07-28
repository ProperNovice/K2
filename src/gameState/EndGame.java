package gameState;

import instances.Instances;
import javafx.scene.input.KeyCode;
import enums.TextEnum;

public class EndGame extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.mountaineerController()
				.atLeastOneMountaineerHasZeroAcclimatization())
			super.controller.textController().showText(TextEnum.YOU_LOST);

		else {

			int pointsNeededToWin = super.controller.difficultyOption()
					.getPointsNeededToWin();
			int mountaineersTotalPoints = super.controller
					.mountaineerController().getMountaineersTotalPoints();

			if (mountaineersTotalPoints >= pointsNeededToWin)
				super.controller.textController().showText(TextEnum.YOU_WON);
			else
				super.controller.textController().showText(TextEnum.YOU_LOST);

		}

		super.controller.textController().showText(TextEnum.RESTART_GAME);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		restartGame();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCode.R))
			restartGame();

	}

	private void restartGame() {
		Instances.getPanelGameInstance().restartGame();
	}

}
