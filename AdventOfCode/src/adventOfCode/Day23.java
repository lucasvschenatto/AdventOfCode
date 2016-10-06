package adventOfCode;

import adventOfCode.day23.*;
import adventOfCode.submit.Challenge;

public class Day23 implements Challenge {

	@Override
	public String part1(String input) {
		Computer c = new Computer(0,0);
		c.run(input);
		return String.valueOf( c.getB());
	}

	@Override
	public String part2(String input) {
		Computer c = new Computer(1,0);
		c.run(input);
		return String.valueOf( c.getB());
	}

}
