package adventOfCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.*;

import adventOfCode.day15.ExactCalories;
import adventOfCode.day15.Ingredient;
import adventOfCode.day15.Recipe;
import adventOfCode.day15.RecipeMaker;
import adventOfCode.day15.Spoon;

public class Day15Test{
	protected static final int calories = 500;
	public static class Generic extends Day15Test{
		private final int spoons = 100;
		@Test
		public void ingredient() {
			ingredientScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					, (spoons*-1),(spoons*-2),(spoons*6),(spoons*3),(spoons*8));
			ingredientScoreFor("shuggar: capacity 2, durability 3, flavor 4, texture 5, calories 6"
					,(spoons*2),(spoons*3),(spoons*4),(spoons*5),(spoons*6));
		}
		@Test
		public void recipe(){
			recipeScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					,"Butterscotch: 100"
					,0,(spoons*8));
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
		
		private Map<String, Spoon> buildQuantitiesMap(String quant) {
			Map<String,Spoon> quantities = new HashMap<String,Spoon>();
			String[] q = quant.split(",");
			for (String string : q) {
				String[] ingr = string.split(": ");
				quantities.put(ingr[0], new Spoon(Integer.parseInt(ingr[1])));
			}
			return quantities;
		}
	}
	public static class RecipeTests extends Day15Test{
		static String lastRecipe;
		static int lastCalories;
		static RecipeMaker exactCaloriesMaker;
		protected void bestRecipeFor(String ingredients, String expectedA) {
			RecipeMaker r = RecipeMaker.create(ingredients);
			r.findBestRecipe();
			Map<String,Spoon> actualA = r.getArrangement();
			for(String i : expectedA.split(", ")){
				String ai[] = i.split(": ");
				int expected = Integer.parseInt(ai[1]);
				int actual = actualA.get(ai[0]).quantity;
				assertEquals(expected,actual);
			}
		}
		protected void highestScoreFor(String ingredients, int expected) {
			RecipeMaker r = RecipeMaker.create(ingredients);
			r.findBestRecipe();
			int actual = r.totalScore();
			assertEquals(expected,actual);
		}
		
		protected void exactCaloriesbestRecipeFor(String ingredients, int calories, String expectedA) {
			findBestRecipe(ingredients, calories);
			Map<String,Spoon> actualA = exactCaloriesMaker.getArrangement();
			for(String i : expectedA.split(", ")){
				String ai[] = i.split(": ");
				int expected = Integer.parseInt(ai[1]);
				int actual = actualA.get(ai[0]).quantity;
				assertEquals(actualA.toString(),expected,actual);
			}	
		}
		protected void exactCaloriesHighestScoreFor(String ingredients,int calories, int expected) {
			findBestRecipe(ingredients, calories);
			int actual = exactCaloriesMaker.totalScore();
			assertEquals(expected,actual);
		}
		private void findBestRecipe(String ingredients, int calories){
			if(lastCalories != calories || !lastRecipe.equals(ingredients)){
				lastCalories = calories;
				lastRecipe = ingredients;
				exactCaloriesMaker = RecipeMaker.create(ingredients, calories);
				exactCaloriesMaker.findBestRecipe();
			}
		}
		
	}
	public static class Challenge extends RecipeTests{
		private String recipe = "Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5"
				+"\nCandy: capacity 0, durability 5, flavor -1, texture 0, calories 8"
				+"\nButterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6"
				+"\nSugar: capacity 0, durability 0, flavor -2, texture 2, calories 1";
		@Test
		public void part1BestRecipe(){
			bestRecipeFor(recipe,"Frosting: 24, Candy: 29, Butterscotch: 31, Sugar: 16");
		}
		@Test
		public void part1HighestScore(){
			highestScoreFor(recipe, 18965440);
		}
		@Test
		public void part2BestRecipe(){
			exactCaloriesbestRecipeFor(recipe,calories
					,"Frosting: 21, Candy: 23, Butterscotch: 31, Sugar: 25");
		}
		@Test
		public void part2HighestScore(){
			exactCaloriesHighestScoreFor(recipe, calories, 15862900);
		}
	}
	public static class Part1 extends RecipeTests{
		@Test
		public void BestRecipe(){
			bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					,"Butterscotch: 100");
			bestRecipeFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
					,"Butterscotch: 44, Cinnamon: 56");
			bestRecipeFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					,"A: 37, B: 63");
			bestRecipeFor("A: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					,"A: 63, B: 37");
		}
		@Test
		public void highestScore(){
			highestScoreFor("A: capacity -1, durability 3, flavor 2, texture 1, calories 1"
					+ "\nB: capacity 1, durability -1, flavor 2, texture 3, calories 1"
					,56409600);
			highestScoreFor("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
					+ "\nCinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"
					,62842880);
		}
		
	}
	public static class Part2 extends RecipeTests{
		private String one = "A: capacity 1, durability -1, flavor 2, texture 3, calories 5";
		private String two = "A: capacity 2, durability 1, flavor 2, texture 3, calories 8"
				+ "\nB: capacity -1, durability 3, flavor 2, texture 1, calories 3";
		private String three = "Alphajor: capacity -1, durability -2, flavor 6, texture 3, calories 7"
				+ "\nButterscotch: capacity 2, durability 3, flavor 1, texture -2, calories 9"
				+ "\nCinnamon: capacity 4, durability 3, flavor -1, texture 1, calories 3";
		private List<String> ingredients = Arrays.asList("01","02","03","04");
		@Test
		public void exactCaloriesBestRecipe(){
			exactCaloriesbestRecipeFor(one,500,"A: 100");			
			exactCaloriesbestRecipeFor( two,calories,"A: 40, B: 60");			
			exactCaloriesbestRecipeFor(three, calories,"Alphajor: 35, Butterscotch: 10, Cinnamon: 55");
		}
		
		@Test
		public void exactCaloriesHighestScore(){
			exactCaloriesHighestScoreFor(one,500,0);			
			exactCaloriesHighestScoreFor(two,calories,158400000);			
			exactCaloriesHighestScoreFor(three,calories,591937500);
		}
		@Test
		public void increase(){
			increaseFor(Arrays.asList(0,0,0,0),Arrays.asList(1,0,0,0));
			increaseFor(Arrays.asList(2,0,0,0),Arrays.asList(3,0,0,0));
			increaseFor(Arrays.asList(99,0,0,0),Arrays.asList(100,0,0,0));
			increaseFor(Arrays.asList(100,0,0,0),Arrays.asList(0,1,0,0));
			increaseFor(Arrays.asList(0,1,0,0),Arrays.asList(1,1,0,0));
			increaseFor(Arrays.asList(1,1,0,0),Arrays.asList(2,1,0,0));
			increaseFor(Arrays.asList(99,1,0,0),Arrays.asList(0,2,0,0));
			increaseFor(Arrays.asList(0,2,0,0),Arrays.asList(1,2,0,0));
			increaseFor(Arrays.asList(98,2,0,0),Arrays.asList(0,3,0,0));
			increaseFor(Arrays.asList(1,99,0,0),Arrays.asList(0,100,0,0));
			increaseFor(Arrays.asList(0,100,0,0),Arrays.asList(0,0,1,0));
			increaseFor(Arrays.asList(1,1,97,1),Arrays.asList(0,2,97,1));	
			increaseFor(Arrays.asList(0,0,99,1),Arrays.asList(0,0,0,2));	
		}
		private void increaseFor(List<Integer> act, List<Integer> exp){
			Map<String,Spoon> actual = new HashMap<String,Spoon>();
			Map<String,Spoon> expected = new HashMap<String,Spoon>();
			Iterator<Integer> a = act.iterator();
			Iterator<Integer> e = exp.iterator();
			ingredients.forEach(ingredient -> actual.put(ingredient, new Spoon(a.next().intValue())));
			ingredients.forEach(ingredient -> expected.put(ingredient, new Spoon(e.next().intValue())));
			
			((ExactCalories) RecipeMaker.create(one, 0)).increase(actual);
			
			assertMap(expected,actual);
		}
		private void assertMap(Map<String, Spoon> expected, Map<String, Spoon> actual) {
			ingredients.forEach(ingredient ->
			assertEquals(ingredient,expected.get(ingredient).quantity,	actual.get(ingredient).quantity)
			);
		}
	}
}