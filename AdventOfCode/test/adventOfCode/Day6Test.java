package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day6Test {

	
	public static class SimpleCoordinate extends Day6Test{
		@Test
		public void emptyEntry() {
			lightsOnFor("",0);
		}
		@Test
		public void turnOnSimple(){
			lightsOnFor("turn on 0,0",1);
		}
	}
	public static class RangeCoordinate extends Day6Test{
		
	}
	protected void lightsOnFor(String commands, int expected) {
		Day6 d = new Day6();
		int actual = d.countTurnedOn(commands);
		assertEquals(expected,actual);
	}
}