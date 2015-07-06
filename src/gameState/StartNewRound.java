package gameState;

import utils.Lock;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous(6);

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		Lock.lock();

	}

}
