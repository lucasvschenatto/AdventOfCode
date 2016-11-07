package adventOfCode.day22;

import java.util.ArrayList;
import java.util.List;

public class Battle {
	private State current;
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
		recordState();
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
			current.spell = Spell.first();
	}

	private void recordState() {
		history.add(new State(current));
	}

	private void tryOtherWay() {
		current = lastToChange();
		undoFrom(current);
		current.spell = current.spell.next();
		enoughtMana = true;
	}

	private void undoFrom(State state) {
		int currentIndex = history.indexOf(state);
		for(int i = history.size()-1;i >= currentIndex; i--)
			history.remove(i);
	}

	private State lastToChange() {
		State s = history.get(history.size()-1);
		for (int i = 2; s.spell instanceof Recharge && !over;i++){
			int step = history.size()- i;
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
//	private State current;
//	private final int STRONGER_SPELL = 4;
//	private boolean wizardWon;
//	private List<State> history;
//	private boolean over;
//	private boolean enoughtMana;
//
//	public Battle(Wizard wizard, Boss boss) {
//		this(wizard,boss,Integer.MAX_VALUE);
//	}
//
//	public Battle(Wizard wizard, Boss boss, int limit) {
//		this.current = new State(wizard,boss,limit);
//		this.history = new ArrayList<State>();
//	}
//
//	public boolean wizardWin() {
//		fight();
//		return wizardWon;
//	}
//
//	public int getManaSpent() {
//		fight();
//		return current.spent;
//	}
//
//	private void fight() {
//		while(!over){
//			recordState();
//			
//			current.applyEffects();
//			enoughtMana = current.wizardAttack();
//			
//			current.applyEffects();
//			current.bossAttack();
//			
//			nextStep();
//		}
//		over = true;
//	}
//
//	private void nextStep() {
//		if(!enoughtMana){
//			tryOtherWay();
//		}
//		else if(current.didWizardWin())
//			wizardWon = over = true;
//		else if( current.didWizardLoose())
//			tryOtherWay();
//		else
//			current.spell = 0;
//	}
//
//	private void recordState() {
//		history.add(new State(current));
//	}
//
//	private void tryOtherWay() {
//		current = lastToChange();
//		undoFrom(current);
//		current.spell++;
//		enoughtMana = true;
//	}
//
//	private void undoFrom(State state) {
//		int currentIndex = history.indexOf(state);
//		for(int i = history.size()-1;i >= currentIndex; i--)
//			history.remove(i);
//	}
//
//	private State lastToChange() {
//		State s = history.get(history.size()-1);
//		for (int i = 2; s.spell == STRONGER_SPELL && !over;i++){
//			int step = history.size()- i;
//			if(step >= 0)
//				s = history.get(step);
//			else
//				over = true;
//		}
//		return s;
//	}
//
//	public String describeHistory() {
//		return history.toString();
//	}
}
