package adventOfCode.day19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Laboratory {
	private final String startingMatter;
	private final List<Replacement> replacements;
	private final String goalMolecule;
	public Laboratory(String input, String startingMatter) {
		Interpreter i = new Interpreter(input);
		this.replacements = i.getReplacements();
		this.goalMolecule = i.getMolecule();
		this.startingMatter = startingMatter;		
	}

	public int stepsToProduceMolecule() {
		Pot oldpot = new Pot(new HashSet<String>());
		Pot newPot = new Pot(new HashSet<String>());
		oldpot.molecules.add(startingMatter);
		boolean finished = startingMatter.equals(goalMolecule);
		int steps = 0;
		while(!finished){
			oldpot.molecules.forEach((molecule)->{
				newPot.molecules.addAll(new NuclearFission(replacements,molecule).getPossibleMolecules());
				});
			if(newPot.molecules.contains(goalMolecule))
				finished = true;
			else{
				oldpot.molecules = newPot.molecules;
				newPot.molecules = new HashSet<String>();
			}
			steps++;
		}
		return steps;
	}
	private class Pot{
		public Set<String> molecules;
		Pot(Set<String> molecules){
			this.molecules = molecules;
		}
	}
}
