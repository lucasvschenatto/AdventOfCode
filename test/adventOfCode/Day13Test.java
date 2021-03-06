package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day13Test {
	private String input = "Alice would gain 54 happiness units by sitting next to Bob."
			+ "\nAlice would lose 79 happiness units by sitting next to Carol."
			+ "\nAlice would lose 2 happiness units by sitting next to David."
			+ "\nBob would gain 83 happiness units by sitting next to Alice."
			+ "\nBob would lose 7 happiness units by sitting next to Carol."
			+ "\nBob would lose 63 happiness units by sitting next to David."
			+ "\nCarol would lose 62 happiness units by sitting next to Alice."
			+ "\nCarol would gain 60 happiness units by sitting next to Bob."
			+ "\nCarol would gain 55 happiness units by sitting next to David."
			+ "\nDavid would gain 46 happiness units by sitting next to Alice."
			+ "\nDavid would lose 7 happiness units by sitting next to Bob."
			+ "\nDavid would gain 41 happiness units by sitting next to Carol.";
	@Test
	public void part1() {
		Day13 d = new Day13();		
		String result = d.part1(input);
		assertEquals("330",result);
	}
	@Test
	public void part2() {
		Day13 d = new Day13();		
		String result = d.part2(input);
		assertEquals("286",result);
	}
}
