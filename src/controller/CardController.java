package controller;

import interfaces.SaveAble;
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

public class CardController implements SaveAble {

	private ArrayList<Card> cardSequenceDefault = new ArrayList<>();
	private ArrayList<Card> deck = new ArrayList<>();
	private ArrayList<Card> hand = new ArrayList<>();
	private ArrayList<Card> handSave = new ArrayList<>();
	private ArrayList<Card> discard = new ArrayList<>();
	private ArrayList<Card> discardSave = new ArrayList<>();
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

		ArrayList<Card> cardsAdded = new ArrayList<>();

		int numberOfCards = 6 - this.hand.size();

		for (int counter = 1; counter <= numberOfCards; counter++) {

			Card card = this.deck.removeRandom();

			this.hand.add(card);
			cardsAdded.add(card);

		}

		if (!this.deck.isEmpty())
			rearrangeDeckSynchronous();

		rearrangeHandSynchronous(cardsAdded);

	}

	private void rearrangeDeckSynchronous() {

		double topLeftX = Coordinates.DECK.x();
		double topLeftY = Coordinates.DECK.y();
		double width = Dimensions.CARD_GAME.x();
		double height = Dimensions.CARD_GAME.y();
		double gapBetweenNodes = Dimensions.GAP_BETWEEN_COMPONENTS.x();

		int nodesPerRow = this.deck.size() / 2;

		if (this.deck.size() % 2 == 1)
			nodesPerRow++;

		CoordinatesRelocate coordinatesRelocate = new CoordinatesRelocateBuilder()
				.topLeftX(topLeftX).topLeftY(topLeftY).width(width)
				.height(height).gapBetweenNodes(gapBetweenNodes)
				.nodesPerRow(nodesPerRow).create();

		for (Card card : this.deck) {

			Coordinate coordinate = coordinatesRelocate.removeFirst();
			card.animateSynchronous(coordinate.getX(), coordinate.getY());

		}

	}

	public void rearrangeHandSynchronous(ArrayList<Card> cardsNewlyAdded) {

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
			card.animateSynchronous(coordinate.getX(), coordinate.getY());

		}

		for (Card card : cardsNewlyAdded)
			card.toFront();

	}

	public void rearrangeHandSynchronous() {
		rearrangeHandSynchronous(new ArrayList<Card>());
	}

	public boolean handContains(Card card) {
		return this.hand.contains(card);
	}

	public void addCardFromHandToDiscardAnimateSynchronous(Card card) {

		this.hand.remove(card);
		this.discard.add(card);

		card.animateSynchronous(Coordinates.CARD_DISCARD_PILE.x(),
				Coordinates.CARD_DISCARD_PILE.y());

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

	public boolean deckIsEmpty() {
		return this.deck.isEmpty();
	}

	public boolean handIsEmpty() {
		return this.hand.isEmpty();
	}

	public void addCardsFromDiscardToDeckAnimateSynchronous() {

		this.discard.clear();
		this.deck.addAll(this.cardSequenceDefault);
		rearrangeDeckSynchronous();

	}

	@Override
	public void saveState() {

		this.handSave.clear();
		this.handSave.addAll(this.hand);
		this.discardSave.clear();
		this.discardSave.addAll(this.hand);

	}

	@Override
	public void loadState() {

		ArrayList<Card> cardsAdded = new ArrayList<>();

		for (Card card : this.handSave)
			if (!this.hand.contains(card))
				cardsAdded.add(card);

		this.hand.clear();
		this.hand.addAll(this.handSave);
		this.discard.clear();
		this.discard.addAll(this.discardSave);

		rearrangeHandSynchronous(cardsAdded);

	}

	public Card getCardFromHand(int index) {
		return this.hand.get(index);
	}

}
