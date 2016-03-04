package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day14Test {

	@Test
	public void part1() {
		longestDistanceFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",1,1);
		longestDistanceFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",2,2);
		longestDistanceFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 100 seconds.",50,10);
		longestDistanceFor("Alce can fly 1 km/s for 10 seconds, but then must rest for 20 seconds.",35,15);
	}

	private void longestDistanceFor(String reindeerStats, int time, int expected) {
		Day14 d = new Day14(reindeerStats);
		int actual = d.fly(time);
		assertEquals(expected, actual);
		
	}

}
