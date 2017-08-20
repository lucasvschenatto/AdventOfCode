package adventOfCode.day18;

import java.util.List;

public class DefaultFactory implements Factory {

	@Override
	public Grid make(String grid) {
		return new Grid(grid);
	}

	@Override
	public Grid make(List<List<Light>> grid) {
		return new Grid(grid);
	}

}
