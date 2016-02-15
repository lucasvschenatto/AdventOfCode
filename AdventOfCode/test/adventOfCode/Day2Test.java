package adventOfCode;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Day2Test {
	@Test
	public void emptyEntrySurface(){
		surfaceFor("",0);
		surfaceFor("\n\n\n",0);
	}
	@Test
	public void surface(){
		surfaceFor("1x1x1",7);
		surfaceFor("2x3x4",58);
		surfaceFor("1x1x10",43);
		surfaceFor("1x1x1\n2x3x4\n1x1x10",7+58+43);
	}
	@Test
	public void emptyEntryRibbon(){
		ribbonFor("",0);
		ribbonFor("\n\n\n",0);
	}
	@Test
	public void ribbon(){
		ribbonFor("1x1x1",5);
		ribbonFor("2x3x4",34);
		ribbonFor("1x1x10",14);
		ribbonFor("1x1x1\n2x3x4\n1x1x10",5+34+14);
	}
	public void ribbonFor(String dimensions, int expected){
		Day2 d = new Day2();
		int actual = d.ribbonPacks(dimensions);
		assertEquals(expected, actual);
	}
	public void surfaceFor(String dimensions, int expected) {
		Day2 d = new Day2();
		int actual = d.surfacePacks(dimensions);
		assertEquals(expected,actual);
	}

}
