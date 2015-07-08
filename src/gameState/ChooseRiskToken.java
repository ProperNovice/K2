package gameState;

import utils.Animation.AnimationSynch;
import components.RiskToken;
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

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrange(AnimationSynch.ASYNCHRONOUS);

	}

}
