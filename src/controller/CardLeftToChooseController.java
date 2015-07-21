package controller;

public class CardLeftToChooseController {

	private int cardLeftToChoose = 3;

	public CardLeftToChooseController() {

	}

	public void reduceByOne() {
		this.cardLeftToChoose--;
	}

	public int getCardsLeftToChoose() {
		return this.cardLeftToChoose;
	}

	public void resetCardsLeftToChoose() {
		this.cardLeftToChoose = 3;
	}

}
