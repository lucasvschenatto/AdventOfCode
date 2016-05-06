package adventOfCode;

import adventOfCode.day15.RecipeMaker;
import adventOfCode.submit.Challenge;

public class Day15 implements Challenge{

	@Override
	public String part1(String input) {
		RecipeMaker r = new RecipeMaker(input);
		r.findBestRecipe();
		int result = r.totalScore();
		return String.valueOf(result);
	}

	@Override
	public String part2(String input) {
		return String.valueOf("");
	}

}
