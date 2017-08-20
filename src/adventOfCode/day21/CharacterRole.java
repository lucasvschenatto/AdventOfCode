package adventOfCode.day21;

public interface CharacterRole extends Cloneable {
	public int getHitPoints();
	public int getDamage();
	public int getArmor();
	public void defend(int damage);
	public void attack(CharacterRole enemy);
	public CharacterRole clone();
}
