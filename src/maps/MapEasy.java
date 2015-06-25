package maps;

import model.SpaceBuilder;
import enums.AltitudeZone;
import enums.SpaceSize;

public class MapEasy extends Map {

	public MapEasy() {

		super.path = "easy";
		super.createMap();

	}

	@Override
	protected void createSpaces() {

		// 0

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(636, 1332).spaceSize(SpaceSize.BIG)
				.create());

		// 1

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(819, 1332).spaceSize(SpaceSize.BIG)
				.create());

		// 2

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(546, 1219).spaceSize(SpaceSize.BIG)
				.create());

		// 3

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(423, 1143).spaceSize(SpaceSize.BIG)
				.create());

		// 4

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(274, 1129).spaceSize(SpaceSize.BIG)
				.create());

		// 5

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(466, 1340).spaceSize(SpaceSize.BIG)
				.create());

		// 6

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(334, 1276).spaceSize(SpaceSize.BIG)
				.create());

		// 7

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(189, 1247).spaceSize(SpaceSize.BIG)
				.create());

		// 8

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(1).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(44, 1244).spaceSize(SpaceSize.BIG)
						.create());

		// 9

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(43, 1104).spaceSize(SpaceSize.BIG)
						.create());

		// 10

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(0).victoryPoints(1)
				.altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(77, 971).spaceSize(SpaceSize.BIG).create());

		// 11

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(244, 993).spaceSize(SpaceSize.BIG)
						.create());

		// 12

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(1)
						.altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(390, 972).spaceSize(SpaceSize.BIG)
						.create());

		// 13

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(346, 823).spaceSize(SpaceSize.BIG)
						.create());

		// 14

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(-1).victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(454, 727).spaceSize(SpaceSize.BIG)
						.create());

		// 15

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(535, 617).spaceSize(SpaceSize.BIG)
						.create());

		// 16

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(199, 853).spaceSize(SpaceSize.BIG)
						.create());

		// 17

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(0).victoryPoints(2)
				.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
				.topLeftCoordinates(41, 813).spaceSize(SpaceSize.BIG).create());

		// 18

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(169, 716).spaceSize(SpaceSize.BIG)
						.create());

		// 19

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(322, 627).spaceSize(SpaceSize.BIG)
						.create());

		// 20

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-1).victoryPoints(4)
				.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
				.topLeftCoordinates(58, 621).spaceSize(SpaceSize.BIG).create());

		// 21

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-1).victoryPoints(5)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(579, 487).spaceSize(SpaceSize.SMALL)
				.create());

		// 22

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-2).victoryPoints(6)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(561, 355).spaceSize(SpaceSize.SMALL)
				.create());

		// 23

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-1).victoryPoints(5)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(204, 524).spaceSize(SpaceSize.SMALL)
				.create());

		// 24

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-1).victoryPoints(5)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(326, 448).spaceSize(SpaceSize.SMALL)
				.create());

		// 25

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-1).victoryPoints(6)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(389, 335).spaceSize(SpaceSize.SMALL)
				.create());

		// 26

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-2).victoryPoints(7)
				.altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(488, 219).spaceSize(SpaceSize.SMALL)
				.create());

		// 27

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-2).victoryPoints(10)
				.altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(462, 97).spaceSize(SpaceSize.SMALL)
				.create());

	}

}
