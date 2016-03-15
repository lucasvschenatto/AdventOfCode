package adventOfCode;

import adventOfCode.submit.Challenge;
import adventOfCode.day14.*;

public class Day14 implements Challenge{
	private final int TIME = 2503;
	@Override
	public String part1(String input) {
		return String.valueOf(longest(input,TIME));
	}

	@Override
	public String part2(String input) {
		return String.valueOf(morePoints(input,TIME));
	}
	public int longest(String reindeer, int time){
		Race r = new DistanceRace(reindeer);
		return r.run(time);
	}
	public int morePoints(String reindeer, int time){
		Race r = new PointsRace(reindeer);
		return r.run(time);
	}
	
}
