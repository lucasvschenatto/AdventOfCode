package adventOfCode;

import adventOfCode.day16.SueList;
import adventOfCode.submit.Challenge;

public class Day16 implements Challenge{
	@Override
	public String part1(String input) {
		String hints = "children: 3, "+
				"cats: 7, "+
				"samoyeds: 2, "+
				"pomeranians: 3, "+
				"akitas: 0, "+
				"vizslas: 0, "+
				"goldfish: 5, "+
				"trees: 3, "+
				"cars: 2, "+
				"perfumes: 1";
		SueList sues = new SueList(input);
		return String.valueOf(sues.findSue(hints));
	}

	@Override
	public String part2(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}