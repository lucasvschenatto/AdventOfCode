package adventOfCode.day19;

import java.util.HashSet;

public class OptimizedLaboratory  extends Laboratory{
	public OptimizedLaboratory(String input, String startingMatter) {
		super(input, startingMatter);
	}

	public int stepsToProduceMolecule() {
		Pot oldpot = new Pot(new HashSet<String>());
		Pot newPot = new Pot(new HashSet<String>());
		oldpot.molecules.add(new String(startingMatter));
		boolean finished = startingMatter.toString().equals(goalMolecule.toString());
		I steps = new I(0);
		while(!finished){
			oldpot.molecules.forEach((molecule)->{
				AllManipulation n = new AllManipulation(replacements,molecule);
				newPot.molecules.addAll(n.getPossibleMolecules());
				steps.value += n.getSteps();
				});
			if(newPot.molecules.contains(goalMolecule))
				finished = true;
			else{
				oldpot.molecules = newPot.molecules;
				newPot.molecules = new HashSet<String>();
			}
			System.out.println(steps);
		}
		return steps.value;
	}
	
	protected class I{
		int value;
		I(int value){
			this.value = value;
		}
		public String toString(){
			return String.valueOf(value);
		}
	}
}
