package adventOfCode;

import static org.junit.Assert.*;
import adventOfCode.day5.*;
import org.junit.*;

public class Day5Test {
	public static class Part1 extends Day5Test{
		@Test
		public void threeVowels() {
			findNice("aei", Strategy.THREEVOWELS);
			findNice("xazegov",Strategy.THREEVOWELS);
			findNice("aeiouaeiouaeiou",Strategy.THREEVOWELS);
			
			findNaughty("", Strategy.THREEVOWELS);
			findNaughty("b", Strategy.THREEVOWELS);
			findNaughty("aew", Strategy.THREEVOWELS);
		}
		@Test
		public void letterTwice() {		
			findNice("xx", Strategy.LETTERTWICE);		
			findNice("dd", Strategy.LETTERTWICE);
			findNice("aabbccdd", Strategy.LETTERTWICE);
			
			findNaughty("", Strategy.LETTERTWICE);
			findNaughty("xsc", Strategy.LETTERTWICE);
			findNaughty("xsx", Strategy.LETTERTWICE);
		}
		@Test
		public void rejectedString() {		
			findNaughty("ab", Strategy.REJECTEDSUBSTRING);		
			findNaughty("cd", Strategy.REJECTEDSUBSTRING);
			findNaughty("pq", Strategy.REJECTEDSUBSTRING);
			findNaughty("xy", Strategy.REJECTEDSUBSTRING);
			
			findNice("", Strategy.REJECTEDSUBSTRING);
			findNice("aa", Strategy.REJECTEDSUBSTRING);
			findNice("bceporgdfj", Strategy.REJECTEDSUBSTRING);
		}
		@Test
		public void allProprierties(){
			exactNicesOld("ugknbfddgicrmopn", 1);
			exactNicesOld("aaa", 1);
			exactNicesOld("jchzalrnumimnmhp", 0);
			exactNicesOld("haegwjzuvuyypxyu", 0);
			exactNicesOld("dvszwmarrgswjxmb", 0);
		}
		@Test
		public void manyStrings(){
			exactNicesOld("aaa\naeijj", 2);
			exactNicesOld("aaa\naeijj\nugknbfddgicrmopn", 3);
			exactNicesOld("aaa\naeijj\nugknbfddgicrmopn\ngguio", 4);			
		}
	}
	public static class Part2 extends Day5Test{
		@Test
		public void pairNotOverlaping(){
			findNaughty("", Strategy.PAIRNOTOVERLAPING);
			findNaughty("a", Strategy.PAIRNOTOVERLAPING);
			findNaughty("aaa", Strategy.PAIRNOTOVERLAPING);
			findNaughty("bbbaaa", Strategy.PAIRNOTOVERLAPING);
			
			findNice("aabcdeaa", Strategy.PAIRNOTOVERLAPING);
			findNice("xxbxx", Strategy.PAIRNOTOVERLAPING);
			findNice("xddxd", Strategy.PAIRNOTOVERLAPING);
			findNice("qqqqg", Strategy.PAIRNOTOVERLAPING);
		}
		@Test
		public void repeatWithOneBetween(){
			findNaughty("",Strategy.REPEATWITHONEBETWEEN);
			findNaughty("g",Strategy.REPEATWITHONEBETWEEN);
			findNaughty("ggt",Strategy.REPEATWITHONEBETWEEN);
			findNaughty("avda",Strategy.REPEATWITHONEBETWEEN);
			
			findNice("xyx",Strategy.REPEATWITHONEBETWEEN);
			findNice("abcdefeghi",Strategy.REPEATWITHONEBETWEEN);
			findNice("efe",Strategy.REPEATWITHONEBETWEEN);
			findNice("aaa",Strategy.REPEATWITHONEBETWEEN);
		}
		@Test
		public void allNewProperties(){
			exactNicesNew("", 0);
		}
	}
	protected void findNice(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(1, actual);		
	}
	protected void findNaughty(String strings, Strategy strategy) {
		Day5 d = new Day5(strategy);
		int actual = d.countNices(strings);
		assertEquals(0, actual);		
	}

	protected void exactNicesOld(String strings, int expected) {
		Day5 d = new Day5(StrategySet.OLDRULES);
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}
	protected void exactNicesNew(String strings, int expected) {
		Day5 d = new Day5(StrategySet.NEWRULES);
		int actual = d.countNices(strings);
		assertEquals(expected, actual);
	}
}
