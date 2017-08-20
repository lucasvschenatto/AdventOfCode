package adventOfCode;

import adventOfCode.day16.*;
import adventOfCode.submit.Challenge;

public class Day16 implements Challenge{
	private static String hints = "children: 3, "+
								  "cats: 7, "+
								  "samoyeds: 2, "+
								  "pomeranians: 3, "+
								  "akitas: 0, "+
								  "vizslas: 0, "+
								  "goldfish: 5, "+
								  "trees: 3, "+
								  "cars: 2, "+
								  "perfumes: 1";
	@Override
	public String part1(String input) {
		Factory.setOldMachine();
		SueList sues = new SueList(input);
		return String.valueOf(sues.findSue(hints));
	}

	@Override
	public String part2(String input) {
		Factory.setNewMachine();
		SueList sues = new SueList(input);
		return String.valueOf(sues.findSue(hints));
	}
}