package adventOfCode;

import adventOfCode.submit.Challenge;
import adventOfCode.day12.*;

public class Day12 implements Challenge {
	@Override
	public String part1(String input) {
		String result = String.valueOf(sumAllNumbers(input));
		return result;
	}
	@Override
	public String part2(String input) {
		String result = String.valueOf(sumAllNonReds(input));
		return result;
	}
	public int sumAllNumbers(String jSON){
		return new Json(jSON, false).sumAll();
	}
	public int sumAllNonReds(String jSON){
		return new Json(jSON, true).sumAll();
	}
}