package adventOfCode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import adventOfCode.day15.Ingredient;
import adventOfCode.day15.Recipe;
import adventOfCode.day15.RecipeMaker;

public class Day15Test {

	@Test
	public void ingredient() {
		ingredientScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",(100*-1),(100*-2),(100*6),(100*3));
		ingredientScoreFor("shuggar: capacity 2, durability 3, flavor 4, texture 5, calories 6",(100*2),(100*3),(100*4),(100*5));
	}
	@Test
	public void recipe(){
		recipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8","Butterscotch:100",0);
		recipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
				+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3","Butterscotch:44,Cinnamon:56",62842880);
	}
	@Test
	public void findBestRecipe(){
		bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8","100");
	}

	private void bestRecipeFor(String ingredients, String expected) {
		RecipeMaker r = new RecipeMaker(ingredients);
		String actual = r.mostDeliciousQuantities();
		assertEquals(expected,actual);
		
	}
	private void recipeScoreFor(String ingredients, String quantities, int total) {
		Recipe r = new Recipe(ingredients);
		r.newQuantities(buildQuantitiesMap(quantities));
		assertEquals(total,r.totalScore());
	}
	private Map<String, Integer> buildQuantitiesMap(String quant) {
		Map<String,Integer> quantities = new HashMap<String,Integer>();
		String[] q = quant.split(",");
		for (String string : q) {
			String[] ingr = string.split(":");
			quantities.put(ingr[0], Integer.valueOf(ingr[1]));
		}
		return quantities;
	}
	private void ingredientScoreFor(String ingredient, int capacity, int durability, int flavor, int texture) {
		int spoons = 100;
		Ingredient i = new Ingredient(ingredient, spoons);
		assertEquals(capacity,i.capacityScore());
		assertEquals(durability,i.durabilityScore());
		assertEquals(flavor,i.flavorScore());
		assertEquals(texture,i.textureScore());		
	}

}
