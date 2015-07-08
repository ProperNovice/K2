package controller;

import cards.Card;
import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.ChooseCardToPlay;
import gameState.ChooseMountaineerToApplyCard;
import gameState.GameState;
import gameState.StartGame;
import gameState.StartNewRound;
import model.Space;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState animating = new Animating();
	private GameState startNewRound = new StartNewRound();
	private GameState chooseCardToPlay = new ChooseCardToPlay();
	private GameState chooseMountaineerToApplyCard = new ChooseMountaineerToApplyCard();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		case ANIMATING:
			this.currentGameState = this.animating;
			break;

		case START_NEW_ROUND:
			this.currentGameState = this.startNewRound;
			break;

		case CHOOSE_CARD_TO_PLAY:
			this.currentGameState = this.chooseCardToPlay;
			break;

		case CHOOSE_MOUNTAINEER_TO_APPLY_CARD:
			this.currentGameState = this.chooseMountaineerToApplyCard;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		this.currentGameState.handleTextOptionPressed(textEnum);
	}

	public void handleSpacePressed(Space space) {
		this.currentGameState.handleSpacePressed(space);
	}

	public void handleCardPressed(Card card) {
		this.currentGameState.handleCardPressed(card);
	}

}
