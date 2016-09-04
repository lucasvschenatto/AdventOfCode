package adventOfCode.day22;

public interface Spell {
	public void cast(CharacterRole author, CharacterRole enemy);

	public int getCost();
	public int getTurns();
	public int getDamage();
	public int getHeal();
	public int getArmor();
	public int getMana();
}
