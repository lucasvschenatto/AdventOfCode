package adventOfCode.day22.old;

import java.util.Arrays;

public class Boss implements CharacterRole{
	
	private int hitPoints;
	private int damage;
	private int armor;

	public Boss(int hitPoints,int damage, int armor){
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
	}
	
	public void attack(CharacterRole enemy) {
		enemy.defend(this.damage);
	}
	
	public boolean equals(Object other){
		return this.getClass().isInstance(other) && equalsValue((Boss)other);
	}
	
	private boolean equalsValue(Boss other) {
		return this.damage == other.damage && this.armor == other.armor;
	}

	public CharacterRole clone(){
		return new Boss(hitPoints,damage,armor);
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + Arrays.toString(new int[]{hitPoints,damage,armor});
	}

	public void setBattle(Battle battle) {}

}
