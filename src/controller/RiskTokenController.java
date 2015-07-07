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

		double topLeftX = Coordinates.RISK_TOKEN_DECK.x();
		double topLeftY = Coordinates.RISK_TOKEN_DECK.y();
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

		int tokensToAdd = 3 - this.play.size();

		ArrayList<RiskToken> playTemp = null;
		this.play.clear();

		for (int counter = 1; counter <= tokensToAdd; counter++) {

			RiskToken riskTokenToAdd = this.deck.removeRandom();
			int riskTokenToAddValue = riskTokenToAdd.getValue();

			playTemp = new ArrayList<>(this.play);

			for (RiskToken token : playTemp) {

				int tokenValue = token.getValue();

				if (tokenValue >= riskTokenToAddValue)
					continue;

				int index = this.play.indexOf(token);
				this.play.add(index, riskTokenToAdd);

				break;

			}

			if (!this.play.contains(riskTokenToAdd))
				this.play.add(riskTokenToAdd);

		}

		rearrangeRiskTokensDeck();
		rearrangeRiskTokensPlay();

	}

	private void rearrangeRiskTokensDeck() {

		double topLeftX = Coordinates.RISK_TOKEN_DECK.x();
		double topLeftY = Coordinates.RISK_TOKEN_DECK.y();
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
			riskToken.animateSynchronous(coordinate.getX(), coordinate.getY());

		}

	}

	private void rearrangeRiskTokensPlay() {

		double topLeftX = Coordinates.RISK_TOKEN_PLAY.x();
		double topLeftY = Coordinates.RISK_TOKEN_PLAY.y();
		double width = Dimensions.RISK_TOKEN_GAME.x();
		double height = Dimensions.RISK_TOKEN_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();
		int nodesPerRow = 3;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		for (RiskToken riskToken : this.play) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			riskToken.animateSynchronous(coordinate.getX(), coordinate.getY());

		}

	}

}
