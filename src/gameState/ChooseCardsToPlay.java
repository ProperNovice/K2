package gameState;

import cards.Card;
import enums.TextEnum;

public class ChooseCardsToPlay extends GameState {

	private int cardLeftToChoose = 3;

	@Override
	public void handleGameStateChange() {

		if (this.cardLeftToChoose > 0)
			super.controller.textController().showText(
					TextEnum.CHOOSE_CARDSTO_PLAY);

	}

	@Override
	protected void handleCardHandPressed(Card card) {

		this.cardLeftToChoose--;
		super.controller.textController().concealText();

	}

}
