package adventOfCode.day22;

public class Drain extends Spell{
	public Drain(){
		this.cost = 73;
	}
	@Override
	public Spell next() {
		return new Shield();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		state.wizard.health += 2;
		state.boss.health -= 2;
		return success;
	}
}