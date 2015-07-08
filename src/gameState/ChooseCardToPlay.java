package gameState;

import utils.Animation.AnimationSynch;
import cards.Card;
import cards.CardAcclimatization;
import cards.CardRope;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseCardToPlay extends GameState {

	private int cardLeftToChoose = 3;

	@Override
	public void handleGameStateChange() {

		if (this.cardLeftToChoose > 0)
			super.controller.textController().showText(TextEnum.CHOOSE_A_CARD);

	}

	@Override
	protected void handleCardHandPressed(Card card) {

		this.cardLeftToChoose--;
		super.controller.textController().concealText();

		super.controller.cardController().addCardFromHandToDiscardAnimate(card,
				AnimationSynch.ASYNCHRONOUS);

		if (card instanceof CardRope)
			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_ROPE_DIRECTION);

		else if (card instanceof CardAcclimatization
				&& ((CardAcclimatization) card).getAcclimatization() == 0)
			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_CARD_TO_PLAY);

		else
			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_MOUNTAINEER_TO_APPLY_CARD);

	}

}
