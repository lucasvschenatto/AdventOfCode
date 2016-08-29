package adventOfCode.day20;

public class ElevenPresentsAgency extends Agency {

	public ElevenPresentsAgency(int presents) {
		super(presents,11, new ElevenPresentsElvesFactory());
	}

}
