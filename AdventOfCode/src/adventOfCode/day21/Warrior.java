package adventOfCode.day21;

public interface Warrior extends Cloneable {
	public int getHitPoints();
	public int getDamage();
	public int getArmor();
	public void defend(int damage);
	public void attack(Warrior enemy);
	public Warrior clone();
}
