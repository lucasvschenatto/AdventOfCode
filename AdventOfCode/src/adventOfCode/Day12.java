package adventOfCode;

import adventOfCode.submit.Challenge;

public class Day12 implements Challenge {

	@Override
	public String part1(String input) {
		return "";
	}

	@Override
	public String part2(String input) {
		return "";
	}

	public int sumAll(String jSON) {
		for (String element : jSON.split("[[-]]")) {
			try{
				return Integer.parseInt(element);				
			}catch(NumberFormatException e){}
		}
		return 0;
	}

}
