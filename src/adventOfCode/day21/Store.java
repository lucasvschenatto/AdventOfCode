package adventOfCode.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Store {
	public static final Map<Weapon,Integer> weapons = new HashMap<Weapon,Integer>();
	public static final Map<Armor, Integer> armors  = new HashMap<Armor,Integer>();
	public static final Map<Ring,  Integer> rings   = new HashMap<Ring,Integer>();
	private static boolean loaded = false;
	
	public static Set<Weapon> getWeapons(){
		load();
		return weapons.keySet();
	}
	
	public static Set<Armor> getArmors(){
		load();
		return armors.keySet();
	}
	
	public static Set<Ring> getRings(){
		load();
		return rings.keySet();
	}
	
	public static int priceOf(Item item){
		if(weapons.containsKey(item))
			return weapons.get(item);
		else if(armors.containsKey(item))
			return armors.get(item);
		else if(rings.containsKey(item))
			return rings.get(item);
		else
			return 0;
	}

	private static void loadWeapons() {
		weapons.put( new Weapon("Dagger",   4,0), Integer.valueOf(8 ));
		weapons.put( new Weapon("Shortword",5,0), Integer.valueOf(10));
		weapons.put( new Weapon("Warhammer",6,0), Integer.valueOf(25));
		weapons.put( new Weapon("Longsword",7,0), Integer.valueOf(40));
		weapons.put( new Weapon("Greataxe", 8,0), Integer.valueOf(74));
	}

	private static void loadArmors() {
		armors.put( new Armor("Leather",   0,1), Integer.valueOf(13));
		armors.put( new Armor("Chainmail", 0,2), Integer.valueOf(31));
		armors.put( new Armor("Splintmail",0,3), Integer.valueOf(53));
		armors.put( new Armor("Bandedmail",0,4), Integer.valueOf(75));
		armors.put( new Armor("Platemail", 0,5), Integer.valueOf(102));
	}

	private static void loadRings() {
		rings.put( new Ring("Damage +1", 1,0), Integer.valueOf(25));
		rings.put( new Ring("Damage +2", 2,0), Integer.valueOf(50));
		rings.put( new Ring("Damage +3", 3,0), Integer.valueOf(100));
		rings.put( new Ring("Defense +1",0,1), Integer.valueOf(20));
		rings.put( new Ring("Defense +2",0,2), Integer.valueOf(40));
		rings.put( new Ring("Defense +3",0,3), Integer.valueOf(80));
	}
	private static void load() {
		if(!loaded){
			loadWeapons();
			loadArmors();
			loadRings();
			loaded = true;
		}		
	}
}
