package gameState;

import model.Space;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

	}

	@Override
	public void handleSpacePressed(Space space) {

		space.print();

	}

}
