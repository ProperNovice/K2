package controller;

import instances.Instances;
import maps.Map;
import maps.MapEasy;
import utils.Executor;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private SpaceController spaceController = null;
	private Map map = null;

	public Controller() {

		createInstances();
		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.spaceController = new SpaceController();
		this.map = new MapEasy();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public SpaceController spaceController() {
		return this.spaceController;
	}

	public Map map() {
		return this.map;
	}

}
