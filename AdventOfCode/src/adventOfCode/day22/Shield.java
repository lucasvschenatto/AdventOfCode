package adventOfCode.day22;

public class Shield extends Spell{
	public Shield(){
		this.turns = 6;
		this.cost = 113;
	}
	@Override
	public Spell next() {
		return new Poison();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		if(success){
			state.wizard.armor = 7;
		}
		return success;
	}

	@Override
	public void applyEffect(State state) {
		turns--;
		if(turns == 0)
			state.wizard.armor = 0;
	}
}
