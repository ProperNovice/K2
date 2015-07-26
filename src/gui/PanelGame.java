package gui;

import instances.Instances;
import utils.Parent;
import controller.Controller;

public class PanelGame extends Parent {

	private Panel panel = null;

	public PanelGame(Panel panel) {

		this.panel = panel;
		Instances.setPanelGameInstance(this);
		new Controller();

	}

	public void restartGame() {
		this.panel.restartGame();
	}

}
