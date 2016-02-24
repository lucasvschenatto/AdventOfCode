package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day10Test {

	@Test
	public void part1() {
		lookAndSayFor("1", 1, "11");
		lookAndSayFor("11", 1, "21");
		lookAndSayFor("21", 1, "1211");
		lookAndSayFor("1211", 1, "111221");
		lookAndSayFor("111221", 1, "312211");
		lookAndSayFor("1", 5, "312211");
		lookAndSayFor("111", 1, "31");
		lookAndSayFor("132", 1, "111312");
	}

	private void lookAndSayFor(String sequence, int turns, String expected) {
		Day10 d = new Day10();
		String actual = d.lookAndSayTurns(sequence, turns);
		assertEquals(expected,actual);
	}

}
