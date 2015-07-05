package controller;

import instances.Instances;
import maps.Map;
import maps.MapEasy;
import model.Deck;
import utils.Executor;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private Map map = null;
	private MountaineerController mountaineerController = null;
	private Deck deck = null;
	private RiskTokenController riskTokenController = null;

	public Controller() {

		createInstances();
		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.map = new MapEasy();
		this.mountaineerController = new MountaineerController(
				this.map.getStartingSpace());
		this.deck = new Deck();
		this.riskTokenController = new RiskTokenController();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public Map map() {
		return this.map;
	}

	public MountaineerController mountaineerController() {
		return this.mountaineerController;
	}

	public Deck deck() {
		return this.deck;
	}

	public RiskTokenController riskTokenController() {
		return this.riskTokenController;
	}

}
