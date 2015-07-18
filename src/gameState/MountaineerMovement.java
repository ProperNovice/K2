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
		super.controller.textController().showText(TextEnum.CONTINUE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textController().concealText();

		this.mountaineerMoving.resetMovement();
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

}
