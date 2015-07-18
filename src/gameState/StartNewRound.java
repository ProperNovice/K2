package gameState;

import utils.Lock;
import enums.GameStateEnum;

public class StartNewRound extends GameState {

	private int currentRound = 0;

	@Override
	public void handleGameStateChange() {

		reset();

		this.currentRound++;

		handleCards();

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		handleWeather();

		Lock.lock();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

	private void reset() {

		super.controller.mountaineerController().clearWasDealtCardThisTurn();

	}

	private void handleCards() {

		if (!super.controller.cardController().deckIsEmpty())
			super.controller.cardController()
					.addCardsFromDeckToHandRearrangeSynchronous();

		else if (!super.controller.cardController().handIsEmpty())
			super.controller.cardController().rearrangeHandSynchronous();

		else {

			super.controller.cardController()
					.addCardsFromDiscardToDeckAnimateSynchronous();

			Lock.lock();

			super.controller.cardController()
					.addCardsFromDeckToHandRearrangeSynchronous();

		}

	}

	private void handleWeather() {

		if (this.currentRound == 1)
			return;

		super.controller.weatherTileController()
				.proceedToNextTurnAnimateSynchronous();

	}

}
