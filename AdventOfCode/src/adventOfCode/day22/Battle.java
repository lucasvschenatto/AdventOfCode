package adventOfCode.day22;

import java.util.ArrayList;
import java.util.List;

public class Battle {
//	private boolean wizardWon;
//	private Wizard wizard;
//	private Boss boss;
//	private Spell spell;
//	private List<State> history;
//	private int manaSpent;
//	private int limit;
//	private boolean over;
//	private List<Spell> effects;
//
//	public Battle(Wizard wizard, Boss boss) {
//		this(wizard,boss,Integer.MAX_VALUE);
//	}
//
//	public Battle(Wizard wizard, Boss boss, int limit) {
//		this.wizard      = new Wizard(wizard);
//		this.boss        = new Boss(boss);
//		this.history     = new ArrayList<State>();
//		this.effects     = new ArrayList<Spell>();
//		this.spell       = Spell.first();
//		this.manaSpent   = 0;
//		this.limit       = limit;
//	}
//
//	public boolean wizardWin() {
//			fight();
//			return wizardWon;
//		}
//
//	public int getManaSpent() {
//		fight();
//		return manaSpent;
//	}
//
//	private void fight() {
//		if(wizard.mana >= spell.getCost())
//			while(!wizardWon && !over){
//				nextStep();
//				if(!wizardWon && !over){
//					recordState();
//					
//					applyEffects();
//					wizardAttack();
//					
//					applyEffects();
//					bossAttack();
//				}
//			}
//		over = true;
//	}
//
//	private void applyEffects() {
//		for(Spell active: effects)
//			active.applyEffect(wizard, boss);
//		effects.removeIf((effect)->!effect.isActive());
//		
//	}
//
//	private void nextStep() {
//		if(boss.health <= 0 && manaSpent <= limit)
//			wizardWon = over = true;
//		if((!wizardWon && wizard.health <= 0) || manaSpent >= limit)
//			tryOtherWay();
//		else
//			spell = Spell.first();
//		if(spell.getCost() > wizard.mana)
//			over = true;
//	}
//
//	private void wizardAttack() {
//		manaSpent += spell.cast(wizard, boss);
//		if(spell.isActive())
//			effects.add(spell);
//	}
//
//	private void bossAttack() {
//		int calculatedDamage = boss.damage - wizard.armor;
//		int realDamage = calculatedDamage>1? calculatedDamage : 1;
//		wizard.health -= realDamage;
//	}
//
//	private void recordState() {
//		history.add(currentState());
//	}
//
//	private State currentState() {
//		State current = new State();
//		current.boss = new Boss(boss);
//		current.wizard = new Wizard(wizard);
//		current.effects = new ArrayList<Spell>();
//		current.spent = manaSpent;
//		current.spell = spell;
//		effects.forEach((effect)->current.effects.add(effect.clone()));
//		return current;
//	}
//
//	private void tryOtherWay() {
//		State state = lastToIncrease();
//		int currentIndex = history.indexOf(state);
//		for(int i = history.size()-1;i >= currentIndex; i--)
//			history.remove(i);
//		goToState(state);
//		spell = spell.next(wizard.mana);
//	}
//	
//	private void goToState(State state) {
//		wizard = state.wizard;
//		boss = state.boss;
//		manaSpent = state.spent;
//		spell = state.spell;
//		effects = state.effects;
//	}
//
//	private State lastToIncrease() {
//		State s = history.get(history.size()-1);
//		int backward = 1;
//		while (s.spell instanceof Poison && !over){
//			int step = history.size()- ++backward;
//			if(step >= 0)
//				s = history.get(step);
//			else
//				over = true;
//		}
//		return s;
//	}
//
//	private class State{
//		public List<Spell> effects;
//		public Wizard wizard;
//		public Boss boss;
//		public int spent;
//		public Spell spell;
//		
//		public String toString(){
//			String s = "" 
//					+" spell:"+spell
//					+" spent:"+spent
//					+" boss("+boss+")"
//					+" wizard("+wizard+")"
//					;
//			return s;
//		}
//	}
//
//	public String describeHistory() {
//		return history.toString();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean wizardWon;
	private Wizard wizard;
	private Boss boss;
	private int spell;
	private List<State> history;
	private int manaSpent;
	private final int STRONGER_SPELL = 4;
	private int shieldTurns;
	private int limit;
	private boolean over;
	private int poisonTurns;
	private int rechargeTurns;
	private boolean impossibleSpell;

