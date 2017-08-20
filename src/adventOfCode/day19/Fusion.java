package adventOfCode.day19;

public class Fusion extends Replacement {
	public Fusion(String replacement){
		super( replacement.split(SEPARATOR)[0], replacement.split(SEPARATOR)[1]);
	}
}
