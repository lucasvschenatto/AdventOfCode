package adventOfCode.day19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class NuclearManipulation {
	protected final List<Replacement> replacements;
	protected String moleculeFrom;
	protected Set<String> possibleMolecules;
	protected NuclearManipulation(List<Replacement> replacements, String moleculeFrom) {
		this.replacements = replacements;
		this.moleculeFrom = moleculeFrom;
	}
	public boolean canMake(String goalMolecule){
		boolean result = false;
		for(String molecule: getPossibleMolecules())
			if(molecule.equals(goalMolecule))
				result = true;
		return result;
	}

	public int getNumberOfPossibleMolecules() {
		loadPossibleMolecules();
		return possibleMolecules.size();
	}

	public Set<String> getPossibleMolecules() {
		loadPossibleMolecules();
		return possibleMolecules;
	}
	
	protected void loadPossibleMolecules() {
		if(possibleMolecules == null){
			possibleMolecules = new HashSet<String>();
			replacements.forEach((replacement)->addPossibleMolecules(replacement,moleculeFrom));
		}
	}
	
	protected void addPossibleMolecules(Replacement replacement, String molecule) {
		int current = 0;
		while(canReplace(molecule,replacement.from,current)){
			current = molecule.indexOf(replacement.from, current);
			String prefix = molecule.substring(0, current);
			String sufix = molecule.substring(current+replacement.from.length(), molecule.length());
			possibleMolecules.add(prefix + replacement.to + sufix);
			current++;
		}
	}
	
	protected boolean canReplace(String mol, String rep, int current) {
		return mol.indexOf(rep,current) != -1;
	}
}
