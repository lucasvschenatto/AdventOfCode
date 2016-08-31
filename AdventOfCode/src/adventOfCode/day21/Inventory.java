package adventOfCode.day21;

import java.util.ArrayList;
import java.util.List;

public class Inventory{
	public Weapon weapon;
	public Armor armor;
	public Ring ring1;
	public Ring ring2;
	public int gold;
	public Inventory(int gold) {
		this.gold = gold;
	}
	public Inventory(Weapon weapon) {
		this.weapon = weapon;
		this.gold   = Store.priceOf(weapon);
	}
	public Inventory(Weapon weapon, Armor armor) {
		this.weapon = weapon;
		this.armor  = armor;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(armor);
	}
	public Inventory(Weapon weapon, Ring ring) {
		this.weapon = weapon;
		this.ring1  = ring;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(ring);
	}
	public Inventory(Weapon weapon, Armor armor, Ring ring) {
		this.weapon = weapon;
		this.armor  = armor;
		this.ring1  = ring;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(armor) + Store.priceOf(ring);
	}
	public Inventory(Weapon weapon, Ring ring1, Ring ring2) {
		this.weapon = weapon;
		this.ring1  = ring1;
		this.ring2  = ring2;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(ring1) + Store.priceOf(ring2);
	}
	public Inventory(Weapon weapon, Armor armor, Ring ring1, Ring ring2) {
		this.weapon = weapon;
		this.armor  = armor;
		this.ring1  = ring1;
		this.ring2  = ring2;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(armor) + Store.priceOf(ring1) + Store.priceOf(ring2);
	}
	
	public Item[] itens() {
		List<Item> itens = new ArrayList<Item>();
		if(weapon != null)
			itens.add(weapon);
		if(armor != null)
			itens.add(armor);
		if(ring1 != null)
			itens.add(ring1);
		if(ring2 != null)
			itens.add(ring2);
		return itens.toArray(new Item[]{});
	}
}