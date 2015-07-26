package controller;

public class RoundIndicator {

	private int roundIndicator = 0;

	public RoundIndicator() {

	}

	public void proceedNextRound() {
		this.roundIndicator++;
	}

	public int getRoundIndicator() {
		return this.roundIndicator;
	}

}
