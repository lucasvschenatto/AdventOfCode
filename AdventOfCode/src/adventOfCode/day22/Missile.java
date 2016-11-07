package adventOfCode.day22;

public class Missile extends Spell{
	public Missile(){
		cost = 53;
	}
	@Override
	public Spell next() {
		return new Drain();
	}

	@Override
	public boolean cast(State state) {
		boolean success = super.cast(state);
		state.wizard.mana -= cost;
		state.spent += cost;
		state.boss.health -= 4;
		return success;
	}
	
	private class Drain extends Spell{
		public Drain(){
			cost = 73;
		}
		@Override
		public Spell next() {
			return new Shield();
		}

		@Override
		public boolean cast(State state) {
			boolean success = super.cast(state);
			state.spent += cost;
			state.wizard.mana -= cost;
			state.wizard.health += 2;
			state.boss.health -= 2;
			return success;
		}
		public String toString(){
			return super.toString()+"-"+turns;
		}
	}
	public class Shield extends Spell{
		public Shield(){
			turns = 6;
			cost = 113;
		}
		@Override
		public Spell next() {
			return new Poison();
		}

		@Override
		public boolean cast(State state) {
			boolean success = super.cast(state);
			if(success){
				state.spent += cost;
				state.wizard.mana -= cost;
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
		@Override
		public Spell clone() {
			Shield s = new Shield();
			s.turns = this.turns;
			return s;
		}
		public String toString(){
			return super.toString()+"-"+turns;
		}
	}
	
}
