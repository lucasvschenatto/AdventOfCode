package adventOfCode.day22;

public class Poison extends Spell{
	public Poison(){
		turns = 6;
		cost = 173;
	}
	@Override
	public Spell next() {
		return new Recharge();
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
		state.boss.health -= 3;
	}
	@Override
	public Spell clone() {
		Poison p = new Poison();
		p.turns = this.turns;
		return p;
	}
	public String toString(){
		return super.toString()+"-"+turns;
	}
}
