package gameState;

import utils.Animation.AnimationSynch;
import utils.Lock;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	private int currentRound = 0;

	@Override
	public void handleGameStateChange() {

		this.currentRound++;

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrange(AnimationSynch.SYNCHRONOUS);

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous();

		if (this.currentRound > 1)
			super.controller.weatherTileController()
					.proceedToNextTurnAnimateAsynchronous();

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
