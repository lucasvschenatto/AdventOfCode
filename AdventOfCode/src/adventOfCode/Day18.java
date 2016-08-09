package adventOfCode;

import adventOfCode.day18.Controller;
import adventOfCode.day18.DefaultFactory;
import adventOfCode.day18.StuckFactory;
import adventOfCode.submit.Challenge;

public class Day18 implements Challenge {

	@Override
	public String part1(String input) {
		Controller c = new Controller(input, new DefaultFactory());
		c.step(100);
		return String.valueOf(c.getGrid().countOn());
	}

	@Override
	public String part2(String input) {
		Controller c = new Controller(input, new StuckFactory());
		c.step(100);
		return String.valueOf(c.getGrid().countOn());
	}
}