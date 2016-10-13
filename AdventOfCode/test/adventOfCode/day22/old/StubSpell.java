package adventOfCode.day22.old;

import adventOfCode.day22.old.CharacterRole;
import adventOfCode.day22.old.Spell;

public class StubSpell implements Spell {
	int damage;
	public StubSpell(int damage){
		this.damage = damage;
	}
	@Override
	public void cast(CharacterRole author, CharacterRole enemy) {
		enemy.defend(damage);
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTurns() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}
	@Override
	public int getHeal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return 0;
	}

}
