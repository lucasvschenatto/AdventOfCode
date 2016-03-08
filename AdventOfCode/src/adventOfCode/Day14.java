package adventOfCode;

import adventOfCode.submit.Challenge;
import adventOfCode.day14.*;

public class Day14 implements Challenge{
	@Override
	public String part1(String input) {
		return String.valueOf(longest(input,2503));
	}

	@Override
	public String part2(String input) {
		return String.valueOf(morePoints(input,2503));
	}
	public int longest(String reindeer, int time){
		Race r = new Race(reindeer);
		return r.longest(time);
	}
	public int morePoints(String reindeer, int time){
		Race r = new Race(reindeer);
		return r.morePoints(time);
	}
	
}
