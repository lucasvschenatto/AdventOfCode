package adventOfCode.day22;

public class Wizard {

	public int health;
	public int mana;
	public int armor;

	public Wizard(int health, int mana) {
		this.health = health;
		this.mana = mana;
	}
	
	public Wizard(Wizard other) {
		this.health = other.health;
		this.mana = other.mana;
		this.armor = other.armor;
	}

	public String toString(){
		return "health:"+health+" mana:"+mana+" armor:"+armor;
	}
}
