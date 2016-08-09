package adventOfCode.day19;

import java.util.HashSet;
import java.util.Set;

public class NuclearFission {
	Interpreter interpreter;
	Set<String> possibleMolecules;
	public NuclearFission(String input) {
		interpreter = new Interpreter(input);
	}

	public boolean canMake(String expMolecule){
		boolean result = false;
		for(String molecule: getPossibleMolecules())
			if(molecule.equals(expMolecule))
				result = true;
		return result;
	}

	private Set<String> getPossibleMolecules() {
		loadPossibleMolecules();
		return possibleMolecules;
	}

	private void loadPossibleMolecules() {
		if(possibleMolecules == null){
			possibleMolecules = new HashSet<String>();
			interpreter.getReplacements().forEach((replacement)->addPossibleMolecules(replacement,interpreter.getMolecule()));
		}
	}

	private void addPossibleMolecules(Replacement replacement, String molecule) {
		int current = 0;
		while(canReplace(molecule,replacement.from,current)){
			current = molecule.indexOf(replacement.from, current);
			String prefix = molecule.substring(0, current);
			String sufix = molecule.substring(current+replacement.from.length(), molecule.length());
			possibleMolecules.add( prefix + replacement.to + sufix);
			current++;
		}
	}

	private boolean canReplace(String mol, String rep, int current) {
		return mol.indexOf(rep,current) != -1;
	}

	public int getPossibleNumber() {
		loadPossibleMolecules();
		return possibleMolecules.size();
	}

}
