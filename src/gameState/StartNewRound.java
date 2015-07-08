package gameState;

import enums.GameStateEnum;
import utils.Lock;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous();

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		Lock.lock();
		
		super.controller.gameStateController().setGameState(GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
