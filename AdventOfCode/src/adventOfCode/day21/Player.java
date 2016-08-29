package adventOfCode.day21;

import java.util.Arrays;

public class Player implements Warrior{
	private int hitPoints;
	private int damage;
	private int armor;
	public Player(int hitPoints, Item... itens) {
		this.hitPoints = hitPoints;
		for(Item item : itens){
			damage += item.damage;
			armor  += item.armor;
		}
	}

	public Player(int hitPoints, int damage, int armor) {
		this.hitPoints = hitPoints;
		this.damage    = damage;
		this.armor     = armor;
	}

	public Player(int hitPoints, Inventory equip) {
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

	public void attack(Warrior enemy) {
		enemy.defend(this.damage);
	}
	
	public boolean equals(Object other){
		return this.getClass().isInstance(other) && equalsValue((Player)other);
	}
	
	private boolean equalsValue(Player other) {
		return equalsStats(other);
	}
	
	private boolean equalsStats(Player other) {
		return this.damage == other.damage && this.armor == other.armor;
	}

	public Warrior clone(){
		return new Player(hitPoints,damage,armor);
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + Arrays.toString(new int[]{hitPoints,damage,armor});
	}

}
