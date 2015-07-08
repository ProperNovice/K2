package gameState;

import utils.Animation.AnimationSynch;
import utils.Lock;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous();

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrange(
						AnimationSynch.SYNCHRONOUS);

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
