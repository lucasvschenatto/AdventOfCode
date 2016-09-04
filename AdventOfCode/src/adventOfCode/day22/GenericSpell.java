package adventOfCode.day22;

public abstract class GenericSpell implements Spell {
	protected int cost;
	protected int turns;
	protected GenericSpell(int cost, int turns){
		this.cost = cost;
		this.turns = turns;
	}
	public int getCost()  {return cost;}
	public int getTurns() {return turns;}
}
