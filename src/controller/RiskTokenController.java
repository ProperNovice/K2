package controller;

import utils.Animation.AnimationSynch;
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
	private ArrayList<RiskToken> discard = new ArrayList<>();

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

	public void addTokensFromDeckToPlayRearrange(AnimationSynch animationSynch) {

		int tokensToAdd = 3 - this.play.size();

		for (int counter = 1; counter <= tokensToAdd; counter++)
			this.play.add(this.deck.removeRandom());

		rearrangeRiskTokensDeck(animationSynch);
		rearrangeRiskTokensPlay(animationSynch);

	}

	private void rearrangeRiskTokensDeck(AnimationSynch animationSynch) {

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
			riskToken.animate(coordinate.getX(), coordinate.getY(),
					animationSynch);

		}

	}

	private void rearrangeRiskTokensPlay(AnimationSynch animationSynch) {

		ArrayList<RiskToken> playTemp = new ArrayList<>(this.play);
		this.play.clear();

		while (!playTemp.isEmpty()) {

			RiskToken riskTokenToAdd = playTemp.removeFirst();
			int riskTokenToAddValue = riskTokenToAdd.getValue();
			int indexToAdd = -1;

			for (RiskToken tokenTemp : this.play) {

				int tokenValue = tokenTemp.getValue();

				if (tokenValue >= riskTokenToAddValue)
					continue;

				indexToAdd = this.play.indexOf(tokenTemp);
				break;

			}

			if (indexToAdd == -1)
				this.play.add(riskTokenToAdd);
			else
				this.play.add(indexToAdd, riskTokenToAdd);

		}

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
			riskToken.animate(coordinate.getX(), coordinate.getY(),
					animationSynch);

		}

	}

	public boolean playContains(RiskToken riskToken) {
		return this.play.contains(riskToken);
	}

	public void addRiskTokenFromPlayToDiscardAnimateAsynchronous(
			RiskToken riskToken) {

		this.play.remove(riskToken);
		this.discard.add(riskToken);
		riskToken.animate(Coordinates.RISK_TOKEN_DISCARD_PILE.x(),
				Coordinates.RISK_TOKEN_DISCARD_PILE.y(),
				AnimationSynch.ASYNCHRONOUS);

	}

	public int getLastRiskTokenPlayedValue() {
		return this.discard.getLast().getValue();
	}

}
