package controller;

import utils.ArrayList;
import cards.Card;
import cards.CardAcclimatization;
import cards.CardMovement;
import cards.CardRope;
import enums.Coordinates;
import enums.Dimensions;

public class CardController {

	private ArrayList<Card> cardSequenceDefault = new ArrayList<>();
	private ArrayList<Card> deck = null;
	private ArrayList<Card> hand = new ArrayList<>();

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

		this.deck = this.cardSequenceDefault.clone();

	}

	private void relocateDeck() {

		int cardsEachRow = 9;
		int cardsRelocated = 0;

		double x = Coordinates.DECK.x();
		double y = Coordinates.DECK.y();

		for (Card card : this.deck) {

			card.relocate(x, y);

			cardsRelocated++;

			x += Dimensions.CARD_GAME.x()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

			if (cardsRelocated < cardsEachRow)
				continue;

			cardsRelocated = 0;

			x = Coordinates.DECK.x();
			y += Dimensions.CARD_GAME.y()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.y();

		}

	}

	public void addThreeCardsFromDeckToHandRearrangeSynchronous() {

		ArrayList<Card> handTemp = new ArrayList<>(this.hand);
		this.hand.clear();

		for (int counter = 1; counter <= 3; counter++)
			handTemp.add(this.deck.removeRandom());

		for (Card card : this.cardSequenceDefault)
			if (handTemp.contains(card))
				this.hand.add(card);

		rearrangeDeckSynchronous();
		rearrangeHandSynchronous();

	}

	private void rearrangeDeckSynchronous() {

		int cardsEachRow = 9;
		int cardsAnimated = 0;

		double x = Coordinates.DECK.x();
		double y = Coordinates.DECK.y();

		for (Card card : this.deck) {

			card.animateSynchronous(x, y);

			cardsAnimated++;

			x += Dimensions.CARD_GAME.x()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

			if (cardsAnimated < cardsEachRow)
				continue;

			cardsAnimated = 0;

			x = Coordinates.DECK.x();
			y += Dimensions.CARD_GAME.y()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.y();

		}

	}

	private void rearrangeHandSynchronous() {

		double x = Coordinates.HAND.x();
		double y = Coordinates.HAND.y();

		for (Card card : this.hand) {

			card.animateSynchronous(x, y);

			x += Dimensions.CARD_GAME.x()
					+ Dimensions.GAP_BETWEEN_COMPONENTS.x();

		}

	}

}
