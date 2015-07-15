package gameState;

import enums.MountaineerEnum;
import enums.TextEnum;

public class ApplyRiskToken extends GameState {

	private int valueLeftToApply;

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.APPLY_RISK_TOKEN);

		this.valueLeftToApply = super.controller.riskTokenController()
				.getLastRiskTokenPlayedValue();

		super.controller.mountaineerController()
				.setAllMinusButtonsVisible(true);

	}

	@Override
	public void handleMinusButtonPressed(Runnable runnable) {

		runnable.run();
		handleValueDecreased();

	}

	@Override
	public void handleAcclimatizationIndicatorPressed(
			MountaineerEnum mountaineerEnum) {

		if (super.controller.mountaineerController()
				.mountaineerAcclimatizationIsZero(mountaineerEnum))
			return;

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateAsynchronous(
						mountaineerEnum, -1);

		handleValueDecreased();

	}

	private void handleValueDecreased() {

		this.valueLeftToApply--;

		if (this.valueLeftToApply > 0)
			return;

		super.controller.textController().concealText();

		super.controller.mountaineerController().setAllMinusButtonsVisible(
				false);

	}

}
