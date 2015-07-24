package gameState;

import mountaineers.Mountaineer;
import space.Space;
import utils.Lock;
import enums.AltitudeZone;
import enums.GameStateEnum;
import enums.MountaineerEnum;
import enums.TextEnum;

public class EndTurn extends GameState {

	private boolean animationExecuted = false;

	@Override
	public void handleGameStateChange() {

		handleMountaineerAcclimatization(MountaineerEnum.I);
		handleMountaineerAcclimatization(MountaineerEnum.II);

		if (this.animationExecuted)
			Lock.lock();

		if (super.controller.mountaineerController()
				.mountaineerPlacementIsLegal())
			super.controller.textController().showText(TextEnum.END_TURN);

		super.controller.textController().showText(TextEnum.RESTART_TURN);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		this.animationExecuted = false;

		super.controller.textController().concealText();

		switch (textEnum) {

		case END_TURN:
			handleNewRound();
			break;

		case RESTART_TURN:
			super.controller.restartButtonController().handleRestartTurn();
			break;

		default:
			break;

		}

	}

	private void handleNewRound() {

		super.controller.gameStateController().setGameState(
				GameStateEnum.START_NEW_ROUND);

	}

	private void handleMountaineerAcclimatization(
			MountaineerEnum mountaineerEnum) {

		Mountaineer mountaineer = super.controller.mountaineerController()
				.getMountaineer(mountaineerEnum);

		int startingMountaineerAcclimatization = mountaineer
				.getAcclimatization();
		int endingMountaineerAcclimatization = mountaineer.getAcclimatization();

		Space space = mountaineer.getMountaineerSpace();
		AltitudeZone altitudeZone = space.getAltitudeZone();

		int acclimatizationIndicatorSpace = space.getAcclimatizationIndicator();
		int acclimatizationIndicatorAltitudeZone = super.controller
				.weatherTileController().getAcclimatizationWithAltitude(
						altitudeZone);

		int totalAcclimatization = acclimatizationIndicatorSpace
				+ acclimatizationIndicatorAltitudeZone;

		if (space.containsTent())
			totalAcclimatization++;

		endingMountaineerAcclimatization += totalAcclimatization;

		endingMountaineerAcclimatization = (int) Math.min(
				endingMountaineerAcclimatization, 6);

		endingMountaineerAcclimatization = (int) Math.max(
				endingMountaineerAcclimatization, 0);

		if (startingMountaineerAcclimatization == endingMountaineerAcclimatization)
			return;

		this.animationExecuted = true;

		int acclimatizationToAdd = endingMountaineerAcclimatization
				- startingMountaineerAcclimatization;

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateSynchronous(
						mountaineerEnum, acclimatizationToAdd);

	}

	public boolean restartButtonIsVisible() {
		return true;
	}

}
