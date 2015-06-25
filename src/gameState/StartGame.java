package gameState;

import model.Space;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

	}

	@Override
	public void handleSpacePressed(Space space) {

		System.out.println("move " + space.getMovementCost());
		System.out.println("acc " + space.getAcclimatizationIndicator());
		System.out.println("alt " + space.getAltitudeZone());
		System.out.println("vp " + space.getVictoryPoints());
		System.out.println();

	}

}
