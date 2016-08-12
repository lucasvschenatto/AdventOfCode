package adventOfCode;

import adventOfCode.day19.Interpreter;
import adventOfCode.day19.Laboratory;
import adventOfCode.day19.NuclearFission;
import adventOfCode.submit.Challenge;

public class Day19 implements Challenge {

	@Override
	public String part1(String input) {
		Interpreter i = new Interpreter(input);
		NuclearFission n = new NuclearFission(i.getReplacements(),i.getMolecule());
		return String.valueOf(n.getNumberOfPossibleMolecules());
	}

	@Override
	public String part2(String input) {
		Laboratory l = new Laboratory(input, "e");
		int result = l.stepsToProduceMolecule();
		return String.valueOf(result);
	}
}