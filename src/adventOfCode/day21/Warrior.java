package adventOfCode.day21;

import java.util.Arrays;

public class Warrior implements CharacterRole{
	private int hitPoints;
	private int damage;
	private int armor;
	public Warrior(int hitPoints, Item... itens) {
		this.hitPoints = hitPoints;
		for(Item item : itens){
			damage += item.damage;
			armor  += item.armor;
		}
	}

	public Warrior(int hitPoints, int damage, int armor) {
		this.hitPoints = hitPoints;
		this.damage    = damage;
		this.armor     = armor;
	}

	public Warrior(int hitPoints, Inventory equip) {
		this.hitPoints = hitPoints;
		if(equip.weapon != null){
			this.damage += equip.weapon.damage;
			this.armor  += equip.weapon.armor;
		}
		if(equip.armor != null){
			this.damage += equip.armor.damage;
			this.armor  += equip.armor.armor;
		}
		if(equip.ring1 != null){
			this.damage += equip.ring1.damage;
			this.armor  += equip.ring1.armor;
		}
		if(equip.ring2 != null){
			this.damage += equip.ring2.damage;
			this.armor  += equip.ring2.armor;
		}
	}

	public int getHitPoints() {
		return hitPoints;
	}
	public int getDamage() {
		return damage;
	}
	
	public int getArmor(){
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
		return this.getClass().isInstance(other) && equalsValue((Warrior)other);
	}
	
	private boolean equalsValue(Warrior other) {
		return equalsStats(other);
	}
	
	private boolean equalsStats(Warrior other) {
		return this.damage == other.damage && this.armor == other.armor;
	}

	public CharacterRole clone(){
		return new Warrior(hitPoints,damage,armor);
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + Arrays.toString(new int[]{hitPoints,damage,armor});
	}

}
