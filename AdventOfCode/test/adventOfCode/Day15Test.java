package adventOfCode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import adventOfCode.day15.Ingredient;
import adventOfCode.day15.Recipe;
import adventOfCode.day15.RecipeMaker;
import adventOfCode.day15.Spoon;

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
				+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
				,"Butterscotch:44,Cinnamon:56",62842880);
	}
	@Test
	public void BestRecipe(){
		bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8","Butterscotch:100");
		bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
				+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
				,"Butterscotch:44,Cinnamon:56");
		bestRecipeFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
				+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
				,"A:37,B:63");
		bestRecipeFor("A: capacity 1, durability -1, flavor 2, texture 3, calories 1"
				+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 1"
				,"A:63,B:37");
		bestRecipeFor("Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
				+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
				+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
				+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1"
				,"Frosting:24,Candy:29,Butterscotch:31,Sugar:16");
	}
	
	@Test
	public void bestRecipeScore(){
		bestRecipeScoreFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
				+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
				,56409600);
		bestRecipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
				+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
				,62842880);
		bestRecipeScoreFor("Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
				+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
				+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
				+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1"
				,18965440);
	}

	private void bestRecipeScoreFor(String ingredients, int expected) {
		RecipeMaker r = new RecipeMaker(ingredients);
		int actual = r.bestRecipeScore();
		assertEquals(expected,actual);
	}
	private void bestRecipeFor(String ingredients, String expectedA) {
		RecipeMaker r = new RecipeMaker(ingredients);
		Map<String,Spoon> actualA = r.mostDeliciousArrangement();
		for(String i:expectedA.split(",")){
			int expected = Integer.parseInt(i.substring(i.indexOf(":")+1,i.length()));
			int actual = actualA.get(i.substring(0, i.indexOf(":"))).quantity;
			assertEquals(expected,actual);
		}		
	}
	private void recipeScoreFor(String ingredients, String quantities, int total) {
		Recipe r = new Recipe(ingredients);
		r.newQuantities(buildQuantitiesMap(quantities));
		assertEquals(total,r.totalScore());
	}
	private Map<String, Spoon> buildQuantitiesMap(String quant) {
		Map<String,Spoon> quantities = new HashMap<String,Spoon>();
		String[] q = quant.split(",");
		for (String string : q) {
			String[] ingr = string.split(":");
			quantities.put(ingr[0], new Spoon(Integer.parseInt(ingr[1])));
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
