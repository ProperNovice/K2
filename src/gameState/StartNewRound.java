package gameState;

import utils.Animation.AnimationSynch;
import utils.Lock;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrange(AnimationSynch.SYNCHRONOUS);

		super.controller.cardController()
				.addCardsFromDeckToHandRearrangeSynchronous();

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
