package adventOfCode.day15;

import java.util.List;

public class RecipeMaker {
	private Recipe recipe;
	public RecipeMaker(String ingredients) {
		recipe = new Recipe(ingredients);
	}

	public String mostDeliciousArrangement() {
		List<String> names = recipe.getIngredientsNames();
//		StringBuilder result = new StringBuilder();
//		for (String name : names) {
//			result.append(name);
//			result.append(":");
//			result.append(100);
//			result.append(",");
//		}
//		return result.toString();
		return null;
	}

}
