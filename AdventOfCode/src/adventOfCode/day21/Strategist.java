package adventOfCode.day21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Strategist {

	private int pHealth;
	private Boss boss;
	private boolean strategyFound;
	private Item[] itens;
	private int gold;

	public Strategist(int pHealth, Boss boss) {
		this.pHealth = pHealth;
		this.boss = boss;
	}
	
	public Item[] getItems(){
		if(!strategyFound)
			findCheaper();
		return itens;
	}

	public int getGold(){
		if(!strategyFound)
			findCheaper();
		return gold;
	}
	private void findCheaper() {
		Inventory cheaper = new Inventory(Integer.MAX_VALUE);
		allOptions().forEach((inventory)->{
			if(playerWins(inventory))
				if(inventory.gold < cheaper.gold){
				cheaper.weapon = inventory.weapon;
				cheaper.armor  = inventory.armor;
				cheaper.ring1  = inventory.ring1;
				cheaper.ring2  = inventory.ring2;
				cheaper.gold   = inventory.gold;
			}
		});
		itens = inventoryItens(cheaper);
		gold = cheaper.gold;
	}

	private Item[] inventoryItens(Inventory i) {
		List<Item> itens = new ArrayList<Item>();
		if(i.weapon != null)
			itens.add(i.weapon);
		if(i.armor != null)
			itens.add(i.armor);
		if(i.ring1 != null)
			itens.add(i.ring1);
		if(i.ring2 != null)
			itens.add(i.ring2);
		return itens.toArray(new Item[]{});
	}

	private boolean playerWins(Inventory equip) {
		Player player = new Player(pHealth, equip);
		Battle battle = new Battle(player,boss);
		return player.equals(battle.getWinner());
	}

	private Iterable<Inventory> allOptions() {
		Set<Weapon> weapons = Store.getWeapons();
		Set<Inventory> options = new HashSet<Inventory>();
		weapons.forEach((weapon)->options.addAll(optionsForWeapon(weapon, Store.getArmors(), Store.getRings())));
		return options;
	}
	
	private Set<Inventory> optionsForWeapon(Weapon weapon, Set<Armor> armors, Set<Ring> rings) {
		Set<Inventory> options = new HashSet<Inventory>();
		options.add(new Inventory(weapon));
		armors.forEach((armor)->{
			options.add(new Inventory(weapon,armor));
			options.addAll(optionsForArmor(weapon,armor,rings));
		});
		return options;
	}
	
	private Set<Inventory> optionsForArmor(Weapon weapon, Armor armor, Set<Ring> rings) {
		Set<Inventory> options = new HashSet<Inventory>();
		rings.forEach((ring)->{
			options.add(new Inventory(weapon,armor,ring));
		});
		return options;
	}
}
