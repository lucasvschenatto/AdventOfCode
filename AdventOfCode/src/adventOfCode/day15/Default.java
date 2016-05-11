package adventOfCode.day15;

public class Default extends RecipeMaker {
	Default(String ingredients){
		super(ingredients,0);
	}
	
	public void findBestRecipe() {
		if(caloriesTarget == 0)
			if(arrangement.size()>1)
				tryToImprove();
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
