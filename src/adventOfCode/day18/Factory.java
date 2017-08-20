package adventOfCode.day18;

import java.util.List;

public interface Factory {
	Grid make(String grid);
	Grid make(List<List<Light>> grid);
}
