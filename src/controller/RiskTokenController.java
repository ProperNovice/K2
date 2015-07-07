package controller;

import utils.ArrayList;
import utils.Coordinate;
import utils.CoordinatesRelocate;
import utils.CoordinatesRelocateBuilder;

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

		double topLeftX = Coordinates.RISK_TOKEN_PILE.x();
		double topLeftY = Coordinates.RISK_TOKEN_PILE.y();
		double width = Dimensions.RISK_TOKEN_GAME.x();
		double height = Dimensions.RISK_TOKEN_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();
		int nodesPerRow = 10;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		for (RiskToken riskToken : this.deck) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			riskToken.relocate(coordinate.getX(), coordinate.getY());

		}

	}

	public void addTokensFromDeckToPlayRearrangeSynchronous() {

		int numberOfTokensToAdd = 1;

		if (this.play.isEmpty())
			numberOfTokensToAdd = 3;

	}

}
