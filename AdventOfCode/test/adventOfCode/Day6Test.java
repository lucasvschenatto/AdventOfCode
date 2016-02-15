package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day6Test {

	
	public static class Simple extends Day6Test{
		@Test
		public void turnOn(){
			lightsOnFor("turn on 9,0",1);
			lightsOnFor("turn on 456,753",1);
		}
		@Test
		public void turnOff(){
			lightsOffFor("turn off 2,2",1);
			lightsOffFor("turn off 643,865",1);
		}
		@Test
		public void toogle(){
			lightsOnFor("toggle 0,0",1);
			lightsOffFor("toggle 0,0",1);
		}
	}
	public static class Range extends Day6Test{
		@Test
		public void turnOn(){
			lightsOnFor("turn on 0,0 through 999,999",1000000);
			lightsOnFor("turn on 0,0 through 999,0",1000);
		}
		@Test
		public void turnOff(){
			lightsOffFor("turn off 499,499 through 500,500",4);
			lightsOffFor("turn off 20,0 through 49,0",30);
		}
		@Test
		public void toogle(){
			lightsOnFor("toggle 0,0 through 999,0", 1000);
			lightsOffFor("toggle 0,0 through 999,0", 1000);
		}
		@Test
		public void manyCommands(){
			lightsOnFor("turn on 0,0 through 8,0"
					  + "\nturn off 2,0 through 3,0"
					  + "\ntoggle 7,0 through 10,0", 7);
		}
	}
	protected void lightsOnFor(String commands, int expected) {
		Day6 d = new Day6();
		int actual = d.countTurnedOn(commands);
		assertEquals(expected,actual);
	}
	protected void lightsOffFor(String commands, int expected) {
		Day6 d = new Day6();
		int actual = d.countTurnedOff(commands);
		assertEquals(expected,actual);
	}
}
