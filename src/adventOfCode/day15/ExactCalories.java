package adventOfCode.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactCalories extends RecipeMaker {
	
	ExactCalories(String ingredients, int calories){
		super(ingredients,calories);
	}
	
	public void findBestRecipe() {
			if(arrangement.size()>1)
				findBestExactCalories();
	}
	
	private void findBestExactCalories() {
		List<Map<String,Spoon>> all = findAllExactCalories();		
		Map<String, Spoon> best = bestFrom(all);
		arrangement = best;
		recipe.newQuantities(best);
	}
	
	private Map<String,Spoon> bestFrom(List<Map<String,Spoon>> all){
		Map<String, Spoon> best = initialMap();
		recipe.newQuantities(best);
		int bestScore = recipe.totalScore();
		for (Map<String, Spoon> current : all) {
			recipe.newQuantities(current);
			int currentScore = recipe.totalScore();
			if(currentScore>bestScore){
				best = current;
				bestScore = currentScore;
			}
		}
		return best;
	}
	
	private List<Map<String,Spoon>> findAllExactCalories() {
		Map<String,Spoon> current = initialMap();
		List<Map<String,Spoon>> list = createInitialList();
		while(!isLast(current)){
			increase(current);
			if(isExactSpoons(current) && isExactCalories(current))
				list.add(clone(current));
		}
		return list;
	}
	private boolean isExactSpoons(Map<String, Spoon> quantities) {
		int total = 0;
		for(Spoon spoon : quantities.values())
			total += spoon.quantity;
		return (total == totalSpoons)? true:false;
	}
	private boolean isExactCalories(Map<String, Spoon> quantities) {
		recipe.newQuantities(quantities);
		return (caloriesTarget == recipe.caloriesScore())? true : false;
	}
	
	private List<Map<String,Spoon>> createInitialList(){
		Map<String,Spoon> initial = initialMap();
		List<Map<String,Spoon>> list = new ArrayList<Map<String,Spoon>>();
		list.add(clone(initial));
		return list;
	}

	private Map<String,Spoon> initialMap() {
		Map<String,Spoon> initial = new HashMap<String,Spoon>();
		arrangement.keySet().forEach(ingredient->{
			initial.put(ingredient, new Spoon(0));
		} );
		return initial;
	}

	private boolean isLast(Map<String,Spoon> spoonMap){
		Spoon[] spoons = new Spoon[spoonMap.size()];
		spoons = spoonMap.values().toArray(spoons);
		int availableForLast = totalSpoons - (spoons.length + 1);
		int actualLast = spoons[spoons.length-1].quantity;
		return(actualLast == availableForLast)? true:false;
	}

	public void increase(Map<String,Spoon> spoonMap){
		List<Spoon> spoons = new ArrayList<Spoon>(spoonMap.values());
		increaseAt(spoons,0);
	}
	private void increaseAt(List<Spoon> spoons, int i) {
		if(totalQuantity(spoons) <totalSpoons)
			spoons.get(i).quantity++;
		else{
			spoons.get(i).quantity = 0;
			increaseAt(spoons, ++i);
		}
	}

	private int totalQuantity(List<Spoon> spoons) {
		Spoon total = new Spoon(0);
		spoons.forEach(spoon -> total.quantity += spoon.quantity);
		return total.quantity;
	}

	private Map<String,Spoon> clone(Map<String,Spoon> original) {
		Map<String,Spoon> clone = new HashMap<String,Spoon>();
		for (String ingredient : original.keySet()) {
			clone.put(ingredient, original.get(ingredient).clone());
		}
		return clone;
	}
}