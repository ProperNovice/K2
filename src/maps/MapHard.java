package maps;

import space.SpaceBuilder;
import enums.AltitudeZone;
import enums.SpaceSize;

public class MapHard extends Map {

	public MapHard() {

		super.path = "hard";
		super.createMap();

	}

	@Override
	protected void createSpaces() {

		// 0

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(829, 1326).spaceSize(SpaceSize.BIG)
				.create());

		// 1

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(618, 1332).spaceSize(SpaceSize.BIG)
				.create());

		// 2

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(513, 1243).spaceSize(SpaceSize.BIG)
				.create());

		// 3

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(403, 1329).spaceSize(SpaceSize.BIG)
				.create());

		// 4

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(263, 1341).spaceSize(SpaceSize.BIG)
				.create());

		// 5

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(169, 1240).spaceSize(SpaceSize.BIG)
				.create());

		// 6

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(1).maximumMountaineers(2)
						.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(34, 1254).spaceSize(SpaceSize.BIG)
						.create());

		// 7

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(1).maximumMountaineers(2)
						.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(35, 1116).spaceSize(SpaceSize.BIG)
						.create());

		// 8

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(0).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(86, 981).spaceSize(SpaceSize.BIG).create());

		// 9

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(294, 1160).spaceSize(SpaceSize.BIG)
				.create());

		// 10

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(0).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(238, 1018).spaceSize(SpaceSize.BIG)
				.create());

		// 11

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(1).maximumMountaineers(2)
				.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
				.topLeftCoordinates(419, 1073).spaceSize(SpaceSize.BIG)
				.create());

		// 12

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(1).maximumMountaineers(2)
						.victoryPoints(1).altitudeZone(AltitudeZone.UNDER_6000)
						.topLeftCoordinates(535, 995).spaceSize(SpaceSize.BIG)
						.create());

		// 13

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).maximumMountaineers(2)
						.victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(184, 859).spaceSize(SpaceSize.BIG)
						.create());

		// 14

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).maximumMountaineers(2)
						.victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(333, 859).spaceSize(SpaceSize.BIG)
						.create());

		// 15

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).maximumMountaineers(2)
						.victoryPoints(2)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(497, 847).spaceSize(SpaceSize.BIG)
						.create());

		// 16

		super.spaces
				.add(new SpaceBuilder().movementCost(1)
						.acclimatizationIndicator(0).maximumMountaineers(2)
						.victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(636, 827).spaceSize(SpaceSize.BIG)
						.create());

		// 17

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).maximumMountaineers(2)
						.victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(722, 713).spaceSize(SpaceSize.BIG)
						.create());

		// 18

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(0).maximumMountaineers(2)
						.victoryPoints(3)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(348, 720).spaceSize(SpaceSize.BIG)
						.create());

		// 19

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).maximumMountaineers(2)
						.victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(618, 622).spaceSize(SpaceSize.BIG)
						.create());

		// 20

		super.spaces
				.add(new SpaceBuilder().movementCost(2)
						.acclimatizationIndicator(-1).maximumMountaineers(2)
						.victoryPoints(4)
						.altitudeZone(AltitudeZone.BETWEEN_6000_AND_7000)
						.topLeftCoordinates(444, 623).spaceSize(SpaceSize.BIG)
						.create());

		// 21

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-1).maximumMountaineers(1)
				.victoryPoints(4)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(542, 522).spaceSize(SpaceSize.SMALL)
				.create());

		// 22

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-1).maximumMountaineers(1)
				.victoryPoints(5)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(446, 440).spaceSize(SpaceSize.SMALL)
				.create());

		// 23

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-1).maximumMountaineers(1)
				.victoryPoints(6)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(510, 331).spaceSize(SpaceSize.SMALL)
				.create());

		// 24

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(5)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(726, 502).spaceSize(SpaceSize.SMALL)
				.create());

		// 25

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(6)
				.altitudeZone(AltitudeZone.BETWEEN_7000_AND_8000)
				.topLeftCoordinates(727, 362).spaceSize(SpaceSize.SMALL)
				.create());

		// 26

		super.spaces.add(new SpaceBuilder().movementCost(1)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(7).altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(734, 229).spaceSize(SpaceSize.SMALL)
				.create());

		// 27

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(7).altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(598, 223).spaceSize(SpaceSize.SMALL)
				.create());

		// 28

		super.spaces.add(new SpaceBuilder().movementCost(2)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(8).altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(492, 141).spaceSize(SpaceSize.SMALL)
				.create());

		// 29

		super.spaces.add(new SpaceBuilder().movementCost(3)
				.acclimatizationIndicator(-2).maximumMountaineers(1)
				.victoryPoints(10).altitudeZone(AltitudeZone.OVER_8000)
				.topLeftCoordinates(425, 33).spaceSize(SpaceSize.SMALL)
				.create());

	}

	@Override
	protected void createAdjacencies() {

		super.addAdjacentUpUp(0, 1);
		super.addAdjacentUpUp(2, 3);
		super.addAdjacentUpUp(3, 4);
		super.addAdjacentUpUp(4, 5);
		super.addAdjacentUpUp(6, 7);
		super.addAdjacentUpUp(7, 8);
		super.addAdjacentUpUp(5, 9);
		super.addAdjacentUpUp(8, 10);
		super.addAdjacentUpUp(11, 12);
		super.addAdjacentUpUp(8, 13);
		super.addAdjacentUpUp(10, 13);
		super.addAdjacentUpUp(13, 14);
		super.addAdjacentUpUp(14, 15);
		super.addAdjacentUpUp(15, 16);
		super.addAdjacentUpUp(16, 17);
		super.addAdjacentUpUp(14, 18);
		super.addAdjacentUpUp(17, 19);
		super.addAdjacentUpUp(18, 20);
		super.addAdjacentUpUp(21, 22);
		super.addAdjacentUpUp(23, 27);
		super.addAdjacentUpUp(24, 25);
		super.addAdjacentUpUp(26, 27);
		super.addAdjacentUpUp(27, 28);

		super.addAdjacentDownUp(1, 2);
		super.addAdjacentDownUp(5, 6);
		super.addAdjacentDownUp(9, 10);
		super.addAdjacentDownUp(9, 11);
		super.addAdjacentDownUp(15, 18);
		super.addAdjacentDownUp(20, 21);
		super.addAdjacentDownUp(19, 21);
		super.addAdjacentDownUp(19, 24);
		super.addAdjacentDownUp(22, 23);
		super.addAdjacentDownUp(25, 26);
		super.addAdjacentDownUp(28, 29);

	}

}
