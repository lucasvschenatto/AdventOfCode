package adventOfCode.day19;

import java.util.List;

public class Laboratory {
	protected final String startingMatter;
	protected final List<Replacement> replacements;
	protected final String goalMolecule;
	public Laboratory(String input, String startingMatter) {
		Interpreter i = new Interpreter(input);
		this.replacements = i.getFissions();
		this.goalMolecule = startingMatter;
		this.startingMatter = i.getMolecule();
	}

	public int stepsToProduceMolecule() {
		int steps = 0;
		String molecule = startingMatter;
		while(!molecule.equals(goalMolecule)){
			Replacer r = new Replacer(replacements,molecule);
			molecule = r.replaceAll();
			steps += r.getSteps();
		}
		return steps;
	}
}
