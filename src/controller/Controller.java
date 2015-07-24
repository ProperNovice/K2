package controller;

import instances.Instances;
import maps.Map;
import maps.MapEasy;
import maps.MapHard;
import enums.DifficultyMap;
import enums.DifficultyWeather;
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
	private DifficultyOption difficultyOption = null;

	public Controller() {

		createInstances();

		this.gameStateController
				.setGameState(GameStateEnum.CHOOSE_DIFFICULTY_MAP);

	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();

		this.cardController = new CardController();
		this.riskTokenController = new RiskTokenController();
		this.restartButtonController = new RestartButtonController();
		this.cardLeftToChooseController = new CardLeftToChooseController();
		this.difficultyOption = new DifficultyOption();

	}

	public void createMap(DifficultyMap difficultyMap) {

		switch (difficultyMap) {

		case EASY:
			this.map = new MapEasy();
			break;

		case HARD:
			this.map = new MapHard();
			break;

		}

		this.mountaineerController = new MountaineerController(difficultyMap,
				this.map.getStartingSpace());

	}

	public void createWeatherTiles(DifficultyWeather difficultyWeather) {

		this.weatherTileController = new WeatherTileController(
				difficultyWeather);

	}

	public void createSaveGameController() {
		this.saveGameController = new SaveGameController();
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

	public DifficultyOption difficultyOption() {
		return this.difficultyOption;
	}

}
