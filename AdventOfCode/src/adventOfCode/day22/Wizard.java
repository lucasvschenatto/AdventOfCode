package adventOfCode.day22;

public class Wizard implements CharacterRole {
	private int hitPoints;
	private int mana;
	private int armor;
	private Spell spell;
	private Battle battle;
	public Wizard(int hitPoints, int mana, int armor, Spell spell){
		this.hitPoints = hitPoints;
		this.mana  = mana;
		this.armor = armor;
		this.spell = spell;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void defend(int damage) {
		int realDamage = damage-this.armor > 1? damage-this.armor : 1;
		this.hitPoints -= realDamage;
	}

	public void attack(CharacterRole enemy) {
		spell.cast(this,enemy);
	}
	public void setBattle(Battle battle){
		this.battle = battle;
	}

	public CharacterRole clone() {
		return new Wizard(hitPoints, mana, armor, spell);
	}
	
	
	public boolean equals(Object other){
		return this.getClass().isInstance(other);
	}
	public Battle getBattle() {
		return battle;
	}

}
