package gameState;

import javafx.scene.input.KeyCode;
import utils.Lock;
import cards.Card;
import cards.CardAcclimatization;
import cards.CardMovement;
import cards.CardRope;
import enums.GameStateEnum;
import enums.KeyCodeEnum;
import enums.MountaineerEnum;
import enums.RopeMovement;
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

		super.controller.mountaineerController().setDealtCardThisTurn(
				mountaineerEnum);

		Card cardLastPlayed = super.controller.cardController()
				.getLastCardPlayed();

		if (cardLastPlayed instanceof CardAcclimatization)
			addAcclimatizationToMountaineer(mountaineerEnum,
					(CardAcclimatization) cardLastPlayed);

		else if (cardLastPlayed instanceof CardMovement)
			handleCardMovement(mountaineerEnum, (CardMovement) cardLastPlayed);

		else if (cardLastPlayed instanceof CardRope)
			handleCardRope(mountaineerEnum, (CardRope) cardLastPlayed);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode.equals(KeyCodeEnum.FIRST_OPTION.keyCode()))
			handleTextOptionPressed(TextEnum.MOUNTAINEER_I);

		else if (keyCode.equals(KeyCodeEnum.SECOND_OPTION.keyCode()))
			handleTextOptionPressed(TextEnum.MOUNTAINEER_II);

	}

	private void addAcclimatizationToMountaineer(
			MountaineerEnum mountaineerEnum,
			CardAcclimatization cardAcclimatization) {

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		int acclimatization = cardAcclimatization.getAcclimatization();

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateSynchronous(
						mountaineerEnum, acclimatization);

		Lock.lock();

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

	private void handleCardRope(MountaineerEnum mountaineerEnum,
			CardRope cardRope) {

		RopeMovement ropeMovementPlayedAs = super.controller.cardController()
				.getRopeMovementPlayedAs();
		int movement = -1;

		switch (ropeMovementPlayedAs) {

		case UP:

			movement = cardRope.getMovementUp();
			super.controller.mountaineerController()
					.addMovementRopeUpToMountaineer(mountaineerEnum, movement);
			break;

		case DOWN:

			movement = cardRope.getMovementDown();
			super.controller
					.mountaineerController()
					.addMovementRopeDownToMountaineer(mountaineerEnum, movement);
			break;

		}

		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_CARD_TO_PLAY);

	}

	@Override
	public boolean restartButtonIsVisible() {
		return true;
	}

}
