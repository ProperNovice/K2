package controller;

import instances.Instances;
import maps.Map;
import maps.MapEasy;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private Map map = null;
	private MountaineerController mountaineerController = null;
	private CardController cardController = null;
	private RiskTokenController riskTokenController = null;
	private WeatherTileController weatherTileController = null;
	private SaveGameController saveGameController = null;
	private RestartButtonController restartButtonController = null;
	private CardLeftToChooseController cardLeftToChooseController = null;

	public Controller() {

		createInstances();

		this.gameStateController.setGameState(GameStateEnum.START_GAME);

	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.map = new MapEasy();
		this.mountaineerController = new MountaineerController(
				this.map.getStartingSpace());
		this.cardController = new CardController();
		this.riskTokenController = new RiskTokenController();
		this.weatherTileController = new WeatherTileController();
		this.saveGameController = new SaveGameController();
		this.restartButtonController = new RestartButtonController();
		this.cardLeftToChooseController = new CardLeftToChooseController();

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

	public CardController cardController() {
		return this.cardController;
	}

	public RiskTokenController riskTokenController() {
		return this.riskTokenController;
	}

	public WeatherTileController weatherTileController() {
		return this.weatherTileController;
	}

	public SaveGameController saveGameController() {
		return this.saveGameController;
	}

	public RestartButtonController restartButtonController() {
		return this.restartButtonController;
	}

	public CardLeftToChooseController cardLeftToChooseController() {
		return this.cardLeftToChooseController;
	}

}
