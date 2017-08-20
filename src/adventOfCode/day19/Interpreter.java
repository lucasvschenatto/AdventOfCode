package adventOfCode.day19;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {
	private final String input;
	private List<Replacement> fusions;
	private List<Replacement> fissions;
	private String molecule;
	public Interpreter(String input) {
		this.input = input;
	}

	public List<Replacement> getFusions() {
		if(fusions == null)
			loadFusions();
		return fusions;
	}

	private void loadFusions() {
		this.fusions = new ArrayList<Replacement>();
		String[] args = input.split("\n\n");
		for(String line : args[0].split("\n"))
			this.fusions.add(new Fusion(line));
	}
	
	public List<Replacement> getFissions() {
		if(fissions == null){
			loadFissions();
			sortFissionsDescending();
		}
		return fissions;
	}

	private void sortFissionsDescending() {
		fissions.sort((rep1,rep2)->{
			if(rep1.from.length() > rep2.from.length())
				return -1;
			else if(rep2.from.length() > rep1.from.length())
				return 1;
			else
				return rep2.from.compareTo(rep1.from);
			});
	}

	private void loadFissions() {
		this.fissions = new ArrayList<Replacement>();
		String[] args = input.split("\n\n");
		for(String line : args[0].split("\n"))
			this.fissions.add(new Fission(line));
	}

	public String getMolecule() {
		if(molecule == null)
			loadMolecule();
		return molecule;
	}

	private void loadMolecule() {
		String[] args = input.split("\n\n");
		molecule = new String( args[1]);
	}

}
