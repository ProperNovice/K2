package controller;

import utils.ArrayList;

import components.RiskToken;

import enums.Coordinates;
import enums.Dimensions;

public class RiskTokenController {

	private ArrayList<RiskToken> deck = new ArrayList<>();
	private ArrayList<RiskToken> play = new ArrayList<>();

	public RiskTokenController() {

		createRiskTokens();
		relocateRiskTokens();

	}

	private void createRiskTokens() {

		addRiskTokensToList(2, 5);
		addRiskTokensToList(1, 11);
		addRiskTokensToList(0, 4);

	}

	private void addRiskTokensToList(int value, int times) {

		for (int counter = 1; counter <= times; counter++)
			this.deck.add(new RiskToken(value));

	}

	private void relocateRiskTokens() {

		int tokensEachRow = 10;
		int tokensRelocated = 0;

		double x = Coordinates.RISK_TOKEN_PILE.x();
		double y = Coordinates.RISK_TOKEN_PILE.y();

		for (RiskToken riskToken : this.deck) {

			riskToken.relocate(x, y);

			tokensRelocated++;

			if (tokensRelocated < tokensEachRow) {

				x += Dimensions.RISK_TOKEN_GAME.x()
						+ Dimensions.GAP_BETWEEN_COMPONENTS.x();
				continue;

			}

			tokensRelocated = 0;

			x = Coordinates.RISK_TOKEN_PILE.x();
			y += Dimensions.RISK_TOKEN_GAME.y()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.y();

		}

	}

	public void addTokensFromDeckToPlayRearrangeSynchronous() {

		int numberOfTokensToAdd = 1;

		if (this.play.isEmpty())
			numberOfTokensToAdd = 3;

	}

}
