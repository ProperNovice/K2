package gameState;

import javafx.scene.input.KeyCode;
import utils.Lock;

import components.RiskToken;

import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseRiskToken extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.CHOOSE_RISK_TOKEN);

	}

	@Override
	protected void handleRiskTokenPlayPressed(RiskToken riskToken) {

		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.riskTokenController()
				.addRiskTokenFromPlayToDiscardAnimateSynchronous(riskToken);

		Lock.lock();

		int value = riskToken.getValue();

		if (value > 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.APPLY_RISK_TOKEN);
		else {

			if (super.controller.mountaineerController()
					.atLeastOneMountaineerHasMovementPoint())
				super.controller.gameStateController().setGameState(
						GameStateEnum.MOUNTAINEER_MOVEMENT);
			else
				super.controller.gameStateController().setGameState(
						GameStateEnum.END_TURN);

		}

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		RiskToken riskToken = null;

		switch (keyCode) {

		case Q:
			riskToken = super.controller.riskTokenController()
					.getFirstRiskTokenFromPlay();
			break;

		case W:
			riskToken = super.controller.riskTokenController()
					.getSecondRiskTokenFromPlay();
			break;

		case E:
			riskToken = super.controller.riskTokenController()
					.getThirdRiskTokenFromPlay();
			break;

		default:
			return;

		}

		handleRiskTokenPlayPressed(riskToken);

	}

	@Override
	public boolean restartButtonIsVisible() {
		return true;
	}

}
