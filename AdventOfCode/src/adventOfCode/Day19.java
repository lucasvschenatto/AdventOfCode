package adventOfCode;

import adventOfCode.day19.NuclearFission;
import adventOfCode.submit.Challenge;

public class Day19 implements Challenge {

	@Override
	public String part1(String input) {
		NuclearFission n = new NuclearFission(input);
		return String.valueOf(n.getPossibleNumber());
	}

	@Override
	public String part2(String input) {
		return "";
	}
}