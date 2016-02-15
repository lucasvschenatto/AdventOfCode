package adventOfCode;

import java.util.Arrays;
import java.util.List;

import adventOfCode.Day5.StrategySet;

public class Day6 implements Challenge{
	public int countTurnedOn(String commands) {
		Grid grid = new Grid(1000,1000);
		List<String> commandList = Arrays.asList(commands.split("\n"));
		for (String command : commandList) {
			String[] token = getTokens(command);
			Command c = interpret(token[0]);
			c.execute(grid, token[1],token[2]);
		}		
		return grid.countLightsOn();
	}
	public int countTurnedOff(String commands) {
		Grid grid = new Grid(1000,1000);
		grid.turnAllOn();
		String[] token = getTokens(commands);
		Command c = interpret(token[0]);
		c.execute(grid, token[1],token[2]);
		return 1000000 - grid.countLightsOn();
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
		if(startsWithTwoWords(command))
			return firstTwo(command);
		else
			return firstOne(command);
	}
	private String firstOne(String command) {
		String[] token = command.split(" ");
		return token[0];
	}
	private String firstTwo(String command) {
		String[] token = command.split(" ");
		return token[0] + "_" + token[1];
	}
	private boolean startsWithTwoWords(String command) {
		String token[] = command.split(" ");
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
		boolean [][] light;
		Grid(int x, int y){
			light = new boolean[x][y];
		}
		public void turnAllOn() {
			for (int i = 0; i < light.length; i++)
				for (int j = 0; j < light[i].length; j++)
					light[i][j] = true;
		}
		int countLightsOn(){
			int count = 0;
			for (int i = 0; i < light.length; i++)
				for (int j = 0; j < light[i].length; j++)
					if (light[i][j]) count++;
			return count;
		}
	}
	private enum Command{
		TURN_ON( (grid, x, y)->{
			grid.light[x][y] = true;
		}),
		TURN_OFF((grid, x, y)->{
			grid.light[x][y] = false;
		}),
		TOGGLE((grid, x, y)->{
			grid.light[x][y] = (grid.light[x][y])? false:true;
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
		return String.valueOf(new Day6().countTurnedOn(input));
	}
	@Override
	public String part2(String input) {
		return String.valueOf(new Day6().countTurnedOn(input));
	}
}
