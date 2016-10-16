package adventOfCode.day22;

public class Recharge extends Spell {
	
	public Recharge(){
		turns = 5;
	}
	@Override
	public int getCost() {
		return 229;
	}

	@Override
	public Spell next(int remainingMana) {
		return new Missile();
	}

	@Override
	public int cast(Wizard wizard, Boss boss) {
		wizard.mana -= getCost();
		return getCost();
	}

	@Override
	public boolean isActive() {
		return turns > 0;
	}

	@Override
	public void applyEffect(Wizard wizard, Boss boss) {
		turns--;
		wizard.mana += 101;
	}

	@Override
	public Spell clone() {
		Recharge r = new Recharge();
		r.turns = this.turns;
		return r;
	}

}
