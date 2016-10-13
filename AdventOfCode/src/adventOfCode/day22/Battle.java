package adventOfCode.day22;

import java.util.ArrayList;
import java.util.List;

public class Battle {

	private Wizard wizard;
	private Boss boss;
	private int spell;
	private List<State> history;
	private int spent;
	private final int STRONGER_SPELL = 2;
	private int shieldTurns;

	public Battle(Wizard wizard, Boss boss) {
		this.wizard = wizard;
		this.boss = boss;
		this.spell = 0;
		this.spent = 0;
		this.shieldTurns = 0;
		this.history = new ArrayList<State>();
	}

	public int manaSpent() {
		boolean wizardWon = false;
		while(!wizardWon){
			recordState();
			
			applyEffects();
			wizardAttack();
			
			if(boss.health <= 0)
				wizardWon = true;
			
			applyEffects();
			bossAttack();
			nextStep(wizardWon);
		}
		return spent;
	}

	private void applyEffects() {
		if(shieldTurns > 0)
			shieldTurns--;
		else
			wizard.armor = 0;
	}

	private void nextStep(boolean wizardWon) {
		if(!wizardWon && wizard.health <= 0)
			tryMoreMana();
		else
			spell = 0;
	}

	private void wizardAttack() {
		if(spell == 0){//missile
			boss.health -= 4;
			spent += 53;
		}
		else if(spell == 1){///drain
			boss.health -= 2;
			wizard.health += 2;
			spent += 73;
		}
		else{//shield
			if(shieldTurns == 0){
				wizard.armor = 7;
				shieldTurns = 6;
				spent += 113;
			}
			else
				wizard.health = 0;
		}
	}

	private void bossAttack() {
		int calculatedDamage = boss.damage - wizard.armor;
		int realDamage = (calculatedDamage > 1)? calculatedDamage: 1;
		wizard.health -= realDamage;
	}

	private void recordState() {
		history.add(currentState());
	}

	private State currentState() {
		State current = new State();
		current.boss = new Boss(boss);
		current.wizard = new Wizard(wizard);
		current.spent = spent;
		current.spell = spell;
		current.shieldTurns = shieldTurns;
		return current;
	}

	private void tryMoreMana() {
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
		spent = state.spent;
		spell = state.spell;
		shieldTurns = state.shieldTurns;
	}

	private State lastToIncrease() {
		int steps = 1;
		State s = history.get(history.size()-steps);
		while (s.spell == STRONGER_SPELL)
			s = history.get(history.size()- ++steps);
		return s;
	}

	private class State{
		public int shieldTurns;
		public Wizard wizard;
		public Boss boss;
		public int spent;
		public int spell;
		
		public String toString(){
			String s = "" 
					+" spell:"+spell
					+" spent:"+spent
					+" shieldTurns:"+shieldTurns
					+" boss("+boss+")"
					+" wizard("+wizard+")"
					;
			return s;
		}
	}

}
