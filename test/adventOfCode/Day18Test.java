package adventOfCode;

import static org.junit.Assert.*;
import org.junit.*;

import adventOfCode.day18.*;
public class Day18Test {
	private static String sGrid =
		  "###...\n"
		+ "###...\n"
		+ "...#..\n"
		+ "..#.#.\n"
		+ "...#..\n"
		+ "..#.#.";
	public static class GridTest{
		protected static Factory factory;
		private static void givenGridAndCoordinate_SurroundingHas(Grid original, String coordinate, int onExp, int offExp) {
			Grid actual = original.getSurrounding(new Coordinate(coordinate));
			assertEquals(onExp,actual.countOn());
			assertEquals(offExp,actual.countOff());
		}
		private static void expectsLigh(Light expected,Grid grid, String coordinate) {
			Light actual = grid.getLight(new Coordinate(coordinate));
			assertEquals( expected, actual);
		}
		public static class Part1DefaultGrid extends GridTest{
			@BeforeClass
			public static void setup(){
				factory = new DefaultFactory();
			}
			@Test
			public void differentGrids_AreNotEqual(){
				Grid grid      = factory.make("..##..");
				Grid different = factory.make("#.#.#.");
				assertNotEquals(grid,different);
			}
			@Test
			public void identicalGrids_AreEqual(){
				Grid grid      = factory.make("..##..");
				Grid identical = factory.make("..##..");
				assertEquals(grid,identical);
			}
			@Test
			public void lightOff(){
				givenGrid_LighOff(".","0,0");			
				givenGrid_LighOff("..","0,1");			
				givenGrid_LighOff("#.","0,1");			
				givenGrid_LighOff(".#","0,0");			
				givenGrid_LighOff("##\n"
						+ "#.\n"
						+ "##","1,1");			
			}
			@Test
			public void lightOn(){
				givenGrid_LighOn("#","0,0");			
				givenGrid_LighOn("##","0,1");			
				givenGrid_LighOn(".#","0,1");			
				givenGrid_LighOn("#.","0,0");			
				givenGrid_LighOn("..\n"
						+ ".#\n"
						+ "..","1,1");			
			}
			@Test
			public void surrounding(){
				givenGridAndCoordinate_SurroundingHas(".","0,0",0,0);
				givenGridAndCoordinate_SurroundingHas(sGrid,"0,0",3,0);
				givenGridAndCoordinate_SurroundingHas(sGrid,"0,1",5,0);
				givenGridAndCoordinate_SurroundingHas(sGrid,"4,3",4,4);
			}
			private void givenGridAndCoordinate_SurroundingHas(String grid, String coordinate, int onExp, int offExp) {
				Grid original = factory.make(grid);
				super.givenGridAndCoordinate_SurroundingHas(original, coordinate, onExp, offExp);
			}
			private void givenGrid_LighOff(String grid, String coordinate) {
				expectsLigh( Light.OFF,grid,coordinate);
			}
			private void givenGrid_LighOn(String grid, String coordinate) {
				expectsLigh(Light.ON,grid,coordinate);
			}
			private void expectsLigh(Light expected,String grid, String coordinate) {
				Grid g = factory.make(grid);
				super.expectsLigh(expected, g, coordinate);
			}
		}
		public static class Part2StuckGrid extends GridTest{
			@BeforeClass
			public static void setup(){
				factory = new StuckFactory();
			}
			@Test
			public void lightOff(){
				givenGrid_LighOff("...","0,1");
				givenGrid_LighOff("##\n"
						+ "..\n"
						+ "##","1,0");
				givenGrid_LighOff("##\n"
						+ "..\n"
						+ "##","1,1");
			}
			@Test
			public void lightOn(){
				givenGrid_LighOn(".","0,0");
				givenGrid_LighOn("..","0,1");
				givenGrid_LighOn("#.","0,1");
				givenGrid_LighOn(".#","0,0");
				givenGrid_LighOn("#","0,0");
				givenGrid_LighOn("##","0,1");
				givenGrid_LighOn(".#","0,1");
				givenGrid_LighOn("#.","0,0");
				givenGrid_LighOn("..\n"
						+ ".#\n"
						+ "..","1,1");
			}
			private void givenGrid_LighOff(String grid, String coordinate) {
				expectsLigh( Light.OFF,grid,coordinate);
			}
			private void givenGrid_LighOn(String grid, String coordinate) {
				expectsLigh(Light.ON,grid,coordinate);
			}
			private void expectsLigh(Light expected,String grid, String coordinate) {
				Grid g = factory.make(grid);
				super.expectsLigh(expected, g, coordinate);
			}
		}
	}
	public static class ControllerTest{
		private String initialState =
				  ".#.#.#\n"
						  + "...##.\n"
						  + "#....#\n"
						  + "..#...\n"
						  + "#.#..#\n"
						  + "####..";
		private String state1 =
				  "..##..\n"
						+ "..##.#\n"
						+ "...##.\n"
						+ "......\n"
						+ "#.....\n"
						+ "#.##..";
		private String state2 =
				"..###.\n"
						+ "......\n"
						+ "..###.\n"
						+ "......\n"
						+ ".#....\n"
						+ ".#....";
		private String state3 =
				"...#..\n"
						+ "......\n"
						+ "...#..\n"
						+ "..##..\n"
						+ "......\n"
						+ "......";
		private String state4 =
				"......\n"
						+ "......\n"
						+ "..##..\n"
						+ "..##..\n"
						+ "......\n"
						+ "......";
		@Test
		public void afterOneStep_LightIsOff(){
			givenGrid_AfterSteps_LightIsOff(".",1,"0,0");
			givenGrid_AfterSteps_LightIsOff("#",1,"0,0");
			givenGrid_AfterSteps_LightIsOff(sGrid,1,"0,1");
		}
		
