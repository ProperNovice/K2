package components;

import utils.Logger;

public class CardAcclimatization extends Card {

	private int acclimatization;

	public CardAcclimatization(int acclimatization) {

		this.acclimatization = acclimatization;
		super.path = "acclimatization" + this.acclimatization;
		super.createImage();

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("acclimatization " + this.acclimatization);

	}

	public int getAcclimatization() {
		return this.acclimatization;
	}

}
