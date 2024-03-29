package controller;

import instances.Instances;
import interfaces.SaveAble;
import utils.ArrayList;

public class SaveGameController {

	private ArrayList<SaveAble> arrayList = new ArrayList<>();
	private Controller controller = Instances.getControllerInstance();

	public SaveGameController() {

		Controller controller = Instances.getControllerInstance();

		this.arrayList.add(controller.cardController());
		this.arrayList.add(controller.riskTokenController());
		this.arrayList.add(controller.mountaineerController());

	}

	public void saveTurn() {

		for (SaveAble saveAble : this.arrayList)
			saveAble.saveState();

	}

	public void loadTurn() {

		for (SaveAble saveAble : this.arrayList)
			saveAble.loadState();

	}

	public void resetTurn() {

		this.controller.mountaineerController().clearWasDealtCardThisTurn();
		this.controller.mountaineerController()
				.setTentsHasNotBeenPlacedInThisRound();
		this.controller.weatherTileController().hideWeatherTiles();
		this.controller.gameStateController()
				.setApplyRiskTokenFirstTimeRunningTrue();

	}

}
