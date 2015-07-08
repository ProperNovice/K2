package gameState;

import cards.Card;
import cards.CardAcclimatization;
import cards.CardMovement;
import enums.GameStateEnum;
import enums.MountaineerEnum;
import enums.TextEnum;

public class ChooseMountaineerToApplyCard extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.MOUNTAINEER_I);
		super.controller.textController().showText(TextEnum.MOUNTAINEER_II);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		MountaineerEnum mountaineerEnum = null;

		switch (textEnum) {

		case MOUNTAINEER_I:
			mountaineerEnum = MountaineerEnum.I;
			break;

		case MOUNTAINEER_II:
			mountaineerEnum = MountaineerEnum.II;
			break;

		default:
			break;

		}

		Card cardLastPlayed = super.controller.cardController()
				.getLastCardPlayed();

		if (cardLastPlayed instanceof CardAcclimatization)
			addAcclimatizationToMountaineer(mountaineerEnum,
					(CardAcclimatization) cardLastPlayed);

		else if (cardLastPlayed instanceof CardMovement)
			handleCardMovement(mountaineerEnum, (CardMovement) cardLastPlayed);

	}

	private void addAcclimatizationToMountaineer(
			MountaineerEnum mountaineerEnum,
			CardAcclimatization cardAcclimatization) {

		int acclimatization = cardAcclimatization.getAcclimatization();

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateAsynchronous(
						mountaineerEnum, acclimatization);

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

	private void handleCardMovement(MountaineerEnum mountaineerEnum,
			CardMovement cardMovement) {

		int movement = cardMovement.getMovement();

		super.controller.mountaineerController().addMovementToMountaineer(
				mountaineerEnum, movement);

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

}
