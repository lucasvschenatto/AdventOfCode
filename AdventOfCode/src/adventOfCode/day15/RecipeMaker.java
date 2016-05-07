package adventOfCode.day15;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RecipeMaker {
	private final int totalSpoons = 100;
	private Map<String,Spoon> arrangement;
	private Recipe recipe;
	private int caloriesTarget;
	public Map<String,Spoon> getArrangement(){
		return arrangement;
	}
	public RecipeMaker(String ingredients) {
		recipe = new Recipe(ingredients);
		arrangement = defaultArrangement(recipe.getIngredientsNames());
		recipe.newQuantities(arrangement);
	}
	public RecipeMaker(String ingredients, int calories){
		recipe = new Recipe(ingredients);
		arrangement = defaultArrangement(recipe.getIngredientsNames());
		recipe.newQuantities(arrangement);
		caloriesTarget = calories;
	}

	public int totalScore() {
		return recipe.totalScore();
	}
	public void findBestRecipe() {
		if(caloriesTarget == 0){
			if(arrangement.size()>1)
				tryToImprove();
		}else
			if(arrangement.size()>1)
				findBestExactCalories();
	}

	private void findBestExactCalories() {
		List<Map<String,Spoon>> exact = findAllExactCalories();
		Map<String, Spoon> best = initialArrangement();
		recipe.newQuantities(best);
		int bestScore = recipe.totalScore();
		for (Map<String, Spoon> current : exact) {
			recipe.newQuantities(current);
			int currentScore = recipe.totalScore();
			if(currentScore>bestScore){
				best = current;
				bestScore = currentScore;
			}
		}
		arrangement = best;
		recipe.newQuantities(best);
	}
	public List<Map<String,Spoon>> findAllExactCalories() {
		Map<String,Spoon> current = initialArrangement();
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
	private Map<String,Spoon> defaultArrangement(List<String> ingredientsNames) {
		Map<String,Spoon> a = new HashMap<String,Spoon>();
		int def = totalSpoons/recipe.getIngredientsNames().size();
		for (String name : recipe.getIngredientsNames())
			a.put(name, new Spoon(def));
		return a;
	}
	private List<Map<String,Spoon>> createInitialList(){
		Map<String,Spoon> initial = initialArrangement();
		List<Map<String,Spoon>> list = new ArrayList<Map<String,Spoon>>();
		list.add(clone(initial));
		return list;
	}
	private Map<String,Spoon> initialArrangement() {
		Map<String,Spoon> initial = new HashMap<String,Spoon>();
		arrangement.keySet().forEach(ingredient->{
			initial.put(ingredient, new Spoon(0));
		} );
		return initial;
	}
	
	private Map<String,Spoon> clone(Map<String,Spoon> original) {
		Map<String,Spoon> clone = new HashMap<String,Spoon>();
		for (String ingredient : original.keySet()) {
			clone.put(ingredient, original.get(ingredient).clone());
		}
		return clone;
	}
	private boolean isLast(Map<String,Spoon> quantities){
		Spoon[] spoons = new Spoon[quantities.size()];
		spoons = quantities.values().toArray(spoons);
		int availableForLast = totalSpoons - (spoons.length + 1);
		int actualLast = spoons[spoons.length-1].quantity;
		return(actualLast == availableForLast)? true:false;
	}
	private void increase(Map<String,Spoon> spoonMap){
		List<Spoon> spoons = new ArrayList<Spoon>(spoonMap.values());
		increaseAt(spoons,0);
	}
	private void increaseAt(List<Spoon> spoon, int i) {
		if(spoon.get(i).quantity <totalSpoons)
			spoon.get(i).quantity++;
		else{
			spoon.get(i).quantity = 0;
			increaseAt(spoon, ++i);
		}
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
}
