package adventOfCode;

import adventOfCode.day21.Solver;
import adventOfCode.submit.Challenge;

public class Day21 implements Challenge {

	@Override
	public String part1(String input) {
		Solver s = new Solver(100, input);
		return String.valueOf(s.leastGoldNeeded());
	}

	@Override
	public String part2(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
