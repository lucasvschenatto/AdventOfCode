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
	public void setCaloriesTarget(int calories){
		caloriesTarget = calories;
	}
	public void setCaloriesNotExpected(){
		
	}
	public Map<String,Spoon> getArrangement(){
		return arrangement;
	}
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

	public void findBestRecipe() {
		if(arrangement.size()>1)
			tryToImprove();
//		listAllRecipes();
	}

	public List<Map<String,Spoon>> findAllExactCalories() {
		List<Map<String,Spoon>> possibilities = allPossibilities();
		return validPossibilities(OnlyExactCalories(possibilities));
	}
	
	
	
	private List<Map<String, Spoon>> validPossibilities(List<Map<String, Spoon>> possibilities) {
		List<Map<String,Spoon>> validPossibilities = new ArrayList<Map<String,Spoon>>();
		for(Map<String,Spoon> map : possibilities){
			int total = 0;
			for(Spoon spoon : map.values())
				total += spoon.quantity;
			if(total == totalSpoons)
				validPossibilities.add(map);
		}
		return validPossibilities;
	}
	private List<Map<String,Spoon>> OnlyExactCalories(List<Map<String,Spoon>> possibilities) {
		List<Map<String,Spoon>> exactCalories = new ArrayList<Map<String,Spoon>>();
		for(Map<String,Spoon> quantities: possibilities){
			recipe.newQuantities(quantities);
			if(caloriesTarget == recipe.caloriesScore())
				exactCalories.add(quantities);
		}
		return exactCalories;
	}
	public List<Map<String,Spoon>> allPossibilities(){
		Map<String,Spoon> current = initialArrangement();
		List<Map<String,Spoon>> list = createInitialList();
		while(!isLast(current)){
			increase(current);
			list.add(clone(current));
		}
		return list;
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
	private boolean isLast(Map<String,Spoon> spoonMap){
		for (Spoon s: spoonMap.values())
			if(s.quantity < totalSpoons)
				return false;
		return true;
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

	public int totalScore() {
		return recipe.totalScore();
	}
}
