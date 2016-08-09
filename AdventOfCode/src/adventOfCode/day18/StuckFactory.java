package adventOfCode.day18;

import java.util.List;

public class StuckFactory implements Factory{

	@Override
	public Grid make(String grid) {
		return new StuckGrid(grid);
	}

	@Override
	public Grid make(List<List<Light>> grid) {
		return new StuckGrid(grid);
	}

}
