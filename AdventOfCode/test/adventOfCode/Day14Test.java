package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day14Test {

	@Test
	public void part1() {
		longestFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",1,1);
		longestFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",2,2);
		longestFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",50,10);
		longestFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 20 seconds.",35,15);
		longestFor("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",1000,1120);
		longestFor("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",1000,1056);
		longestFor("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."
						+ "\nDancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",
						1000,1120);
	}
	@Test
	public void part2() {
		morePointsFor("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",1000,689);
	}
	private void longestFor(String reindeerStats, int time, int expected) {
		Day14 d = new Day14();
		int actual = d.longest(reindeerStats, time);
		assertEquals(expected, actual);
	}
	private void morePointsFor(String reindeerStats, int time, int expected) {
		Day14 d = new Day14();
		int actual = d.morePoints(reindeerStats, time);
		assertEquals(expected, actual);
	}
}
