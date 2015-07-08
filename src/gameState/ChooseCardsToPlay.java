package gameState;

import utils.Animation.AnimationSynch;
import cards.Card;
import cards.CardRope;
import enums.GameStateEnum;
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

		super.controller.cardController().addCardFromHandToDiscardAnimate(card,
				AnimationSynch.ASYNCHRONOUS);

		if (card instanceof CardRope) {

		} else
			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_MOUNTAINEER_TO_APPLY_CARD);

	}

}
