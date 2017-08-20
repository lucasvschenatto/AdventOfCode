package adventOfCode.day22;

import java.util.ArrayList;
import java.util.List;

public class State{
	public List<Spell> activeSpells;
	public Wizard wizard;
	public Boss boss;
	public int spent;
	public Spell spell;
	public int limit;
	
	public State(State old) {
		this.activeSpells = copyList(old.activeSpells);
		this.wizard = new Wizard(old.wizard);
		this.boss   = new Boss(old.boss);
		this.spent  = old.spent;
		this.spell  = old.spell;
		this.limit  = old.limit;
	}

	private List<Spell> copyList(List<Spell> old) {
		List<Spell> l = new ArrayList<Spell>();
		for(Spell s: old){
			l.add(s.clone());
		}
		return l;
	}
	public State(Wizard wizard, Boss boss, int limit) {
		this.activeSpells = new ArrayList<Spell>();
		this.wizard      = new Wizard(wizard);
		this.boss        = new Boss(boss);
		this.spell       = Spell.first();
		this.spent       = 0;
		this.limit       = limit;
	}

	public boolean didWizardWin() {
		return boss.health <= 0 && spent <= limit;
	}
	public boolean didWizardLoose() {
		return didBossWin() || didOverflowManaLimit() || notEnoughtMana();
	}
	private boolean didOverflowManaLimit() {
		return spent >= limit;
	}
	private boolean notEnoughtMana() {
		return wizard.mana < 53;
	}
	private boolean didBossWin() {
		return wizard.health <= 0;
	}
	public void applyEffects() {
		for(Spell s: activeSpells){
			if(s.turns > 0)
				s.applyEffect(this);
		}
		activeSpells.removeIf( (spell)->spell.turns == 0 );
	}
	public boolean wizardAttack() {
		return spell.cast(this);
	}
	public void bossAttack() {
		int calculatedDamage = boss.damage - wizard.armor;
		int realDamage = calculatedDamage>1? calculatedDamage : 1;
		wizard.health -= realDamage;
	}
}