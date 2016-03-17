package adventOfCode.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recipe {
	private List<Ingredient> ingredients;
	public Recipe(String ingredients) {
		this.ingredients = new ArrayList<Ingredient>();
		String[] ing = ingredients.split("\n");
		for (int i = 0; i < ing.length; i++)
			 this.ingredients.add(new Ingredient(ing[i],0));			
	}
	public int totalScore(){
		return  capacityScore()*
				durabilityScore()*
				flavorScore()*
				textureScore();
	}
	public void newQuantities(Map<String,Spoon> quantities) {
		for (Ingredient ingredient : ingredients) {
			String name = ingredient.getName();
			Spoon s = quantities.get(name);
			ingredient.setSpoons(s.quantity);
		}
	}
	private int capacityScore(){
		return getScore(ingredient -> ingredient.capacityScore());
	}
	private int durabilityScore(){
		return getScore(ingredient -> ingredient.durabilityScore());
	}
	private int flavorScore(){
		return getScore(ingredient -> ingredient.flavorScore());
	}
	private int textureScore(){
		return getScore(ingredient -> ingredient.textureScore());
	}
	private int getScore(Get get){
		int total = 0;
		for (Ingredient ingredient : ingredients)
			total += get.score(ingredient);
		return(total>0)? total:0;
	}
	private interface Get{
		int score(Ingredient i);
	}
	public List<String> getIngredientsNames() {
		List<String> names = new ArrayList<String>();
		for (Ingredient ingredient : ingredients) {
			names.add(ingredient.getName());
		}
		return names;
	}
}
