package adventOfCode.day22;

public class Missile extends Spell{
	public Missile(){
		this.cost = 53;
	}
	@Override
	public Spell next() {
		return new Drain();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		state.boss.health -= 4;
		return success;
	}	
}
