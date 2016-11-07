package adventOfCode.day22;

public class Spell {
	protected int turns;
	protected int cost;
	public static Spell first(){
		return new Missile();
	}
	public Spell next(){
		return new Spell();
	}
	public boolean cast(State state){
		boolean success = state.wizard.mana >= cost;
		boolean found = false;
		for(Spell s: state.activeSpells){
			if(this.getClass().equals(s.getClass())){
				found = true;
				if(s.turns > 0)
					success = false;
			}
		}
		if(!found && this.turns > 0)
			state.activeSpells.add(this);
		return success;
	}
	public void applyEffect(State state){

	}
	public Spell clone(){
		Spell s = new Spell();
		s.turns = this.turns;
		return s;
	}
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
}
