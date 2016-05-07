package adventOfCode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import adventOfCode.day15.Ingredient;
import adventOfCode.day15.Recipe;
import adventOfCode.day15.RecipeMaker;
import adventOfCode.day15.Spoon;

public class Day15Test{
	protected final int caloriesTarget = 500;
	protected final int totalSpoons = 100;
	protected Map<String, Spoon> buildQuantitiesMap(String quant) {
		Map<String,Spoon> quantities = new HashMap<String,Spoon>();
		String[] q = quant.split(",");
		for (String string : q) {
			String[] ingr = string.split(": ");
			quantities.put(ingr[0], new Spoon(Integer.parseInt(ingr[1])));
		}
		return quantities;
	}
	public static class Generic extends Day15Test{
		@Test
		public void ingredient() {
			ingredientScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					, (totalSpoons*-1),(totalSpoons*-2),(totalSpoons*6),(totalSpoons*3),(totalSpoons*8));
			ingredientScoreFor("shuggar: capacity 2, durability 3, flavor 4, texture 5, calories 6"
					,(totalSpoons*2),(totalSpoons*3),(totalSpoons*4),(totalSpoons*5),(totalSpoons*6));
		}
		@Test
		public void recipe(){
			recipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					,"Butterscotch: 100"
					,0,(totalSpoons*8));
			recipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
					,"Butterscotch: 44,Cinnamon: 56"
					,62842880,((44*8)+(56*3)));
		}
		
		private void ingredientScoreFor(String ingredient, int capacity, int durability, int flavor, int texture, int calories) {
			int spoons = 100;
			Ingredient i = new Ingredient(ingredient, spoons);
			assertEquals(capacity,i.capacityScore());
			assertEquals(durability,i.durabilityScore());
			assertEquals(flavor,i.flavorScore());
			assertEquals(texture,i.textureScore());
			assertEquals(calories,i.caloriesScore());
		}
		
		private void recipeScoreFor(String ingredients, String quantities, int total,int caloriesScore) {
			Recipe r = new Recipe(ingredients);
			r.newQuantities(buildQuantitiesMap(quantities));
			assertEquals(total,r.totalScore());
			assertEquals(caloriesScore,r.caloriesScore());
		}
		
	}
	public static class Part1 extends Day15Test{
		@Test
		public void BestRecipe(){
			bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					,"Butterscotch: 100");
			bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
					,"Butterscotch: 44,Cinnamon: 56");
			bestRecipeFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					,"A: 37,B: 63");
			bestRecipeFor("A: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					,"A: 63,B: 37");
			bestRecipeFor("Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
					+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
					+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
					+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1"
					,"Frosting: 24,Candy: 29,Butterscotch: 31,Sugar: 16");
		}
		@Test
		public void highestScore(){
			highestScoreFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					,56409600);
			highestScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
					,62842880);
			highestScoreFor("Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
					+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
					+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
					+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1"
					,18965440);
		}
		private void bestRecipeFor(String ingredients, String expectedA) {
			RecipeMaker r = new RecipeMaker(ingredients);
			r.findBestRecipe();
			Map<String,Spoon> actualA = r.getArrangement();
			for(String i : expectedA.split(",")){
				String ai[] = i.split(": ");
				int expected = Integer.parseInt(ai[1]);
				int actual = actualA.get(ai[0]).quantity;
				assertEquals(expected,actual);
			}		
		}
		private void highestScoreFor(String ingredients, int expected) {
			RecipeMaker r = new RecipeMaker(ingredients);
			r.findBestRecipe();
			int actual = r.totalScore();
			assertEquals(expected,actual);
		}
	}
	public static class Part2 extends Day15Test{

		@Test
		public void exactCaloriesBestRecipe(){
			exactCaloriesbestRecipeFor("A: capacity 1, durability -1, flavor 2, texture 3, calories 5",500,"A: 100");
			
			exactCaloriesbestRecipeFor( "A: capacity 2, durability 1, flavor 2, texture 3, calories 8"
									+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 3"
					,caloriesTarget,"A: 40,B: 60");
			
			exactCaloriesbestRecipeFor("Alphajor: capacity -1, durability -2, flavor 6, texture 3, calories 7"
									+ "\nButterscotch: capacity 2, durability 3, flavor 1, texture -2, calories 9"
									+ "\nCinnamon: capacity 4, durability 3, flavor -1, texture 1, calories 3"
					, caloriesTarget,"Alphajor: 35,Butterscotch: 10,Cinnamon: 55");
		}
		
		@Test
		public void exactCaloriesHighestScore(){
			exactCaloriesHighestScoreFor("A: capacity 1, durability -1, flavor 2, texture 3, calories 5",500,0);
			
			exactCaloriesHighestScoreFor("A: capacity 2, durability 1, flavor 2, texture 3, calories 8"
					+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 3"
					,caloriesTarget,158400000);
			
			exactCaloriesHighestScoreFor("Alphajor: capacity -1, durability -2, flavor 6, texture 3, calories 7"
					+ "\nButterscotch: capacity 2, durability 3, flavor 1, texture -2, calories 9"
					+ "\nCinnamon: capacity 4, durability 3, flavor -1, texture 1, calories 3"
					,caloriesTarget,591937500);
		}
		@Test
		public void challengeTest(){
			String recipe = "Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
					+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
					+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
					+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1";
			exactCaloriesHighestScoreFor(recipe, caloriesTarget, 15862900);
			exactCaloriesbestRecipeFor(recipe, caloriesTarget, "");
			
		}
		
		private void exactCaloriesbestRecipeFor(String ingredients, int calories, String expectedA) {
			RecipeMaker r = new RecipeMaker(ingredients, calories);
			r.findBestRecipe();
			Map<String,Spoon> actualA = r.getArrangement();
			for(String i : expectedA.split(",")){
				String ai[] = i.split(": ");
				int expected = Integer.parseInt(ai[1]);
				int actual = actualA.get(ai[0]).quantity;
				assertEquals(actualA.toString(),expected,actual);
			}	
		}
		private void exactCaloriesHighestScoreFor(String ingredients,int calories, int expected) {
			RecipeMaker r = new RecipeMaker(ingredients, calories);
			r.findBestRecipe();
			int actual = r.totalScore();
			assertEquals(expected,actual);
		}
	}
}