package adventOfCode.day19;

import java.util.List;

public class Replacer{
	private int steps;
	private final List<Replacement> replacements;
	private String moleculeFrom;
	public Replacer(List<Replacement> replacements, String moleculeFrom) {
		this.replacements = replacements;
		this.moleculeFrom = moleculeFrom;
	}
	public int getSteps() {
		return steps;
	}
	public String replaceAll() {
		String molecule = moleculeFrom;
		for(int i = 0; i<replacements.size();){
			String aux = replaceThis(replacements.get(i),molecule);
			if(!molecule.equals(aux))
				i = 0;
			else
				i++;
			molecule = aux;
		}
//		for(Replacement replacement : replacements){
//			molecule = replace(replacement,molecule);
//		}
		return molecule;
	}
	
	private String replaceThis(Replacement replacement, String molecule) {
		while(canReplace(molecule,replacement.from)){
			molecule = replaceOnce(replacement, molecule);
			steps++;
		}
		return molecule;
	}
	private String replaceOnce(Replacement replacement, String molecule) {
		String prefix = molecule.substring(0, molecule.indexOf(replacement.from));
		String sufix  = molecule.substring(prefix.length()+replacement.from.length(), molecule.length());
		molecule = prefix + replacement.to + sufix;
		return molecule;
	}
	
	private boolean canReplace(String mol, String rep) {
		return mol.indexOf(rep) != -1;
	}
}
