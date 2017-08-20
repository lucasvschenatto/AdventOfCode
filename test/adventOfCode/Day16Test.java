package adventOfCode;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import adventOfCode.day16.Factory;
import adventOfCode.day16.SueList;

public class Day16Test {
	private static SueList s;
	private static String sueList;
	protected void findSue(int expected, String hints){		
		int actual = s.findSue(hints);
		assertEquals(expected, actual);
	}
	@BeforeClass
	public static void setupClass(){
		sueList = "Sue 1: children: 1, akitas: 8, vizslas: 3"
				+ "\nSue 2: children: 34, samoyeds: 2, trees: 397"
				+ "\nSue 3: children: 46, cats: 856, pomeranians: 12"
				+ "\nSue 4: samoyeds: 0, akitas: 123, goldfish: 7"
				+ "\nSue 5: children: 3, cats: 599, vizslas: 789"
				+ "\nSue 6: children: 4569, cats: 513, pomeranians: 2"
				+ "\nSue 7: pomeranians: 3, samoyeds: 2, perfumes: 1";
	}
	public static class Part1 extends Day16Test{
		@BeforeClass
		public static void setupPart1(){
			Factory.setOldMachine();
			s = new SueList(sueList);
		}
		@Test
		public void sue1() {
			findSue(1,"children: 1, cats: 723, samoyeds: 222, pomeranians: 453, akitas: 8, vizslas: 3, goldfish: 578, trees: 3458, cars: 23, perfumes: 199");
		}
		public void sue2() {
			findSue(2,"children: 34, cats: 700, samoyeds: 2, pomeranians: 357, akitas: 053, vizslas: 250, goldfish: 537, trees: 397, cars: 2654, perfumes: 1879");
		}
		public void sue3() {
			findSue(3,"children: 46, cats: 856, samoyeds: 2, pomeranians: 12, akitas: 0, vizslas: 0, goldfish: 5, trees: 3, cars: 2, perfumes: 1");
		}
		public void sue4() {
			findSue(4,"children: 335, cats: 987, samoyeds: 0, pomeranians: 3333, akitas: 123, vizslas: 519, goldfish: 7, trees: 576, cars: 147, perfumes: 516");
		}
		public void sue5() {
			findSue(5,"children: 3, cats: 599, vizslas: 789");
		}
		public void sue6() {
			findSue(6,"children: 4569, cats: 513, pomeranians: 2");
		}
		public void sue7() {
			findSue(7,"children: 3, cats: 7, samoyeds: 2, pomeranians: 3, akitas: 0, vizslas: 0, goldfish: 5, trees: 3, cars: 2, perfumes: 1");
		}
	}
	public static class Part2 extends Day16Test{
		@BeforeClass
		public static void setupPart2(){
			Factory.setNewMachine();
			s = new SueList(sueList);
		}
		@Test
		public void defaultAttribute_Equals(){
			findSue(1,"children: 1, cats: 723, samoyeds: 222, pomeranians: 453, akitas: 8, vizslas: 3, goldfish: 578, trees: 3458, cars: 23, perfumes: 199");
		}
		@Test
		public void cats_GreaterThan(){
			findSue(5,"cats: 478, children: 3, vizslas: 789");
		}
		@Test
		public void trees_GreaterThan(){
			findSue(2,"trees: 350, children: 34, cats: 700, samoyeds: 2, pomeranians: 357, akitas: 053, vizslas: 250, goldfish: 537, cars: 2654, perfumes: 1879");
		}
		@Test
		public void pomeranians_fewerThan(){
			findSue(7,"pomeranians: 15, children: 3, cats: 7, samoyeds: 2, akitas: 0, vizslas: 0, goldfish: 5, trees: 3, cars: 2, perfumes: 1");
		}
		@Test
		public void goldFish_fewerThan(){
			findSue(4,"goldfish: 43, children: 335, cats: 987, samoyeds: 0, pomeranians: 3333, akitas: 123, vizslas: 519, trees: 576, cars: 147, perfumes: 516");
		}
		@Test
		public void allRules(){
			findSue(6,"children: 4569, cats: 500, pomeranians: 8");
		}
	}

}
