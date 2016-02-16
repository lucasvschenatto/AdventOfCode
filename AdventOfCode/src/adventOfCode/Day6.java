package adventOfCode;

import java.util.Arrays;
import java.util.List;

public class Day6 implements Challenge{
	private Grid grid;
	final int gridSize = 1000;
	public Day6(){
		grid = new Grid(gridSize,gridSize);
	}
	public void activateBrightnessControl(){
		grid = new Grid(gridSize,gridSize){
			@Override
			public void turnOn(int x, int y) {
				light[x][y]++;
			}
			@Override
			public void turnOff(int x, int y) {
				light[x][y] = (light[x][y]==0)? 0: light[x][y]-1;
			}
			@Override
			public void toogle(int x, int y) {
				light[x][y] = light[x][y]+2;
			}
		};
	}
	public void configureGrid(String commands) {
		List<String> commandList = Arrays.asList(commands.split("\n"));
		for (String command : commandList) {
			String[] token = getTokens(command);
			Command c = interpret(token[0]);
			c.execute(grid, token[1],token[2]);
		}		
	}
	public int countLightsOn(){
		return grid.countLightsOn();
	}
	private Command interpret(String instruction){
		Command c = Command.valueOf(instruction.toUpperCase());
		return c;
	}
	private String[] getTokens(String commands) {
		String[] token = new String[3];
		token[0] = getInstructionName(commands);
		token[1] = getCoordinateFrom(commands);
		token[2] = getCoordinateTo(commands);
		return token;
	}
	private String getInstructionName(String command) {
		String[] token = command.split(" ");
		if(startsWithTwoWords(token))
			return token[0] + "_" + token[1];
		else
			return token[0];
	}
	private boolean startsWithTwoWords(String[] token) {
		if (token.length >= 2)
			if (!token[1].contains(","))
				return true;
		return false;
				
	}
	private String getCoordinateFrom(String command) {
		String[] token = command.split(" ");
		for (int i = 0; i < token.length; i++)
			if( token[i].contains(","))
				return token[i];
		return "";
	}
	private String getCoordinateTo(String command) {
		String[] token = command.split(" ");
		for (int i = token.length-1; i >= 0; i--)
			if( token[i].contains(","))
				return token[i];
		return "";
	}
	class Grid{
		protected int [][] light;
		Grid(int x, int y){
			light = new int[x][y];
		}
		public void turnOn(int x, int y){
			light[x][y] = 1;
		}
		public void turnOff(int x, int y){
			light[x][y] = 0;
		}
		public void toogle(int x, int y){
			light[x][y] = (light[x][y] == 0)? 1:0;
		}
		int countLightsOn(){
			int count = 0;
			for (int i = 0; i < light.length; i++)
				for (int j = 0; j < light[i].length; j++)
					count = count + light[i][j];
			return count;
		}
	}
	private enum Command{
		TURN_ON( (grid, x, y)->{
			grid.turnOn(x,y);
		}),
		TURN_OFF((grid, x, y)->{
			grid.turnOff(x,y);
		}),
		TOGGLE((grid, x, y)->{
			grid.toogle(x,y);
		}),
		DUMMY((grid, x, y)->{});
		private Action action;
		Command(Action action){
			this.action = action;
		}
		private void execute(Grid grid, String coordinateFrom, String coordinateTo){
			int xFrom = Integer.valueOf(coordinateFrom.split(",")[0]);
			int xTo   = Integer.valueOf(coordinateTo.split(",")[0]);
			int yFrom = Integer.valueOf(coordinateFrom.split(",")[1]);
			int yTo   = Integer.valueOf(coordinateTo.split(",")[1]);
			for(int x=xFrom; x<=xTo; x++)
				for(int y=yFrom; y<=yTo; y++)
					action.execute(grid, x, y);
		}
		interface Action{
			void execute(Grid grid, int coordinateX, int coordinateY);
		}
	}
	@Override
	public String part1(String input) {
		Day6 d = new Day6();
		d.configureGrid(input);
		return String.valueOf(d.countLightsOn());
	}
	@Override
	public String part2(String input) {
		Day6 d = new Day6();
		d.activateBrightnessControl();
		d.configureGrid(input);
		return String.valueOf(d.countLightsOn());
	}
}
