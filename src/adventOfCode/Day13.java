package adventOfCode;

import adventOfCode.day13.SeatingArrangement;
import adventOfCode.submit.Challenge;

public class Day13 implements Challenge{
	private static SeatingArrangement s;
	@Override
	public String part1(String input) {
		if(s==null)
			s = new SeatingArrangement(input);
		return String.valueOf(s.happier());
	}
	@Override
	public String part2(String input) {
		if(s==null)
			s = new SeatingArrangement(input);
		s.addGuest("mySelf");
		return String.valueOf(s.happier());
	}
}
