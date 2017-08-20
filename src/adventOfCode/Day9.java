package adventOfCode;

import adventOfCode.day9.Route;
import adventOfCode.submit.Challenge;

public class Day9 implements Challenge{
	private static Route r;
	@Override
	public String part1(String input) {
		if(r==null)
			r = new Route(input);
		return String.valueOf(r.shortest());
	}
	@Override
	public String part2(String input) {
		if(r==null)
			r = new Route(input);
		return String.valueOf(r.longest());
	}
	
}
