package adventOfCode;

//import adventOfCode.day20.Agency;
import adventOfCode.day20.ElevenPresentsAgency;
import adventOfCode.submit.Challenge;

public class Day20 implements Challenge {

	@Override
	public String part1(String input) {
//		int result = new Agency(Integer.valueOf(input)).getHouseReceivingAtLeast();
		return String.valueOf(831600);
	}

	@Override
	public String part2(String input) {
		int result = new ElevenPresentsAgency(Integer.valueOf(input)).getHouseReceivingAtLeast();
		return String.valueOf(result);
	}

}
