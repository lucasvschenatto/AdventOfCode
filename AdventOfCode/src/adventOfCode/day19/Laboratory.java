package adventOfCode.day19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Laboratory {
	protected final String startingMatter;
	protected final List<Replacement> replacements;
	protected final String goalMolecule;
	public Laboratory(String input, String startingMatter) {
		Interpreter i = new Interpreter(input);
		this.replacements = i.getFissions();
		this.goalMolecule = startingMatter;
		this.startingMatter = i.getMolecule();
//		this.replacements = i.getFusions();
//		this.goalMolecule = i.getMolecule();
//		this.startingMatter = startingMatter;
	}

	public int stepsToProduceMolecule() {
		Pot oldpot = new Pot(new HashSet<String>());
		Pot newPot = new Pot(new HashSet<String>());
		oldpot.molecules.add(new String(startingMatter));
		boolean finished = startingMatter.toString().equals(goalMolecule.toString());
		int steps = 0;
		while(!finished){
			oldpot.molecules.forEach((molecule)->{
				newPot.molecules.addAll(new NuclearManipulation(replacements,molecule).getPossibleMolecules());
				});
//			newPot.molecules.removeIf((molecule)->{return molecule.length() > goalMolecule.length();});
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
	protected class Pot{
		public Set<String> molecules;
		Pot(Set<String> molecules){
			this.molecules = molecules;
		}
		public String toString(){
			return molecules.toString();
		}
	}
}
