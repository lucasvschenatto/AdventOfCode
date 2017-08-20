package adventOfCode.day15;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class RecipeMaker {
	protected final int totalSpoons = 100;
	protected Map<String,Spoon> arrangement;
	protected Recipe recipe;
	protected int caloriesTarget;
	protected RecipeMaker(String ingredients, int calories){
		recipe = new Recipe(ingredients);
		arrangement = defaultArrangement(recipe.getIngredientsNames());
		recipe.newQuantities(arrangement);
		caloriesTarget = calories;
	}
	public Map<String,Spoon> getArrangement(){
		return arrangement;
	}
	public int totalScore() {
		return recipe.totalScore();
	}
	public static RecipeMaker create(String ingredients){
		return new Default(ingredients);
	}
	public static RecipeMaker create(String ingredients, int calories){
		return new ExactCalories(ingredients, calories);
	}
	public abstract void findBestRecipe();
	
	private Map<String,Spoon> defaultArrangement(List<String> ingredientsNames) {
		Map<String,Spoon> a = new HashMap<String,Spoon>();
		int def = totalSpoons/recipe.getIngredientsNames().size();
		for (String name : recipe.getIngredientsNames())
			a.put(name, new Spoon(def));
		return a;
	}
}
