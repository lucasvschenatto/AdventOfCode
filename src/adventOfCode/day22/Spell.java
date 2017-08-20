package adventOfCode.day22;

import java.lang.reflect.InvocationTargetException;

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
		if( state.wizard.mana >= cost){
			state.wizard.mana -= cost;
			state.spent += cost;
			boolean success = true;
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
		return false;
	}
	public void applyEffect(State state){

	}
	public Spell clone(){
		Spell clone = null;
		try {
			clone = this.getClass().getConstructor(null).newInstance(null);
			clone.turns = this.turns;
		} catch (Exception ignored) {}
		return clone;
	}
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
}
