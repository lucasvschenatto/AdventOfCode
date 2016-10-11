package adventOfCode;

import java.text.DecimalFormat;

import adventOfCode.day25.*;
import adventOfCode.submit.Challenge;

public class Day25 implements Challenge {

	@Override
	public String part1(String input) {
		Coder c = new CalculationCoder();
		long result = c.getCode(2947, 3029);
		return new DecimalFormat().format(result);
	}

	@Override
	public String part2(String input) {
		return "";
	}
}
