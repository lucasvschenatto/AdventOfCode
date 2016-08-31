package adventOfCode.day21;

import java.util.Arrays;

public class Spy implements CharacterRole{
	private int hitPoints;
	private int damage;
	private int armor;
	private int attacks;
	private int defenses;

	public Spy(int hitPoints, int damage, int armor) {
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.armor = armor;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}

	public int getDamage() {
		return damage;
	}

	public int getArmor() {
		return armor;
	}

	public void defend(int damage) {
		int realDamage = damage-this.armor > 1? damage-this.armor : 1;
		this.hitPoints -= realDamage;
		defenses++;
	}
	
	public void attack(CharacterRole enemy) {
		enemy.defend(this.damage);
		attacks++;
	}
	
	public CharacterRole clone(){
		return this;
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + Arrays.toString(new int[]{hitPoints,damage,armor});
	}
	
	public int getAttacks() {
		return attacks;
	}
	
	public int getDefenses() {
		return defenses;
	}
	

}
