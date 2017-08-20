package adventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day6Test {

	public static class part1{
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
	}
	public static class part2{
		public static class range extends Day6Test{
			@Test
			public void turnOn(){
				brightnessControlLightsOnFor("turn on 0,0 through 999,999",1000000);
				brightnessControlLightsOnFor("turn on 0,0 through 999,0",1000);
			}
			@Test
			public void turnOff(){
				brightnessControlLightsOnFor("turn on 0,0 through 999,999"
						+ "\nturn off 499,499 through 500,500",1000000 - 4);
				brightnessControlLightsOnFor("turn on 0,0 through 999,999"
						+ "\nturn off 20,0 through 49,0",1000000 - 30);
			}
			@Test
			public void toogle(){
				brightnessControlLightsOnFor("toggle 0,0 through 999,0", 2000);
				brightnessControlLightsOnFor("turn on 0,0 through 999,999"
						+ "\ntoggle 0,0 through 999,0", 1002000);
			}
			@Test
			public void manyCommands(){
				brightnessControlLightsOnFor("turn on 0,0 through 8,0"
						  + "\nturn off 2,0 through 3,0"
						  + "\ntoggle 7,0 through 10,0", 15);
			}
		}
	}
	protected void brightnessControlLightsOnFor(String commands, int expected) {
		Day6 d = new Day6();
		d.activateBrightnessControl();
		d.configureGrid(commands);
		int actual = d.countLightsOn();
		assertEquals(expected,actual);
	}
	protected void lightsOnFor(String commands, int expected) {
		Day6 d = new Day6();
		d.configureGrid(commands);
		int actual = d.countLightsOn();
		assertEquals(expected,actual);
	}
	protected void lightsOffFor(String commands, int expected) {
		Day6 d = new Day6();
		d.configureGrid("turn on 0,0 through 999,999");
		d.configureGrid(commands);
		int actual = 1000000- d.countLightsOn();
		assertEquals(expected,actual);
	}
}
