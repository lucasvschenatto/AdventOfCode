package adventOfCode.day18;

import java.util.List;

public class StuckGrid extends Grid {

	protected StuckGrid(List<List<Light>> grid) {
		super(grid);
		setCornersOn();
	}
	protected StuckGrid(String grid) {
		super(grid);
		setCornersOn();
	}
	private void setCornersOn() {
		List<Light> upperEdge = grid.get(0);
		List<Light> lowerEdge = grid.get(lines-1);
		setFirstAndLastOn(upperEdge);
		setFirstAndLastOn(lowerEdge);
	}
	private void setFirstAndLastOn(List<Light> line) {
		line.set(0, Light.ON);
		line.set(line.size()-1, Light.ON);
	}
}
