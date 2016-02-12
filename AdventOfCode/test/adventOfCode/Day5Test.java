package adventOfCode;

import static org.junit.Assert.*;
import adventOfCode.Day5.*;
import org.junit.Test;

public class Day5Test {

	@Test
	public void threeVowels() {
		findNice("aei", Strategy.THREEVOWELS);
		findNice("xazegov",Strategy.THREEVOWELS);
		findNice("aeiouaeiouaeiou",Strategy.THREEVOWELS);
	}
	@Test
	public void letterTwice() {		
		findNice("xx", Strategy.LETTERTWICE);		
		findNice("dd", Strategy.LETTERTWICE);
		findNice("aabbccdd", Strategy.LETTERTWICE);
	}
	@Test
	public void rejectedString() {		
		findNaughty("ab", Strategy.REJECTEDSUBSTRING);		
		findNaughty("cd", Strategy.REJECTEDSUBSTRING);
		findNaughty("pq", Strategy.REJECTEDSUBSTRING);
		findNaughty("xy", Strategy.REJECTEDSUBSTRING);
	}
	@Test
	public void allProprierties(){
		exactNices("ugknbfddgicrmopn", 1);
		exactNices("aaa", 1);
		exactNices("jchzalrnumimnmhp", 0);
		exactNices("haegwjzuvuyypxyu", 0);
		exactNices("dvszwmarrgswjxmb", 0);
	}
	@Test
	public void manyStrings(){
		exactNices("aaa\naeijj", 2);
	}
	
	private void findNice(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(1, actual);		
	}
	private void findNaughty(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(0, actual);		
	}

	private void exactNices(String strings, int expected) {
		Day5 d = new Day5(StrategySet.OLDRULES);
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}

}
