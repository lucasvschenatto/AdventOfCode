package adventOfCode.day22.old;

import adventOfCode.day22.old.Battle;
import adventOfCode.day22.old.CharacterRole;
import adventOfCode.day22.old.Spell;

public class StubBattle extends Battle {
	public StubBattle(CharacterRole player1, CharacterRole player2) {
		super(player1, player2);
	}

	public int numberOfTurnsWithEffect(Spell s) {
		return 0;
	}

	public Iterable<Spell> getSpellsCast() {
		return activeSpells;
	}

}
