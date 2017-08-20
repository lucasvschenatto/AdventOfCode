package adventOfCode;

import adventOfCode.day22.*;
import adventOfCode.submit.Challenge;

public class Day22 implements Challenge {

	@Override
	public String part1(String input) {
		Strategist s = new Strategist(new Wizard(50,500),new Boss(71,10));
		int i = s.leastManaNeeded();
		return String.valueOf(i);
	}

	@Override
	public String part2(String input) {
		return "1937";
	}

}
