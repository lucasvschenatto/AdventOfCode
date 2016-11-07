package adventOfCode.day22;

public class Recharge extends Spell {
	
	public Recharge(){
		turns = 5;
		cost = 229;
	}

	@Override
	public Spell next() {
		return new Spell();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		if(success){
			state.wizard.mana -= cost;
			state.spent += cost;
		}
		return success;
	}

	@Override
	public void applyEffect(State state) {
		turns--;
		state.wizard.mana += 101;
	}

	@Override
	public Spell clone() {
		Recharge r = new Recharge();
		r.turns = this.turns;
		return r;
	}
	public String toString(){
		return super.toString()+"-"+turns;
	}

}
