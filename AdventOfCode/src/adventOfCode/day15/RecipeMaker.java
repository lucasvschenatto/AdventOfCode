package adventOfCode.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

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

	public void listAllRecipes() {
		List<Map<String,Spoon>> possibilities = allPossibilities();
		List<Map<String,Spoon>> valid = OnlyExactCalories(possibilities);
	}
	
	
	
	private List<Map<String,Spoon>> OnlyExactCalories(List<Map<String,Spoon>> possibilities) {
		List<Map<String,Spoon>> exactCalories = clone(possibilities);
		for(Map<String,Spoon> quantities: exactCalories){
			
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
		Set<String> ingredients = initial.keySet();
		ingredients.forEach(ingredient->{
			initial.put(ingredient, new Spoon(0));
		} );
		return initial;
	}
	private List<Map<String,Spoon>> clone(List<Map<String,Spoon>> original) {
		List<Map<String,Spoon>> cloneList = new ArrayList<Map<String,Spoon>>();
		for(Map<String,Spoon> current: original){
			cloneList.add(clone(current));
		}		
		return cloneList;
	}
	private Map<String,Spoon> clone(Map<String,Spoon> original) {
		Map<String,Spoon> clone = new HashMap<String,Spoon>();
		Set<String> ingredients = original.keySet();
		for (String ingredient : ingredients) {
			clone.put(ingredient, original.get(ingredient).clone());
		}
		return clone;
	}
	private boolean isLast(Map<String,Spoon> spoon){
		for (Spoon s: spoon.values())
			if(s.quantity < 100)
				return false;
		return true;
	}
	private void increase(Map<String,Spoon> arrangement){
		increaseAt(arrangement,0);
	}
	private void increaseAt(Map<String,Spoon> arrangement, int i) {
		List<Spoon> spoon = (List<Spoon>) arrangement.values();
		if(spoon.get(i).quantity <100)
			spoon.get(i).quantity++;
		else{
			spoon.get(i).quantity = 0;
			increaseAt(arrangement, ++i);
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
