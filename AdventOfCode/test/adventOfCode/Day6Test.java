package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day6Test {

	
	public static class SimpleCoordinate extends Day6Test{
		@Test
		public void turnOn(){
			lightsOnFor("turn on 9,0",1);
			lightsOnFor("turn on 456,753",1);
		}
	}
	public static class RangeCoordinate extends Day6Test{
		@Test
		public void turnOn(){
			lightsOnFor("turn on 0,0 through 999,999",1000000);
		}
	}
	protected void lightsOnFor(String commands, int expected) {
		Day6 d = new Day6();
		int actual = d.countTurnedOn(commands);
		assertEquals(expected,actual);
	}
}
