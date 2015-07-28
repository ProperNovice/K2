package gameState;

import utils.Lock;
import utils.Logger;
import enums.GameStateEnum;
import enums.MountaineerEnum;
import enums.TextEnum;

public class ApplyRiskToken extends GameState {

	private int valueLeftToApply;
	private boolean firstTimeRunning = true;

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.APPLY_RISK_TOKEN);

		super.controller.mountaineerController()
				.setAllMinusButtonsVisible(true);

		Logger.logNewLine("first time applying: " + this.firstTimeRunning);

		if (!this.firstTimeRunning)
			return;

		this.firstTimeRunning = false;
		this.valueLeftToApply = super.controller.riskTokenController()
				.getLastRiskTokenPlayedValue();

		logTotalValueLeftToApply();

	}

	@Override
	public void handleMinusButtonPressed(Runnable runnable) {

		super.controller.textController().concealText();

		runnable.run();
		handleValueDecreased();

	}

	@Override
	public void handleAcclimatizationIndicatorPressed(
			MountaineerEnum mountaineerEnum) {

		if (!super.controller.mountaineerController().wasDealtCardThisTurn(
				mountaineerEnum))
			return;

		if (super.controller.mountaineerController()
				.mountaineerAcclimatizationIsZero(mountaineerEnum))
			return;

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.textController().concealText();

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateSynchronous(
						mountaineerEnum, -1);

		Lock.lock();

		handleValueDecreased();

	}

	private void handleValueDecreased() {

		Logger.logNewLine("decreasing risk token value");

		this.valueLeftToApply--;

		logTotalValueLeftToApply();

		if (this.valueLeftToApply > 0) {

			super.controller.gameStateController().setGameState(
					GameStateEnum.APPLY_RISK_TOKEN);
			return;

		}

		this.firstTimeRunning = true;

		super.controller.mountaineerController().setAllMinusButtonsVisible(
				false);

		if (!super.controller.mountaineerController()
				.atLeastOneMountaineerHasMovementPoint())
			super.controller.gameStateController().setGameState(
					GameStateEnum.END_TURN);

		else
			super.controller.gameStateController().setGameState(
					GameStateEnum.MOUNTAINEER_MOVEMENT);

	}

	private void logTotalValueLeftToApply() {
		Logger.logNewLine("value left to apply: " + this.valueLeftToApply);
	}

	@Override
	public boolean restartButtonIsVisible() {
		return true;
	}

	public void setFirstTimeRunningTrue() {
		this.firstTimeRunning = true;
	}

}
