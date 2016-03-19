package adventOfCode.day15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeMaker {
	private final int totalSpoons = 100;
	private Map<String,Spoon> arrangement;
	private Recipe recipe;
	public RecipeMaker(String ingredients) {
		recipe = new Recipe(ingredients);
		arrangement = defaultArrangement(recipe.getIngredientsNames());
		recipe.newQuantities(arrangement);
	}

	private Map<String,Spoon> defaultArrangement(List<String> ingredientsNames) {
		Map<String,Spoon> a = new HashMap<String,Spoon>();
		int def = totalSpoons/recipe.getIngredientsNames().size();
		for (String name : recipe.getIngredientsNames())
			a.put(name, new Spoon(def));
		return a;
	}

	public Map<String,Spoon> mostDeliciousArrangement() {
		if(arrangement.size()<=1)
			return arrangement;
		tryToImprove();
		return arrangement;
	}

	private void tryToImprove() {
		Spoon[] a = new Spoon[0];
		a = (Spoon[]) arrangement.values().toArray(a);
		for (int i = 0; i < a.length; i++) 
			for (int j = 0; j< a.length;j++)
				if (i != j){
					improveThruTransfer(a, i, j);
					improveThruTransfer(a, j, i);
				}
	}
	
	private void improveThruTransfer(Spoon[] spoons, int from, int to){
		boolean transfer = true;
		while(transfer && !spoons[from].isEmpty()){
			int before = recipe.totalScore();
			spoons[from].quantity--;
			spoons[to].quantity++;
			recipe.newQuantities(arrangement);
			int after = recipe.totalScore();
			if(before>after || spoons[from].quantity==0){
				transfer = false;
				spoons[from].quantity++;
				spoons[to].quantity--;
				recipe.newQuantities(arrangement);
			}
		}
	}

	public int bestRecipeScore() {
		mostDeliciousArrangement();
		return recipe.totalScore();
	}
}
