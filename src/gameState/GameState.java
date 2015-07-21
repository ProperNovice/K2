package gameState;

import instances.Instances;
import space.Space;
import cards.Card;

import components.RiskToken;

import controller.Controller;
import enums.MountaineerEnum;
import enums.TextEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public void handleGameStateChange() {

	}

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleSpacePressed(Space space) {

	}

	public final void handleCardPressed(Card card) {

		if (this.controller.cardController().handContains(card))
			handleCardHandPressed(card);

	}

	protected void handleCardHandPressed(Card card) {

	}

	public final void handleRiskTokenPressed(RiskToken riskToken) {

		if (this.controller.riskTokenController().playContains(riskToken))
			handleRiskTokenPlayPressed(riskToken);

	}

	protected void handleRiskTokenPlayPressed(RiskToken riskToken) {

	}

	public void handleMinusButtonPressed(Runnable runnable) {

	}

	public void handleAcclimatizationIndicatorPressed(
			MountaineerEnum mountaineerEnum) {

	}

	public final void handleWeatherTilePressed() {
		this.controller.weatherTileController().handleWeatherTilePressed();
	}

	public void handleRestartButtonPressed() {
		this.controller.restartButtonController().handleRestartTurn();
	}

	public boolean restartButtonIsVisible() {
		return false;
	}

}
