package adventOfCode;

import adventOfCode.day19.Interpreter;
import adventOfCode.day19.Laboratory;
import adventOfCode.day19.SingleManipulation;
import adventOfCode.submit.Challenge;

public class Day19 implements Challenge {

	@Override
	public String part1(String input) {
		Interpreter i = new Interpreter(input);
		SingleManipulation n = new SingleManipulation(i.getFusions(),i.getMolecule());
		return String.valueOf(n.getNumberOfPossibleMolecules());
	}

	@Override
	public String part2(String input) {
		Laboratory l = new Laboratory(input, "e");
		int result = l.stepsToProduceMolecule();
		System.out.println("result of part 2 was: "+result);
		return String.valueOf(result);
	}
}