package adventOfCode.day19;

public class Fission extends Replacement {
	public Fission(String replacement){
		super( replacement.split(SEPARATOR)[1], replacement.split(SEPARATOR)[0]);
	}
}
