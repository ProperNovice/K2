package gameState;

import utils.Lock;
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
			super.controller.textController().showText(
					TextEnum.CHOOSE_CARD_TO_PLAY);

		else if (this.cardLeftToChoose == 0) {

			this.cardLeftToChoose = 3;

			super.controller.gameStateController().setGameState(
					GameStateEnum.CHOOSE_RISK_TOKEN);

		}

	}

	@Override
	protected void handleCardHandPressed(Card card) {

		this.cardLeftToChoose--;
		super.controller.textController().concealText();

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		super.controller.cardController()
				.addCardFromHandToDiscardAnimateSynchronous(card);

		Lock.lock();

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
