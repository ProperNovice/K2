package model;

import cards.Card;
import cards.CardAcclimatization;
import cards.CardMovement;
import cards.CardRope;
import utils.ArrayList;
import enums.Coordinates;
import enums.Dimensions;

public class Deck {

	private ArrayList<Card> deckOriginal = new ArrayList<>();
	private ArrayList<Card> deck = null;

	public Deck() {

		createDeck();
		relocateDeck();

	}

	private void createDeck() {

		this.deckOriginal.add(new CardMovement(3));
		this.deckOriginal.add(new CardMovement(3));
		this.deckOriginal.add(new CardMovement(2));
		this.deckOriginal.add(new CardMovement(2));
		this.deckOriginal.add(new CardMovement(2));
		this.deckOriginal.add(new CardRope(2, 3));
		this.deckOriginal.add(new CardRope(1, 3));
		this.deckOriginal.add(new CardRope(1, 2));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardAcclimatization(3));
		this.deckOriginal.add(new CardAcclimatization(2));
		this.deckOriginal.add(new CardAcclimatization(1));
		this.deckOriginal.add(new CardAcclimatization(1));
		this.deckOriginal.add(new CardAcclimatization(0));

		this.deck = this.deckOriginal.clone();

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

}
