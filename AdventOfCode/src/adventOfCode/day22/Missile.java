package adventOfCode.day22;

public class Missile extends Spell{
	@Override
	public int getCost() {
		return 53;
	}
	@Override
	public Spell next(int remainingMana) {
		return new Drain();
	}

	@Override
	public int cast(Wizard wizard, Boss boss) {
		wizard.mana -= getCost();
		boss.health -= 4;
		return getCost();
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public void applyEffect(Wizard wizard, Boss boss) {}
	
	
	@Override
	public Spell clone() {
		return new Missile();
	}


	private class Drain extends Spell{
		@Override
		public int getCost() {
			return 73;
		}
		@Override
		public Spell next(int remainingMana) {
			return new Shield();
		}

		@Override
		public int cast(Wizard wizard, Boss boss) {
			wizard.mana -= getCost();
			boss.health -= 2;
			wizard.health += 2;
			return getCost();
		}

		@Override
		public boolean isActive() {
			return false;
		}

		@Override
		public void applyEffect(Wizard wizard, Boss boss) {}

		@Override
		public Spell clone() {
			return new Drain();
		}
	}
	private class Shield extends Spell{
		public Shield(){
			turns = 6;
		}

		@Override
		public int getCost() {
			return 113;
		}
		@Override
		public Spell next(int remainingMana) {
			return new Poison();
		}

		@Override
		public int cast(Wizard wizard, Boss boss) {
			wizard.mana -= getCost();
			wizard.armor = 7;
			return getCost();
		}

		@Override
		public boolean isActive() {
			return turns > 0;
		}

		@Override
		public void applyEffect(Wizard wizard, Boss boss) {
			turns--;
			if(turns == 0)
				wizard.armor = 0;
		}
		@Override
		public Spell clone() {
			Shield s = new Shield();
			s.turns = this.turns;
			return s;
		}
	}
	
}
