package adventOfCode;

import adventOfCode.submit.Challenge;
import adventOfCode.day12.*;

public class Day12 implements Challenge {
	private final String NUMBERS = "[[\\W]&&[^-]]";
	private final String NONREDS = "\\{.*\\\"red\\\".*\\}|[[\\W]&&[^-]]";
	@Override
	public String part1(String input) {
		String result = String.valueOf(sumAllNumbers(input));
		return result;
	}
	@Override
	public String part2(String input) {
		String result = String.valueOf(sumAllNonReds(input));
		return result;
	}
	public int sumAllNumbers(String jSON){
		return sumAllOf(jSON, NUMBERS);
	}
	public int sumAllNonReds(String jSON){
		return new Json().sumAll(jSON);
	}
	public int sumAllOf(String jSON, String regex) {
		int sum = 0;
		for (String element : jSON.split(regex)) {
			try{
				sum+= Integer.parseInt(element);
			}catch(NumberFormatException e){}
		}
		return sum;
	}
}