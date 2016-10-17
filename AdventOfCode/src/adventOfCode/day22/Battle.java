package adventOfCode.day22;

import java.util.ArrayList;
import java.util.List;

public class Battle {
	private State current;
	private final int STRONGER_SPELL = 4;
	private boolean wizardWon;
	private List<State> history;
	private boolean over;
	private boolean enoughtMana;

	public Battle(Wizard wizard, Boss boss) {
		this(wizard,boss,Integer.MAX_VALUE);
	}

	public Battle(Wizard wizard, Boss boss, int limit) {
		this.current = new State(wizard,boss,limit);
		this.history = new ArrayList<State>();
	}

	public boolean wizardWin() {
			fight();
			return wizardWon;
		}

	public int getManaSpent() {
		fight();
		return current.spent;
	}

	private void fight() {
		while(!over){
			recordState();
			
			current.applyEffects();
			enoughtMana = current.wizardAttack();
			
			current.applyEffects();
			current.bossAttack();
			
			nextStep();
		}
		over = true;
	}

	private void nextStep() {
		if(!enoughtMana){
			tryOtherWay();
		}
		else if(current.didWizardWin())
			wizardWon = over = true;
		else if( current.didWizardLoose())
			tryOtherWay();
		else
			current.spell = 0;
	}

	private void recordState() {
		history.add(new State(current));
	}

	private void tryOtherWay() {
		State state = lastToIncrease();
		int currentIndex = history.indexOf(state);
		for(int i = history.size()-1;i >= currentIndex; i--)
			history.remove(i);
		current = state;
		current.spell++;
		enoughtMana = true;
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

	public String describeHistory() {
		return history.toString();
	}
}
