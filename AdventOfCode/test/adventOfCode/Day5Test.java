package adventOfCode;

import static org.junit.Assert.*;
import adventOfCode.Day5.*;
import org.junit.Test;

public class Day5Test {

	@Test
	public void niceStrings() {
		withStrategyCountNicesFor("aei", Strategy.THREEVOWELS);
		withStrategyCountNicesFor("xazegov",Strategy.THREEVOWELS);
		withStrategyCountNicesFor("aeiouaeiouaeiou",Strategy.THREEVOWELS);
		
		withStrategyCountNicesFor("xx", Strategy.LETTERTWICE);		
		withStrategyCountNicesFor("dd", Strategy.LETTERTWICE);
		withStrategyCountNicesFor("aabbccdd", Strategy.LETTERTWICE);
	}

	private void withStrategyCountNicesFor(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(1, actual);		
	}

	private void countNicesFor(String strings, int expected) {
		Day5 d = new Day5();
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}

}
