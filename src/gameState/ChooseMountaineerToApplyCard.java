package gameState;

import cards.Card;
import cards.CardAcclimatization;
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
			addAcclimatizationToMountaineer(mountaineerEnum, cardLastPlayed);

	}

	private void addAcclimatizationToMountaineer(
			MountaineerEnum mountaineerEnum, Card cardLastPlayed) {

		CardAcclimatization cardAcclimatization = (CardAcclimatization) cardLastPlayed;
		int acclimatization = cardAcclimatization.getAcclimatization();

		super.controller.mountaineerController()
				.addAcclimatizationToMountaineerAnimateAsynchronous(mountaineerEnum,
						acclimatization);

	}

}
