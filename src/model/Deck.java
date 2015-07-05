package model;

import java.util.ArrayList;

import cards.CardAcclimatization;
import cards.Card;
import cards.CardMovement;
import cards.CardRope;

public class Deck {

	private ArrayList<Card> deckOriginal = new ArrayList<>();

	public Deck() {

		createDeck();

	}

	private void createDeck() {

		this.deckOriginal.add(new CardMovement(3));
		this.deckOriginal.add(new CardMovement(3));
		this.deckOriginal.add(new CardMovement(2));
		this.deckOriginal.add(new CardMovement(2));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardMovement(1));
		this.deckOriginal.add(new CardRope(2, 3));
		this.deckOriginal.add(new CardRope(1, 3));
		this.deckOriginal.add(new CardRope(1, 2));
		this.deckOriginal.add(new CardAcclimatization(3));
		this.deckOriginal.add(new CardAcclimatization(2));
		this.deckOriginal.add(new CardAcclimatization(1));
		this.deckOriginal.add(new CardAcclimatization(1));
		this.deckOriginal.add(new CardAcclimatization(0));

	}

}
