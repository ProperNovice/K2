package controller;

import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.Coordinate;
import utils.CoordinatesRelocate;
import utils.CoordinatesRelocateBuilder;
import cards.Card;
import cards.CardAcclimatization;
import cards.CardMovement;
import cards.CardRope;
import enums.Coordinates;
import enums.Dimensions;
import enums.RopeMovement;

public class CardController {

	private ArrayList<Card> cardSequenceDefault = new ArrayList<>();
	private ArrayList<Card> deck = new ArrayList<>();
	private ArrayList<Card> hand = new ArrayList<>();
	private ArrayList<Card> discard = new ArrayList<>();
	private RopeMovement ropePlayedAs = null;

	public CardController() {

		createDeck();
		relocateDeck();

	}

	private void createDeck() {

		this.cardSequenceDefault.add(new CardMovement(3));
		this.cardSequenceDefault.add(new CardMovement(3));
		this.cardSequenceDefault.add(new CardRope(2, 3));
		this.cardSequenceDefault.add(new CardMovement(2));
		this.cardSequenceDefault.add(new CardMovement(2));
		this.cardSequenceDefault.add(new CardMovement(2));
		this.cardSequenceDefault.add(new CardRope(1, 3));
		this.cardSequenceDefault.add(new CardRope(1, 2));
		this.cardSequenceDefault.add(new CardMovement(1));
		this.cardSequenceDefault.add(new CardMovement(1));
		this.cardSequenceDefault.add(new CardMovement(1));
		this.cardSequenceDefault.add(new CardMovement(1));
		this.cardSequenceDefault.add(new CardMovement(1));
		this.cardSequenceDefault.add(new CardAcclimatization(3));
		this.cardSequenceDefault.add(new CardAcclimatization(2));
		this.cardSequenceDefault.add(new CardAcclimatization(1));
		this.cardSequenceDefault.add(new CardAcclimatization(1));
		this.cardSequenceDefault.add(new CardAcclimatization(0));

		this.deck.addAll(this.cardSequenceDefault);

	}

	private void relocateDeck() {

		double topLeftX = Coordinates.DECK.x();
		double topLeftY = Coordinates.DECK.y();
		double width = Dimensions.CARD_GAME.x();
		double height = Dimensions.CARD_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();
		int nodesPerRow = 9;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		for (Card card : this.deck) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();

			card.relocate(coordinate.getX(), coordinate.getY());

		}

	}

	public void addCardsFromDeckToHandRearrangeSynchronous() {

		int numberOfCards = 6 - this.hand.size();

		for (int counter = 1; counter <= numberOfCards; counter++)
			this.hand.add(this.deck.removeRandom());

		rearrangeDeckSynchronous();
		rearrangeHandSynchronous();

	}

	private void rearrangeDeckSynchronous() {

		double topLeftX = Coordinates.DECK.x();
		double topLeftY = Coordinates.DECK.y();
		double width = Dimensions.CARD_GAME.x();
		double height = Dimensions.CARD_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();
		int nodesPerRow = 9;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		for (Card card : this.deck) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			card.animate(coordinate.getX(), coordinate.getY(),
					AnimationSynch.SYNCHRONOUS);

		}

	}

	public void rearrangeHandSynchronous() {

		double topLeftX = Coordinates.HAND.x();
		double topLeftY = Coordinates.HAND.y();
		double width = Dimensions.CARD_GAME.x();
		double height = Dimensions.CARD_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();
		int nodesPerRow = 3;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		ArrayList<Card> handTemp = new ArrayList<>(this.hand);
		this.hand.clear();

		for (Card card : this.cardSequenceDefault)
			if (handTemp.contains(card))
				this.hand.add(card);

		for (Card card : this.hand) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			card.animate(coordinate.getX(), coordinate.getY(),
					AnimationSynch.SYNCHRONOUS);

		}

	}

	public boolean handContains(Card card) {
		return this.hand.contains(card);
	}

	public void addCardFromHandToDiscardAnimate(Card card,
			AnimationSynch animationSynch) {

		this.hand.remove(card);
		this.discard.add(card);

		card.animate(Coordinates.DISCARD_PILE.x(),
				Coordinates.DISCARD_PILE.y(), animationSynch);

	}

	public Card getLastCardPlayed() {
		return this.discard.getLast();
	}

	public void setRopeMovementPlayAs(RopeMovement ropeMovement) {
		this.ropePlayedAs = ropeMovement;
	}

	public RopeMovement getRopeMovementPlayedAs() {
		return this.ropePlayedAs;
	}

}
