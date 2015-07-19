package gameState;

import javafx.application.Platform;
import utils.Executor;
import utils.Lock;
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

		if (!this.firstTimeRunning)
			return;

		this.firstTimeRunning = false;
		this.valueLeftToApply = super.controller.riskTokenController()
				.getLastRiskTokenPlayedValue();

	}

	@Override
	public void handleMinusButtonPressed(Runnable runnable) {

		super.controller.textController().concealText();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				runnable.run();
				handleValueDecreased();

			}
		});

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

		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateSynchronous(
						mountaineerEnum, -1);

		Lock.lock();

		handleValueDecreased();

	}

	private void handleValueDecreased() {

		this.valueLeftToApply--;

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
			Executor.runLater(() -> super.controller.gameStateController()
					.setGameState(GameStateEnum.END_TURN));

		else
			Executor.runLater(() -> super.controller.gameStateController()
					.setGameState(GameStateEnum.MOUNTAINEER_MOVEMENT));

	}

}
