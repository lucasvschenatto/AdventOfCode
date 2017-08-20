package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

import adventOfCode.day17.Reservatory;

public class Day17Test {

	@Test
	public void part1() {
		waysToFit(1,1,"1");
		waysToFit(1,5,"5");
		waysToFit(1,5,"3\n2");
		waysToFit(2,1,"1\n1");
		waysToFit(3,1,"1\n1\n1");
		waysToFit(1,3,"1\n1\n1");
		waysToFit(3,2,"1\n1\n1");
		waysToFit(2,5,"1\n4\n1");
		waysToFit(4,25,"20\n15\n10\n5\n5");
	}
	@Test
	public void part2(){
		
	}
	@Test
	public void fit(){
		doesFit(0,"");
		doesFit(0,"0");
		doesFit(1,"1");
		doesFit(2,"1\n1");
		doesFit(15,"10\n5");
		doesFit(15,"5\n5\n5");
		doesFit(2,"1\n1");
		doesNotFit(2,"1");
		doesNotFit(6,"1\n3\n3");
		doesNotFit(10,"5\n4");
	}
	@Test
	public void countDifferentWays(){
		allWaysFor(1,"1");
		allWaysFor(7,"1\n1\n2");
		allWaysFor(15,"1\n1\n1\n1");
		allWaysFor(3,"1\n1");
	}
	@Test
	public void minimumNumberOfContainers(){
		minimumFor(1,1,"1");
		minimumFor(1,4,"1\n1\n2\n3\n4\n4\n9");
		minimumFor(2,5,"1\n1\n2\n3\n4\n4\n9");
		minimumFor(3,15,"1\n1\n2\n3\n4\n4\n9");
	}
	@Test
	public void waysWithMinimumNumberOfContainers(){
		waysWithMinimum(1,1,"1");
		waysWithMinimum(4,3,"1\n1\n1\n1");
		waysWithMinimum(3,3,"1\n1\n1\n2");
		waysWithMinimum(1,5,"1\n1\n1\n2\n3");
	}
	
	private void waysWithMinimum(int expected, int eggnog, String containers) {
		int actual = new Reservatory(eggnog, containers).waysWithMinimum();
		assertEquals(expected, actual);
	}
	private void minimumFor(int expected, int eggnog, String containers) {
		int actual = new Reservatory(eggnog, containers).minimumContainersToFit();
		assertEquals(expected, actual);
	}
	private void doesNotFit(int eggnog, String containers) {
		assertFalse(new Reservatory(eggnog, containers).fit());
	}
	private void doesFit(int eggnog, String containers) {
		assertTrue(new Reservatory(eggnog, containers).fit());
	}
	private void waysToFit(int expected, int eggnog, String containers){
		int actual = new Reservatory(eggnog, containers).waysToFit();
		assertEquals(expected, actual);
	}
	private void allWaysFor(int expected, String containers){
		int actual = new Reservatory(0, containers).allWaysFromIndex(0).size();
		assertEquals(expected, actual);
	}

}
