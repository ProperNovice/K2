package gameState;

import utils.Lock;
import model.Space;
import mountaineers.Mountaineer;
import enums.AltitudeZone;
import enums.GameStateEnum;
import enums.MountaineerEnum;

public class EndTurn extends GameState {

	private boolean animationExecuted = false;

	@Override
	public void handleGameStateChange() {

		handleMountaineerAcclimatization(MountaineerEnum.I);
		handleMountaineerAcclimatization(MountaineerEnum.II);

		if (this.animationExecuted)
			Lock.lock();

		this.animationExecuted = false;
		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void handleMountaineerAcclimatization(
			MountaineerEnum mountaineerEnum) {

		Mountaineer mountaineer = super.controller.mountaineerController()
				.getMountaineer(mountaineerEnum);

		Space space = mountaineer.getMountaineerSpace();
		AltitudeZone altitudeZone = space.getAltitudeZone();

		int acclimatizationIndicatorSpace = space.getAcclimatizationIndicator();
		int acclimatizationIndicatorAltitudeZone = super.controller
				.weatherTileController().getAcclimatizationWithAltitude(
						altitudeZone);

		int totalAcclimatization = acclimatizationIndicatorSpace
				+ acclimatizationIndicatorAltitudeZone;

		if (totalAcclimatization == 0)
			return;

		this.animationExecuted = true;

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateSynchronous(
						mountaineerEnum, totalAcclimatization);

	}

}
