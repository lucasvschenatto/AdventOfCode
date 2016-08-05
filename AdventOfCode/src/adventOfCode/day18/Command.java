package adventOfCode.day18;

public enum Command {
	TURN_ON((grid, x, y) -> {
		grid.turnOn(x, y);
	}), TURN_OFF((grid, x, y) -> {
		grid.turnOff(x, y);
	}), TOGGLE((grid, x, y) -> {
		grid.toogle(x, y);
	}), DUMMY((grid, x, y) -> {
	});
	private Action action;

	Command(Action action) {
		this.action = action;
	}

	public void execute(Grid grid, String coordinateFrom, String coordinateTo) {
		int xFrom = Integer.valueOf(coordinateFrom.split(",")[0]);
		int xTo = Integer.valueOf(coordinateTo.split(",")[0]);
		int yFrom = Integer.valueOf(coordinateFrom.split(",")[1]);
		int yTo = Integer.valueOf(coordinateTo.split(",")[1]);
		for (int x = xFrom; x <= xTo; x++)
			for (int y = yFrom; y <= yTo; y++)
				action.execute(grid, x, y);
	}
}
