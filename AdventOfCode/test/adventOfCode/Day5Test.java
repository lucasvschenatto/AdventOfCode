package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day5Test {

	@Test
	public void niceStrings() {
		countNicesFor("aei",1);
	}

	private void countNicesFor(String strings, int expected) {
		Day5 d = new Day5();
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}

}
