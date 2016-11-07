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
	
	public State(){
		
	}
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
			else if (s instanceof Missile.Shield)
				wizard.armor = 0;
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
	
	public String toString(){
	String s = "\n" 
			+" spell:"+spell
			+" spent:"+spent
			+" activeSpells:"+activeSpells
			+" boss("+boss+")"
			+" wizard("+wizard+")"
			;
	return s;
}
	
	
	
	
//	public int shieldTurns;
//	public int poisonTurns;
//	public int rechargeTurns;
//	public List<Spell> activeSpells;
//	public Wizard wizard;
//	public Boss boss;
//	public int spent;
//	public int spell;
//	public int limit;
//	
//	public State(){
//		
//	}
//	public State(State old) {
//		this.activeSpells = old.activeSpells;
//		this.shieldTurns   = old.shieldTurns;
//		this.poisonTurns   = old.poisonTurns;
//		this.rechargeTurns = old.rechargeTurns;
//		this.wizard = new Wizard(old.wizard);
//		this.boss   = new Boss(old.boss);
//		this.spent  = old.spent;
//		this.spell  = old.spell;
//		this.limit  = old.limit;
//	}
//
//	public State(Wizard wizard, Boss boss, int limit) {
//		this.activeSpells = new ArrayList<Spell>();
//		this.wizard      = new Wizard(wizard);
//		this.boss        = new Boss(boss);
//		this.spell       = 0;
//		this.spent       = 0;
//		this.shieldTurns = 0;
//		this.limit       = limit;
//	}
//	public String toString(){
//		String s = "" 
//				+" spell:"+spell
//				+" spent:"+spent
//				+" shieldTurns:"+shieldTurns
//				+" poisonTurns:"+poisonTurns
//				+" rechargeTurns:"+rechargeTurns
//				+" boss("+boss+")"
//				+" wizard("+wizard+")"
//				;
//		return s;
//	}
//	public boolean didWizardWin() {
//		return boss.health <= 0 && spent <= limit;
//	}
//	public boolean didWizardLoose() {
//		return didBossWin() || didOverflowManaLimit() || notEnoughtMana();
//	}
//	private boolean didOverflowManaLimit() {
//		return spent >= limit;
//	}
//	private boolean notEnoughtMana() {
//		return wizard.mana < 53;
//	}
//	private boolean didBossWin() {
//		return wizard.health <= 0;
//	}
//	public void applyEffects() {
//		if(shieldTurns > 0)
//			shieldTurns--;
//		else
//			wizard.armor = 0;
//		if(poisonTurns > 0){
//			poisonTurns--;
//			boss.health -= 3;
//		}
//		if(rechargeTurns > 0){
//			rechargeTurns--;
//			wizard.mana += 101;
//		}
//	}
//	public boolean wizardAttack() {
//		if(spell == 0){//missile
//			boss.health -= 4;
//			spent += 53;
//			wizard.mana -= 53;
//		}
//		else if(spell == 1){///drain
//			boss.health -= 2;
//			wizard.health += 2;
//			spent += 73;
//			wizard.mana -= 73;
//		}
//		else if(spell == 2){//shield
//			if(shieldTurns == 0){
//				wizard.armor = 7;
//				shieldTurns = 6;
//				spent += 113;
//				wizard.mana -= 113;
//			}
//			else
//				return false;
//		}
//		else if(spell == 3){//poison
//			if(poisonTurns == 0){
//				poisonTurns = 6;
//				spent += 173;
//				wizard.mana -= 173;
//			}
//			else
//				return false;
//		}
//		else{//recharge
//			if(rechargeTurns == 0){
//				rechargeTurns = 5;
//				spent += 229;
//				wizard.mana -= 229;
//			}
//			else
//				return false;
//		}
//		return true;
//	}
//	public void bossAttack() {
//		int calculatedDamage = boss.damage - wizard.armor;
//		int realDamage = calculatedDamage>1? calculatedDamage : 1;
//		wizard.health -= realDamage;
//	}
}