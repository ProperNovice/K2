package gameState;

import utils.Lock;
import utils.Logger;
import enums.GameStateEnum;
import enums.MountaineerEnum;

public class StartNewRound extends GameState {

	private int currentRound = 0;

	@Override
	public void handleGameStateChange() {

		resetRound();

		this.currentRound++;

		handleCards();

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		handleWeather();

		Lock.lock();

		super.controller.saveGameController().saveTurn();

		if (this.currentRound > 1)
			if (this.currentRound % 3 == 1)
				super.controller.weatherTileController()
						.setWeatherTileDiscardedVisibleFalse();

		printMountaineersVictoryPoints();

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

	private void printMountaineersVictoryPoints() {

		Logger.log("M.I vp - "
				+ super.controller.mountaineerController()
						.getMountaineer(MountaineerEnum.I)
						.getCurrentVictoryPoints());
		Logger.logNewLine("M.II vp - "
				+ super.controller.mountaineerController()
						.getMountaineer(MountaineerEnum.II)
						.getCurrentVictoryPoints());

	}

	private void resetRound() {
		super.controller.mountaineerController().clearWasDealtCardThisTurn();
		super.controller.mountaineerController()
				.setTentsHasNotBeenPlacedInThisRound();
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
