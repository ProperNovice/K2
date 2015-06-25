package maps;

import model.SpaceBuilder;
import instances.Instances;
import controller.SpaceController;
import enums.AltitudeZone;
import enums.SpaceSize;

public class MapEasy extends Map {

	public MapEasy() {

		super.path = "easy";
		super.createMap();

	}

	@Override
	protected void createSpaces() {

		SpaceController spaceController = Instances.getControllerInstance()
				.spaceController();

		// 0

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(636, 1332).spaceSize(SpaceSize.BIG)
				.create());

		// 1

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(819, 1332).spaceSize(SpaceSize.BIG)
				.create());

		// 2

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(546, 1219).spaceSize(SpaceSize.BIG)
				.create());

		// 3

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(423, 1143).spaceSize(SpaceSize.BIG)
				.create());

		// 4

		spaceController.addSpace(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(274, 1129).spaceSize(SpaceSize.BIG)
				.create());

		// 5

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(466, 1340).spaceSize(SpaceSize.BIG)
				.create());

		// 6

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(334, 1276).spaceSize(SpaceSize.BIG)
				.create());

		// 7

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(189, 1247).spaceSize(SpaceSize.BIG)
				.create());

		// 8

		spaceController
				.addSpace(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(1).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(44, 1244).spaceSize(SpaceSize.BIG)
						.create());

		// 9

		spaceController
				.addSpace(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(43, 1104).spaceSize(SpaceSize.BIG)
						.create());

		// 10

		spaceController.addSpace(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(0).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(77, 971).spaceSize(SpaceSize.BIG).create());

		// 11

		spaceController
				.addSpace(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(244, 993).spaceSize(SpaceSize.BIG)
						.create());

		// 12

		spaceController
				.addSpace(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(390, 972).spaceSize(SpaceSize.BIG)
						.create());

		// 13

		spaceController
				.addSpace(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(346, 823).spaceSize(SpaceSize.BIG)
						.create());

		// 14

		spaceController
				.addSpace(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(-1).victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(454, 727).spaceSize(SpaceSize.BIG)
						.create());

		// 15

		spaceController
				.addSpace(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(535, 617).spaceSize(SpaceSize.BIG)
						.create());

		// 16

		spaceController
				.addSpace(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(199, 853).spaceSize(SpaceSize.BIG)
						.create());

		// 17

		spaceController.addSpace(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(0).victoryPoints(2)
				.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
				.topLeftCoordinates(41, 813).spaceSize(SpaceSize.BIG).create());

		// 18

		spaceController
				.addSpace(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(169, 716).spaceSize(SpaceSize.BIG)
						.create());

		// 19

		spaceController
				.addSpace(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(322, 627).spaceSize(SpaceSize.BIG)
						.create());

		// 20

		spaceController.addSpace(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-1).victoryPoints(4)
				.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
				.topLeftCoordinates(58, 621).spaceSize(SpaceSize.BIG).create());

	}

}
