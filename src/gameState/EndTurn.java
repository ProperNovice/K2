package gameState;

import model.Space;
import mountaineers.Mountaineer;
import enums.AltitudeZone;
import enums.MountaineerEnum;

public class EndTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		handleMountaineerAcclimatization(MountaineerEnum.I);
		handleMountaineerAcclimatization(MountaineerEnum.II);

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

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateAsynchronous(
						mountaineerEnum, totalAcclimatization);

	}

}
