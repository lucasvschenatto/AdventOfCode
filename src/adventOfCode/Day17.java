package adventOfCode;

import adventOfCode.day17.Reservatory;
import adventOfCode.submit.Challenge;

public class Day17 implements Challenge{
	private static int EGGNOG = 150;

	@Override
	public String part1(String containers) {
		int result = new Reservatory(EGGNOG,containers).waysToFit();
		return String.valueOf(result);
	}

	@Override
	public String part2(String containers) {
		int result = new Reservatory(EGGNOG,containers).waysWithMinimum();
		return String.valueOf(result);
	}

}
