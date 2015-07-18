package gameState;

import utils.Lock;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	private int currentRound = 0;

	@Override
	public void handleGameStateChange() {

		this.currentRound++;

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous();

		if (this.currentRound > 1)
			super.controller.weatherTileController()
					.proceedToNextTurnAnimateSynchronous();

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
