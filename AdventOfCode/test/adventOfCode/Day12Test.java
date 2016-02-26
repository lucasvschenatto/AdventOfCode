package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day12Test {

	@Test
	public void test() {
		SumFor("[]",0);
		SumFor("[1]",1);
	}

	private void SumFor(String JSON, int expected) {
		Day12 d = new Day12();
		int actual = d.sumAll(JSON);
		assertEquals(expected, actual);
	}

}
