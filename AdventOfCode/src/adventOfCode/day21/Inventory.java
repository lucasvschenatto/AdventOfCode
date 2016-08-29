package adventOfCode.day21;

public class Inventory{
	public Weapon weapon;
	public Armor armor;
	public Ring ring1;
	public Ring ring2;
	public int gold;
	public Inventory(Weapon weapon) {
		this.weapon = weapon;
		this.gold   = Store.priceOf(weapon);
	}
	public Inventory(Weapon weapon, Armor armor) {
		this.weapon = weapon;
		this.armor  = armor;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(armor);
	}
	public Inventory(Weapon weapon, Armor armor, Ring ring) {
		this.weapon = weapon;
		this.armor  = armor;
		this.gold   = Store.priceOf(weapon) + Store.priceOf(armor) + + Store.priceOf(ring);
	}
	public Inventory(int gold) {
		this.gold = gold;
	}
}