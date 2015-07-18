package gameState;

import model.Space;
import mountaineers.Mountaineer;
import utils.Lock;
import enums.AltitudeZone;
import enums.GameStateEnum;
import enums.MountaineerEnum;
import enums.TextEnum;

public class MountaineerMovement extends GameState {

	private Mountaineer mountaineerMoving = null;

	@Override
	public void handleGameStateChange() {

		this.mountaineerMoving = super.controller.mountaineerController()
				.getMountaineerMoving();

		MountaineerEnum mountaineerEnum = this.mountaineerMoving
				.getMountaineerEnum();
		TextEnum textEnum = null;

		if (mountaineerEnum.equals(MountaineerEnum.I))
			textEnum = TextEnum.MOVE_MOUNTAINEER_I;

		else if (mountaineerEnum.equals(MountaineerEnum.II))
			textEnum = TextEnum.MOVE_MOUNTAINEER_II;

		super.controller.textController().showText(textEnum);

		if (tentCanBePlaced())
			super.controller.textController().showText(TextEnum.PLACE_TENT);

		super.controller.textController().showText(TextEnum.CONTINUE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		switch (textEnum) {

		case CONTINUE:
			this.mountaineerMoving.resetMovement();
			break;

		case PLACE_TENT:
			handlePlaceTentAnimateSynchronous();
			Lock.lock();
			break;

		default:
			break;

		}

		setNewGameState();

	}

	@Override
	public void handleSpacePressed(Space space) {

		super.controller.textController().concealText();

		Space mountaineerCurrentSpace = this.mountaineerMoving
				.getMountaineerSpace();

		if (mountaineerCurrentSpace.isAdjacentUp(space)) {

			int movementRopeUp = this.mountaineerMoving.getMovementRopeUp();
			int movement = this.mountaineerMoving.getMovement();

			AltitudeZone altitudeZone = space.getAltitudeZone();
			int movementToEnterSpace = space.getMovementCost()
					+ super.controller.weatherTileController()
							.getMovementToEnterSpaceWithAltitude(altitudeZone);

			if (movementToEnterSpace > movement + movementRopeUp) {
				setNewGameState();
				return;
			}

			super.controller.gameStateController().setGameState(
					GameStateEnum.ANIMATING);

			super.controller.mountaineerController().animateMountaineerToSpace(
					this.mountaineerMoving, space);

			this.mountaineerMoving.setMountaineerSpace(space);

			if (movementRopeUp >= movementToEnterSpace)
				this.mountaineerMoving
						.addMovementRopeUpPanelMovementUpdate(-movementToEnterSpace);

			else {

				movementToEnterSpace -= movementRopeUp;
				this.mountaineerMoving
						.addMovementRopeUpPanelMovementUpdate(-this.mountaineerMoving
								.getMovementRopeUp());
				this.mountaineerMoving
						.addMovementPanelMovementUpdate(-movementToEnterSpace);

			}

			Lock.lock();

			setNewGameState();

		} else if (space.isAdjacentUp(mountaineerCurrentSpace)) {

			int movementRopeUpDown = this.mountaineerMoving
					.getMovementRopeDown();
			int movement = this.mountaineerMoving.getMovement();

			AltitudeZone altitudeZone = space.getAltitudeZone();
			int movementToEnterSpace = space.getMovementCost()
					+ super.controller.weatherTileController()
							.getMovementToEnterSpaceWithAltitude(altitudeZone);

			if (movementToEnterSpace > movement + movementRopeUpDown) {
				setNewGameState();
				return;
			}

			super.controller.gameStateController().setGameState(
					GameStateEnum.ANIMATING);

			super.controller.mountaineerController().animateMountaineerToSpace(
					this.mountaineerMoving, space);

			this.mountaineerMoving.setMountaineerSpace(space);

			if (movementRopeUpDown >= movementToEnterSpace)
				this.mountaineerMoving
						.addMovementRopeDownPanelMovementUpdate(-movementToEnterSpace);

			else {

				movementToEnterSpace -= movementRopeUpDown;
				this.mountaineerMoving
						.addMovementRopeDownPanelMovementUpdate(-this.mountaineerMoving
								.getMovementRopeDown());
				this.mountaineerMoving
						.addMovementPanelMovementUpdate(-movementToEnterSpace);

			}

			Lock.lock();

			setNewGameState();

		} else
			super.controller.gameStateController().setGameState(
					GameStateEnum.MOUNTAINEER_MOVEMENT);

	}

	private void setNewGameState() {

		if (!super.controller.mountaineerController()
				.atLeastOneMountaineerHasMovementPoint())
			super.controller.gameStateController().setGameState(
					GameStateEnum.END_TURN);

		else
			super.controller.gameStateController().setGameState(
					GameStateEnum.MOUNTAINEER_MOVEMENT);

	}

	private boolean tentCanBePlaced() {

		Space mountaineerSpace = this.mountaineerMoving.getMountaineerSpace();

		if (this.mountaineerMoving.hasPlacedHisTent())
			return false;

		if (mountaineerSpace.containsTent())
			return false;

		int movementMountaineer = this.mountaineerMoving.getMovement()
				+ this.mountaineerMoving.getMovementRopeUp();

		AltitudeZone altitudeZoneSpace = mountaineerSpace.getAltitudeZone();

		int tentCost = mountaineerSpace.getMovementCost()
				+ super.controller.weatherTileController()
						.getMovementToEnterSpaceWithAltitude(altitudeZoneSpace);

		if (movementMountaineer < tentCost)
			return false;

		return true;

	}

	private void handlePlaceTentAnimateSynchronous() {

		Space mountaineerSpace = this.mountaineerMoving.getMountaineerSpace();
		mountaineerSpace.addTentAnimateSynchronous(this.mountaineerMoving
				.getTentAndSetHasBeenPlaced(mountaineerSpace));

		int movementRopeUp = this.mountaineerMoving.getMovementRopeUp();

		AltitudeZone altitudeZone = mountaineerSpace.getAltitudeZone();

		int tentCost = mountaineerSpace.getMovementCost()
				+ super.controller.weatherTileController()
						.getMovementToEnterSpaceWithAltitude(altitudeZone);

		super.controller.gameStateController().setGameState(
				GameStateEnum.ANIMATING);

		if (movementRopeUp >= tentCost)
			this.mountaineerMoving
					.addMovementRopeUpPanelMovementUpdate(-tentCost);

		else {

			tentCost -= movementRopeUp;
			this.mountaineerMoving
					.addMovementRopeUpPanelMovementUpdate(-this.mountaineerMoving
							.getMovementRopeUp());
			this.mountaineerMoving.addMovementPanelMovementUpdate(-tentCost);

		}

	}
}
