package gameState;

public class ApplyRiskToken extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.mountaineerController()
				.setAllMinusButtonsVisible(true);

	}

}
