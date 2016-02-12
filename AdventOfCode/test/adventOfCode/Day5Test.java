package adventOfCode;

import static org.junit.Assert.*;
import adventOfCode.Day5.*;
import org.junit.Test;

public class Day5Test {

	@Test
	public void threeVowels() {
		findNiceFor("aei", Strategy.THREEVOWELS);
		findNiceFor("xazegov",Strategy.THREEVOWELS);
		findNiceFor("aeiouaeiouaeiou",Strategy.THREEVOWELS);
	}
	@Test
	public void letterTwice() {		
		findNiceFor("xx", Strategy.LETTERTWICE);		
		findNiceFor("dd", Strategy.LETTERTWICE);
		findNiceFor("aabbccdd", Strategy.LETTERTWICE);
	}
	@Test
	public void rejectedString() {		
		findNaughtyFor("ab", Strategy.REJECTEDSTRING);		
		findNaughtyFor("cd", Strategy.REJECTEDSTRING);
		findNaughtyFor("pq", Strategy.REJECTEDSTRING);
		findNaughtyFor("xy", Strategy.REJECTEDSTRING);
	}
	@Test
	public void allProprierties(){
		countNicesFor("ugknbfddgicrmopn", 1);
		countNicesFor("aaa", 1);
		countNicesFor("jchzalrnumimnmhp", 0);
		countNicesFor("haegwjzuvuyypxyu", 0);
		countNicesFor("dvszwmarrgswjxmb", 0);
	}
	@Test
	public void manyStrings(){
		countNicesFor("aaa\naeijj", 2);
	}
	private void findNiceFor(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(1, actual);		
	}
	private void findNaughtyFor(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(0, actual);		
	}

	private void countNicesFor(String strings, int expected) {
		Day5 d = new Day5(StrategySet.OLDRULES);
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}

}
