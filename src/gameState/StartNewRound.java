package gameState;

import utils.Lock;
import utils.Logger;
import enums.GameStateEnum;
import enums.MountaineerEnum;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.saveGameController().resetTurn();

		super.controller.roundIndicator().proceedNextRound();
		int currentRound = super.controller.roundIndicator()
				.getRoundIndicator();

		handleCards();

		super.controller.riskTokenController()
				.addTokensFromDeckToPlayRearrangeSynchronous();

		handleWeather(currentRound);

		Lock.lock();

		super.controller.saveGameController().saveTurn();

		if (currentRound > 1)
			if (currentRound % 3 == 1)
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

	private void handleWeather(int currentRound) {

		if (currentRound == 1)
			return;

		super.controller.weatherTileController()
				.proceedToNextTurnAnimateSynchronous();

	}

	@Override
	public boolean restartButtonIsVisible() {
		return true;
	}

}
