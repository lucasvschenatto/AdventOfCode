package adventOfCode.day21;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Strategist {

	private int pHealth;
	private Boss boss;
	private boolean cheaperStrategyFound;
	private boolean expansivierStrategyFound;
	private boolean optionsLoaded;
	private Set<Inventory> options;
	private Item[] itens;
	private int leastGold;
	private int mostGold;

	public Strategist(int pHealth, Boss boss) {
		this.pHealth = pHealth;
		this.boss = boss;
	}
	
	public Item[] getItems(){
		if(!cheaperStrategyFound)
			findCheaper();
		return itens;
	}

	public int getLeastGold(){
		if(!cheaperStrategyFound)
			findCheaper();
		return leastGold;
	}
	public int getMostGold() {
		if(!expansivierStrategyFound)
			findExpansivier();
		return mostGold;
	}
	private void findExpansivier() {
		loadAllOptions();
		Inventory expansivier = new Inventory(0);
		options.forEach((inventory)->{
			if(bossWins(inventory))
				if(inventory.gold > expansivier.gold){
				expansivier.weapon = inventory.weapon;
				expansivier.armor  = inventory.armor;
				expansivier.ring1  = inventory.ring1;
				expansivier.ring2  = inventory.ring2;
				expansivier.gold   = inventory.gold;
			}
		});
		itens = expansivier.itens();
		mostGold = expansivier.gold;
	}

	private boolean bossWins(Inventory inventory) {
		Warrior warrior = new Warrior(pHealth, inventory);
		Battle battle = new Battle(warrior,boss);
		return boss.equals(battle.getWinner());
	}

	private void findCheaper() {
		loadAllOptions();
		Inventory cheaper = new Inventory(Integer.MAX_VALUE);
		options.forEach((inventory)->{
			if(playerWins(inventory))
				if(inventory.gold < cheaper.gold){
				cheaper.weapon = inventory.weapon;
				cheaper.armor  = inventory.armor;
				cheaper.ring1  = inventory.ring1;
				cheaper.ring2  = inventory.ring2;
				cheaper.gold   = inventory.gold;
			}
		});
		itens = cheaper.itens();
		leastGold = cheaper.gold;
	}

	

	private boolean playerWins(Inventory inventory) {
		Warrior warrior = new Warrior(pHealth, inventory);
		Battle battle = new Battle(warrior,boss);
		return warrior.equals(battle.getWinner());
	}

	private void loadAllOptions() {
		if(!optionsLoaded){
			options = new HashSet<Inventory>();
			Set<Weapon> weapons = Store.getWeapons();
			weapons.forEach((weapon)->options.addAll(optionsForWeapon(weapon, Store.getArmors(), Store.getRings())));
			optionsLoaded = true;
		}
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
			options.add(new Inventory(weapon,ring));
			options.add(new Inventory(weapon,armor,ring));
			options.addAll(optionsForOneRing(weapon, armor, ring, rings));
		});
		return options;
	}

	private Collection<? extends Inventory> optionsForOneRing(Weapon weapon, Armor armor, Ring ring1, Set<Ring> rings) {
		Set<Inventory> options = new HashSet<Inventory>();
		rings.forEach((ring2)->{
			if(!ring2.equals(ring1)){
				options.add(new Inventory(weapon,ring1,ring2));
				options.add(new Inventory(weapon,armor,ring1,ring2));
			}
		});
		return options;
	}
}
