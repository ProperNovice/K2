package controller;

import enums.GameStateEnum;
import enums.MountaineerEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.ApplyRiskToken;
import gameState.ChooseCardToPlay;
import gameState.ChooseDifficultyMap;
import gameState.ChooseDifficultyWeather;
import gameState.ChooseMountaineerToApplyCard;
import gameState.ChooseRiskToken;
import gameState.ChooseRopeDirection;
import gameState.EndGame;
import gameState.EndTurn;
import gameState.GameState;
import gameState.MountaineerMovement;
import gameState.StartGame;
import gameState.StartNewRound;
import instances.Instances;
import javafx.scene.input.KeyCode;
import space.Space;
import utils.Logger;
import cards.Card;

import components.RiskToken;

public class GameStateController {

	private GameState currentGameState = new GameState();
	private GameState startGame = new StartGame();
	private GameState animating = new Animating();
	private GameState chooseDifficultyMap = new ChooseDifficultyMap();
	private GameState chooseDifficultyWeather = new ChooseDifficultyWeather();
	private GameState startNewRound = new StartNewRound();
	private GameState chooseCardToPlay = new ChooseCardToPlay();
	private GameState chooseMountaineerToApplyCard = new ChooseMountaineerToApplyCard();
	private GameState chooseRopeDirection = new ChooseRopeDirection();
	private GameState chooseRiskToken = new ChooseRiskToken();
	private GameState applyRiskToken = new ApplyRiskToken();
	private GameState mountaineerMovement = new MountaineerMovement();
	private GameState endTurn = new EndTurn();
	private GameState endGame = new EndGame();

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

		case CHOOSE_DIFFICULTY_MAP:
			this.currentGameState = this.chooseDifficultyMap;
			break;

		case CHOOSE_DIFFICULTY_WEATHER:
			this.currentGameState = this.chooseDifficultyWeather;
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

		case CHOOSE_ROPE_DIRECTION:
			this.currentGameState = this.chooseRopeDirection;
			break;

		case CHOOSE_RISK_TOKEN:
			this.currentGameState = this.chooseRiskToken;
			break;

		case APPLY_RISK_TOKEN:
			this.currentGameState = this.applyRiskToken;
			break;

		case MOUNTAINEER_MOVEMENT:
			this.currentGameState = this.mountaineerMovement;
			break;

		case END_TURN:
			this.currentGameState = this.endTurn;
			break;

		case END_GAME:
			this.currentGameState = this.endGame;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

		Instances.getControllerInstance().restartButtonController()
				.setVisible(this.currentGameState.restartButtonIsVisible());

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

	public final void handleRiskTokenPressed(RiskToken riskToken) {
		this.currentGameState.handleRiskTokenPressed(riskToken);
	}

	public void handleMinusButtonPressed(Runnable runnable) {
		this.currentGameState.handleMinusButtonPressed(runnable);
	}

	public void handleAcclimatizationIndicatorPressed(
			MountaineerEnum mountaineerEnum) {
		this.currentGameState
				.handleAcclimatizationIndicatorPressed(mountaineerEnum);
	}

	public final void handleWeatherTilePressed() {
		this.currentGameState.handleWeatherTilePressed();
	}

	public void handleRestartButtonPressed() {
		this.currentGameState.handleRestartButtonPressed();
	}

	public void handleKeyPressed(KeyCode keyCode) {
		this.currentGameState.handleKeyPressed(keyCode);
	}

	public boolean restartButtonIsVisible() {
		return this.currentGameState.restartButtonIsVisible();
	}

}
