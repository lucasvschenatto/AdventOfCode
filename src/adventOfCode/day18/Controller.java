package adventOfCode.day18;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private Grid grid;
	private Factory factory;
	public Controller(String grid, Factory factory) {
		this.factory = factory;
		this.grid = factory.make(grid);
	}
	public void step(int steps) {
		for(int i = 0; i<steps;i++)
			doStep();
	}
	private void doStep() {
		List<List<Light>> newgrid = new ArrayList<List<Light>>();
		for(int l = 0; l<grid.getLines();l++){
			List<Light> line = new ArrayList<Light>();
			for(int c = 0; c<grid.getColumns(); c++)
					addNextStateLight(l, line, c);
			newgrid.add(line);
		}
		grid = factory.make(newgrid);
	}
	private void addNextStateLight(int lineIndex, List<Light> line, int columnIndex) {
		Coordinate co = new Coordinate(lineIndex,columnIndex);
		int surroundingOn = grid.getSurrounding(co).countOn();
		Light newLight = grid.getLight(co).onStepIsOn(surroundingOn)? Light.ON:Light.OFF;
		line.add(newLight);
	}
	public Light getLight(String lightIndex) {
		return grid.getLight(new Coordinate(lightIndex));
	}
	public Grid getGrid() {
		return grid;
	}
}
