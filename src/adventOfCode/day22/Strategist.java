package adventOfCode.day22;

public class Strategist {
	
	private Wizard wizard;
	private Boss boss;
	
	public Strategist(Wizard wizard, Boss boss) {
		this.wizard = wizard;
		this.boss = boss;
	}

	public int leastManaNeeded() {
		Battle battle = new Battle(wizard,boss);
		int mana;
		int newMana;
		
		do {
			mana    = battle.getManaSpent();
			newMana = mana-1;
			battle  = new Battle(wizard,boss,newMana);
		} while (newMana>=Spell.first().cost && battle.wizardWin());

		return mana;
	}
}
