package adventOfCode.day22;

public class Poison extends Spell{
	public Poison(){
		this.turns = 6;
		this.cost = 173;
	}
	@Override
	public Spell next() {
		return new Recharge();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		if(success){
		}
		return success;
	}

	@Override
	public void applyEffect(State state) {
		turns--;
		state.boss.health -= 3;
	}
}