	public Battle(Wizard wizard, Boss boss) {
		this(wizard,boss,Integer.MAX_VALUE);
	}

	public Battle(Wizard wizard, Boss boss, int limit) {
		this.wizard      = new Wizard(wizard);
		this.boss        = new Boss(boss);
		this.history     = new ArrayList<State>();
		this.spell       = 0;
		this.manaSpent   = 0;
		this.shieldTurns = 0;
		this.limit       = limit;
	}

	public boolean wizardWin() {
			fight();
			return wizardWon;
		}

	public int getManaSpent() {
		fight();
		return manaSpent;
	}

	private void fight() {
		while(!wizardWon && !over){
			recordState();
			
			applyEffects();
			wizardAttack();
			
			applyEffects();
			bossAttack();
			
			nextStep();
		}
		over = true;
	}

	private void applyEffects() {
		if(shieldTurns > 0)
			shieldTurns--;
		else
			wizard.armor = 0;
		if(poisonTurns > 0){
			poisonTurns--;
			boss.health -= 3;
		}
		if(rechargeTurns > 0){
			rechargeTurns--;
			wizard.mana += 101;
		}
		
	}

	private void nextStep() {
		if(impossibleSpell){
			tryOtherWay();
			impossibleSpell = false;
		}
		else if(boss.health <= 0 && manaSpent <= limit)
			wizardWon = over = true;
		else if((!wizardWon && wizard.health <= 0) || manaSpent >= limit || wizard.mana < 53)
			tryOtherWay();
		else
			spell = 0;
	}

	private void wizardAttack() {
		if(spell == 0){//missile
			boss.health -= 4;
			manaSpent += 53;
			wizard.mana -= 53;
		}
		else if(spell == 1){///drain
			boss.health -= 2;
			wizard.health += 2;
			manaSpent += 73;
			wizard.mana -= 73;
		}
		else if(spell == 2){//shield
			if(shieldTurns == 0){
				wizard.armor = 7;
				shieldTurns = 6;
				manaSpent += 113;
				wizard.mana -= 113;
			}
			else
				impossibleSpell = true;
		}
		else if(spell == 3){//poison
			if(poisonTurns == 0){
				poisonTurns = 6;
				manaSpent += 173;
				wizard.mana -= 173;
			}
			else
				impossibleSpell = true;
		}
		else{//recharge
			if(rechargeTurns == 0){
				rechargeTurns = 5;
				manaSpent += 229;
				wizard.mana -= 229;
			}
			else
				impossibleSpell = true;
		}
	}

	private void bossAttack() {
		int calculatedDamage = boss.damage - wizard.armor;
		int realDamage = calculatedDamage>1? calculatedDamage : 1;
		wizard.health -= realDamage;
	}

	private void recordState() {
		history.add(currentState());
	}

	private State currentState() {
		State current = new State();
		current.boss = new Boss(boss);
		current.wizard = new Wizard(wizard);
		current.spent = manaSpent;
		current.spell = spell;
		current.shieldTurns = shieldTurns;
		current.poisonTurns = poisonTurns;
		current.rechargeTurns = rechargeTurns;
		return current;
	}

	private void tryOtherWay() {
		State state = lastToIncrease();
		int currentIndex = history.indexOf(state);
		for(int i = history.size()-1;i >= currentIndex; i--)
			history.remove(i);
		goToState(state);
		spell++;
	}
	
	private void goToState(State state) {
		wizard = state.wizard;
		boss = state.boss;
		manaSpent = state.spent;
		spell = state.spell;
		shieldTurns = state.shieldTurns;
		poisonTurns = state.poisonTurns;
		rechargeTurns = state.rechargeTurns;
	}

	private State lastToIncrease() {
		State s = history.get(history.size()-1);
		int backward = 1;
		while (s.spell == STRONGER_SPELL && !over){
			int step = history.size()- ++backward;
			if(step >= 0)
				s = history.get(step);
			else
				over = true;
		}
		return s;
	}

	private class State{
		public int shieldTurns;
		public int poisonTurns;
		public int rechargeTurns;
		public Wizard wizard;
		public Boss boss;
		public int spent;
		public int spell;
		
		public String toString(){
			String s = "" 
					+" spell:"+spell
					+" spent:"+spent
					+" shieldTurns:"+shieldTurns
					+" poisonTurns:"+poisonTurns
					+" rechargeTurns:"+rechargeTurns
					+" boss("+boss+")"
					+" wizard("+wizard+")"
					;
			return s;
		}
	}

	public String describeHistory() {
		return history.toString();
	}

}
