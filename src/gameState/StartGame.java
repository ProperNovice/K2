package gameState;

import enums.Dimensions;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		System.out.println(Dimensions.CARD_GAME.x());
		
	}

}
