package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day9Test {
	String input = "London to Dublin = 464"
			+ "\nLondon to Belfast = 518"
			+ "\nDublin to Belfast = 141";
	@Test
	public void part1() {
		Day9 d = new Day9();
		String result = d.part1(input);
		assertEquals("605",result);
	}
	@Test
	public void part2() {
		Day9 d = new Day9();
		String result = d.part2(input);
		assertEquals("982",result);
	}
}
