package gameState;

import instances.Instances;
import model.Space;
import cards.Card;
import controller.Controller;
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

}
