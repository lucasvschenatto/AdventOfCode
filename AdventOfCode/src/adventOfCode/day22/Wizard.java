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
		battle.receiveSpell(spell);
	}
	public void setBattle(Battle battle){
		this.battle = battle;
	}

	public CharacterRole clone() {
		Wizard newWizard = new Wizard(hitPoints, mana, armor, spell);
		newWizard.setBattle(this.battle);
		return newWizard;
	}
	
	
	public boolean equals(Object other){
		return this.getClass().isInstance(other) && equalsBattle((Wizard)other);
	}
	private boolean equalsBattle(Wizard other) {
		if(this.battle == null && other.battle == null)
			return true;
		else
			return this.battle.equals(other.battle);
	}

	public Battle getBattle() {
		return battle;
	}

}
