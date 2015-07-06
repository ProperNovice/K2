package gameState;

import utils.Lock;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.cardController()
				.addThreeCardsFromDeckToHandRearrangeSynchronous();

		Lock.lock();

		System.out.println("yay");

	}

}
