package cards;

public class CardAcclimatization extends Card {

	private int acclimatization;

	public CardAcclimatization(int acclimatization) {

		this.acclimatization = acclimatization;
		super.path = "acclimatization" + Integer.toString(this.acclimatization);
		super.createImage();

	}

	public int getAcclimatization() {
		return this.acclimatization;
	}

}
