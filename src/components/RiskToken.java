package components;

import instances.Instances;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.ImageView;
import utils.Logger;
import enums.Dimensions;

public class RiskToken implements EventHandlerAble {

	private int value;
	private ImageView imageView = null;

	public RiskToken(int value) {

		this.value = value;
		createImageView();

		this.imageView.setEventHandler(new EventHandler(this));

	}

	private void createImageView() {

		this.imageView = new ImageView("riskTokens/" + this.value + ".png");
		this.imageView.setWidth(Dimensions.RISK_TOKEN_GAME.x());

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("risk token " + this.value);

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().handleRiskTokenPressed(this));

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public int getValue() {
		return this.value;
	}

}
