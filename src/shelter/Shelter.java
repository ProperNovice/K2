package shelter;

import mountaineers.Mountaineer;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Timer;
import utils.Timer.TimerInterface;
import enums.Dimensions;

public class Shelter implements TimerInterface, EventHandlerAble {

	private ImageView shelter = null;
	private Mountaineer mountaineer = null;
	private double startingX, startingY;
	private Timer timer = new Timer(2000, this);

	public Shelter(Mountaineer mountaineer) {
		this.mountaineer = mountaineer;
	}

	protected void createShelter(String path) {

		path = "/shelters/" + path + "/"
				+ this.mountaineer.getMountaineerEnum().fileName() + ".png";
		this.shelter = new ImageView(path);
		this.shelter.setWidth(Dimensions.TENT_GAME.x());
		this.shelter.setEventHandler(new EventHandler(this));

	}

	public void relocate(double x, double y) {
		this.startingX = x;
		this.startingY = y;
		this.shelter.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.shelter, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public void animateToStartingPositionSynchronous() {
		Animation.animate(this.shelter, this.startingX, this.startingY,
				AnimationSynch.SYNCHRONOUS);
	}

	@Override
	public void handleMouseEntered() {

		if (!this.mountaineer.hasPlacedHisTent())
			return;

		this.shelter.setVisible(false);
		this.timer.startTimer();

	}

	@Override
	public void fireEvent() {
		this.timer.stopTimer();
		this.shelter.setVisible(true);

	}

}
