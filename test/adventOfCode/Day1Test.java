package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.Day1;

public class Day1Test {
	private Day1 puzzle;
	private int result;

	@Before
	public void setUp() throws Exception {
		puzzle = new Day1();
		result = 0;
	}
	@Test
	public void goToFloorTest() throws Exception{
		assertFloor("",0);
		assertFloor("(",1);
		assertFloor(")",-1);
		assertFloor("((",2);
		assertFloor("))",-2);
		
		assertFloor("(())",0);
		assertFloor("()()",0);
		assertFloor("(((",3);
		assertFloor("(()(()(",3);
		assertFloor("))(((((",3);
		assertFloor("())",-1);
		assertFloor("))(",-1);
		assertFloor(")))",-3);
		assertFloor(")())())",-3);
	}
	@Test
	public void whenEnterTheBasementTest() throws Exception{
		assertBasementEntrance(")",1);
		assertBasementEntrance("()())",5);
	}
	private void assertBasementEntrance(String commands, int floor){
		result = puzzle.whenEnterTheBasement(commands);
		assertEquals(floor, result);
	}
	private void assertFloor(String commands, int floor) {
		result = puzzle.goToFloor(commands);
		assertEquals(floor, result);
	}
	
}
