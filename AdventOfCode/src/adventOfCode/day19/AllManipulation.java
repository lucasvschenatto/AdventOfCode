package adventOfCode.day19;

import java.util.HashSet;
import java.util.List;

public class AllManipulation extends NuclearManipulation {
	private int steps;
	protected AllManipulation(List<Replacement> replacements, String moleculeFrom) {
		super(replacements, moleculeFrom);
	}
	
	protected void loadPossibleMolecules() {
		if(possibleMolecules == null){
			possibleMolecules = new HashSet<String>();
			replacements.forEach((replacement)->addPossibleMolecules(replacement,moleculeFrom));
		}
	}
	
	protected void addPossibleMolecules(Replacement replacement, String molecule) {
		int count = 0;
		while(canReplace(molecule,replacement.from,0)){
			molecule = molecule.replaceFirst(replacement.from, replacement.to);
			count++;
		}
		possibleMolecules.add(molecule);
		steps = count;
	}
	
	public int getSteps(){
		return steps;
	}

}
