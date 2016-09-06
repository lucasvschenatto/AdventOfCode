package adventOfCode.day22;

public interface CharacterRole extends Cloneable {
	public int getHitPoints();
	public void defend(int damage);
	public void attack(CharacterRole enemy);
	public CharacterRole clone();
	public void setBattle(Battle battle);
}
