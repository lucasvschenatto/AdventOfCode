package adventOfCode.day15;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private List<Ingredient> ingredients;
	public Recipe(String ingredients, String division) {
		this.ingredients = new ArrayList<Ingredient>();
		String[] ing = ingredients.split("\n");
		String[] spoons = division.split(",");
		for (int i = 0; i < ing.length; i++)
			 this.ingredients.add(new Ingredient(ing[i], Integer.valueOf(spoons[i])));			
	}
	public int capacityScore(){
		int total = 0;
		for (Ingredient i : ingredients) {
			total += i.capacityScore();
		}
		return total;
	}
	public int durabilityScore(){
		int total = 0;
		for (Ingredient i : ingredients) {
			total += i.durabilityScore();
		}
		return total;
	}
	public int flavorScore(){
		int total = 0;
		for (Ingredient i : ingredients) {
			total += i.flavorScore();
		}
		return total;
	}
	public int textureScore(){
		int total = 0;
		for (Ingredient i : ingredients) {
			total += i.textureScore();
		}
		return total;
	}
	public int totalScore(){
		return  capacityScore() *
				durabilityScore() *
				flavorScore() *
				textureScore();
	}
}