		@Test
		public void afterOneStep_LightIsOn(){
			givenGrid_AfterSteps_LightIsOn(sGrid,1,"0,0");
			givenGrid_AfterSteps_LightIsOn(sGrid,1,"2,3");
			givenGrid_AfterSteps_LightIsOn(sGrid,1,"5,3");
			
		}
		@Test
		public void afterSteps_GoesToState(){
			givenGrid_AfterSteps_GridIs(initialState,1,state1);
			givenGrid_AfterSteps_GridIs(initialState,2,state2);
			givenGrid_AfterSteps_GridIs(initialState,3,state3);
			givenGrid_AfterSteps_GridIs(initialState,4,state4);
			givenGrid_AfterSteps_GridIs(state1,1,state2);
			givenGrid_AfterSteps_GridIs(state1,2,state3);
			givenGrid_AfterSteps_GridIs(state1,3,state4);
			givenGrid_AfterSteps_GridIs(state2,1,state3);
			givenGrid_AfterSteps_GridIs(state2,2,state4);
			givenGrid_AfterSteps_GridIs(state3,1,state4);
		}
		
		private void givenGrid_AfterSteps_GridIs(String grid, int steps, String exp) {
			Factory factory = new DefaultFactory();
			Controller c = new Controller(grid, factory);
			c.step(steps);
			Grid expected = factory.make(exp);
			Grid actual = c.getGrid();
			assertEquals(expected, actual);
		}
		private void givenGrid_AfterSteps_LightIsOff(String grid,int steps, String index) {
			Controller c = new Controller(grid, new DefaultFactory());
			c.step(steps);
			Light actual = c.getLight(index);
			assertEquals( Light.OFF, actual);
		}
		private void givenGrid_AfterSteps_LightIsOn(String grid,int steps, String index) {
			Controller c = new Controller(grid, new DefaultFactory());
			c.step(steps);
			Light actual = c.getLight(index);
			assertEquals( Light.ON, actual);
		}
	}
}
