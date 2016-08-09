package adventOfCode.day19;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {
	private final String input;
	private List<Replacement> replacements;
	private String molecule;
	public Interpreter(String input) {
		this.input = input;
	}

	public List<Replacement> getReplacements() {
		if(replacements == null)
			loadReplacements();
		return replacements;
	}

	private void loadReplacements() {
		this.replacements = new ArrayList<Replacement>();
		String[] args = input.split("\n\n");
		for(String line : args[0].split("\n"))
			this.replacements.add(new Replacement(line));
	}

	public String getMolecule() {
		if(molecule == null)
			loadMolecule();
		return molecule;
	}

	private void loadMolecule() {
		String[] args = input.split("\n\n");
		molecule = args[1];
	}

}
