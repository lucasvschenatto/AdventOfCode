package adventOfCode.day15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j< a.length;j++){
				boolean decreaseFirst = true;
				boolean increaseFirst = false;
				do{
					int before = recipe.totalScore();
					a[i].quantity--;
					a[j].quantity++;
					recipe.newQuantities(arrangement);
					int after = recipe.totalScore();
					if(before>after){
						decreaseFirst = false;
						a[i].quantity++;
						a[j].quantity--;
						recipe.newQuantities(arrangement);
					}
				}while(decreaseFirst && a[i].quantity>0);
			}
		}
		for(String name:recipe.getIngredientsNames()){
			Spoon current = arrangement.get(name);
		}
//		Collection<Integer> collection = arrangement.values();
//		Iterator<Integer> iterator = collection.iterator();
//		while(iterator.hasNext()){
//			Integer current = iterator.next();
//			
//		}
	}
}
