package adventOfCode.day22;

public class Poison extends Spell{
	public Poison(){
		turns = 6;
	}
	@Override
	public Spell next(int remainingMana) {
		return new Recharge();
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
		boss.health -= 3;
	}
	@Override
	public Spell clone() {
		Poison p = new Poison();
		p.turns = this.turns;
		return p;
	}
	@Override
	public int getCost() {
		return 173;
	}
}
