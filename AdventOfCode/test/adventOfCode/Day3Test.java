package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Day3Test {

	@Test
	public void housesVisited() {
		housesVisitedFor("",1);
		housesVisitedFor("^",2);
		housesVisitedFor("v",2);
		housesVisitedFor(">",2);
		housesVisitedFor("<",2);
		housesVisitedFor("^>",3);
		housesVisitedFor("^>v<",4);
		housesVisitedFor("^v^v^v^v^v",2);
		housesVisitedFor(">v>vv^<v^^<<",10);
	}
	
	@Test
	public void housesWithRobot() {
		housesWithRobotFor("",1);
		housesWithRobotFor("^",2);
		housesWithRobotFor("v",2);
		housesWithRobotFor(">",2);
		housesWithRobotFor("<",2);
		housesWithRobotFor("^v",3);
		housesWithRobotFor("^>v<",3);
		housesWithRobotFor("^v^v^v^v^v",11);
	}

	private void housesVisitedFor(String directions, int expected) {
		Day3 d = new Day3();
		int actual = d.housesVisited(directions);
		assertEquals(expected, actual);
	}
	
	private void housesWithRobotFor(String directions, int expected) {
		Day3 d = new Day3();
		int actual = d.housesVisitedWithRobot(directions);
		assertEquals(expected, actual);
	}

}
