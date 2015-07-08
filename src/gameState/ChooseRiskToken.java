package gameState;

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

		super.controller.riskTokenController()
				.addRiskTokenFromPlayToDiscardAnimateAsynchronous(riskToken);

		int value = riskToken.getValue();

		if (value > 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.APPLY_RISK_TOKEN);

	}

}
