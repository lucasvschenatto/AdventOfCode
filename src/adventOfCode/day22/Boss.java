package adventOfCode.day22;

public class Boss {

	public int health;
	public int damage;

	public Boss(int health, int damage) {
		this.health = health;
		this.damage = damage;
	}
	
	public Boss(Boss other) {
		this.health = other.health;
		this.damage = other.damage;
	}

	public String toString(){
		return "health:"+health+" damage:"+damage;
	}

}
