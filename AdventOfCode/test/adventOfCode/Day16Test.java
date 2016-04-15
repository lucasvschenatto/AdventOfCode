package adventOfCode;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import adventOfCode.day16.SueList;

public class Day16Test {
	private static SueList d;
	@BeforeClass
	public static void setupClass(){
		String sueList = "Sue 1: children: 1, akitas: 8, vizslas: 3"
				+ "\nSue 2: children: 34, samoyeds: 2, trees: 3"
				+ "\nSue 3: children: 46, cats: 8, pomeranians: 12"
				+ "\nSue 4: samoyeds: 0, akitas: 123, goldfish: 78"
				+ "\nSue 5: children: 3, cats: 5, vizslas: 789"
				+ "\nSue 6: children: 4569, cats: 513, pomeranians: 235"
				+ "\nSue 7: pomeranians: 3, samoyeds: 2, perfumes: 1";
		d = new SueList(sueList);
	}
	@Test
	public void test() {
		findSue(1,"children: 1, cats: 723, samoyeds: 222, pomeranians: 453, akitas: 8, vizslas: 3, goldfish: 578, trees: 3458, cars: 23, perfumes: 199");
		findSue(2,"children: 34, cats: 700, samoyeds: 2, pomeranians: 357, akitas: 053, vizslas: 250, goldfish: 537, trees: 3, cars: 2654, perfumes: 1879");
		findSue(3,"children: 46, cats: 8, samoyeds: 2, pomeranians: 12, akitas: 0, vizslas: 0, goldfish: 5, trees: 3, cars: 2, perfumes: 1");
		findSue(4,"children: 335, cats: 987, samoyeds: 0, pomeranians: 3333, akitas: 123, vizslas: 519, goldfish: 78, trees: 576, cars: 147, perfumes: 516");
		findSue(5,"children: 3, cats: 5, vizslas: 789");
		findSue(6,"children: 4569, cats: 513, pomeranians: 235");
		findSue(7,"children: 3, cats: 7, samoyeds: 2, pomeranians: 3, akitas: 0, vizslas: 0, goldfish: 5, trees: 3, cars: 2, perfumes: 1");
	}
	private void findSue(int expected, String hints){		
		int actual = d.findSue(hints);
		assertEquals(expected, actual);
	}

}
