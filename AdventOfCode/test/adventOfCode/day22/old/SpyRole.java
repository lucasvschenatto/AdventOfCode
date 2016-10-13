package adventOfCode.day22.old;

import java.util.Arrays;

import adventOfCode.day22.old.Battle;
import adventOfCode.day22.old.CharacterRole;

public class SpyRole implements CharacterRole{
	private int hitPoints;
	private int damage;
	private int armor;
	private int attacks;
	private int defenses;
	
	public SpyRole(){
		this(100,100,100);
	}
	public SpyRole(int hitPoints, int damage, int armor) {
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
	public void setBattle(Battle battle) {}
	

}
