package gameState;

import utils.Animation.AnimationSynch;
import utils.Lock;
import cards.Card;
import enums.GameStateEnum;
import enums.TextEnum;

public class ChooseCardsToPlay extends GameState {

	private int cardLeftToChoose = 3;

	@Override
	public void handleGameStateChange() {

		super.controller.textController()
				.showText(TextEnum.CHOOSE_CARDSTO_PLAY);

	}

	@Override
	protected void handleCardHandPressed(Card card) {

		this.cardLeftToChoose--;

		if (this.cardLeftToChoose > 0)
			handleCardLeftToChooseGreaterThanZero(card);

		else
			handleCardLeftToChooseEqualsZero(card);

	}

	private void handleCardLeftToChooseGreaterThanZero(Card card) {

		super.controller.cardController().addCardFromHandToDiscardAnimate(card,
				AnimationSynch.ASYNCHRONOUS);

	}

	private void handleCardLeftToChooseEqualsZero(Card card) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		this.cardLeftToChoose = 3;

		super.controller.textController().concealText();

		super.controller.cardController().addCardFromHandToDiscardAnimate(card,
				AnimationSynch.SYNCHRONOUS);
		super.controller.cardController().rearrangeHandSynchronous();

		Lock.lock();

	}

}
