package adventOfCode.day22.old;

import java.util.ArrayList;
import java.util.List;

public class Battle {

	private CharacterRole wizard;
	private CharacterRole boss;
	private CharacterRole winner;
	private boolean over;
	protected List<Spell> activeSpells;

	public Battle(CharacterRole wizard, CharacterRole boss) {
		wizard.setBattle(this);
		this.wizard = wizard.clone();
		this.boss = boss.clone();
		activeSpells = new ArrayList<Spell>();
	}

	public void fight() {
		boolean gameOver = false;
		while(!gameOver){
			gameOver = playRound();
		}
	}

	private boolean playRound() {
		playTurn(wizard,boss);
		if(boss.getHitPoints() <= 0){
			winner = wizard;
			return true;
		}
		playTurn(boss,wizard);
		if(wizard.getHitPoints() <= 0){
			winner = boss;
			return true;
		}
		return false;
	}
	private void playTurn(CharacterRole attacker,CharacterRole defender){
		applySpellsEffects();
		attacker.attack(defender);
	}

	private void applySpellsEffects() {
		for(Spell spell: activeSpells){
			spell.cast(wizard, boss);
		}
	}

	public CharacterRole getWinner() {
		if(!over)
			fight();
		return winner;
	}

	public void receiveSpell(Spell spell) {
		activeSpells.add(spell);
	}

}
