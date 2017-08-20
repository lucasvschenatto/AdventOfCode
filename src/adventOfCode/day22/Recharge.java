package adventOfCode.day22;

public class Recharge extends Spell {
	
	public Recharge(){
		this.turns = 5;
		this.cost = 229;
	}

	@Override
	public Spell next() {
		return new Spell();
	}

	@Override
	public boolean cast(State state) {
		return super.cast(state);
	}

	@Override
	public void applyEffect(State state) {
		turns--;
		state.wizard.mana += 101;
	}
}
