package adventOfCode.day22;

public class Wizard implements CharacterRole {
	private int hitPoints;
	private int mana;
	private int armor;
	private Spell spell;
	public Wizard(int hitPoints, int mana, int armor, Spell spell){
		this.hitPoints = hitPoints;
		this.mana  = mana;
		this.armor = armor;
		this.spell = spell;
	}
	@Override
	public int getHitPoints() {
		return hitPoints;
	}

	@Override
	public void defend(int damage) {
		int realDamage = damage-this.armor > 1? damage-this.armor : 1;
		this.hitPoints -= realDamage;
	}

	@Override
	public void attack(CharacterRole enemy) {
		spell.cast(this,enemy);
	}

	@Override
	public CharacterRole clone() {
		return new Wizard(hitPoints, mana, armor, spell);
	}
	
	public boolean equals(Object other){
		return this.getClass().isInstance(other);
	}

}
