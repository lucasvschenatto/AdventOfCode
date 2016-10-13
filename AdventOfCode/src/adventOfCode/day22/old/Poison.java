package adventOfCode.day22.old;

public class Poison extends GenericSpell {
	private int damage;
	public Poison() {
		super(173,6);
		this.damage = 3;
	}
	public int getDamage(){return damage;}
	public int getHeal()  {return 0;}
	public int getArmor() {return 0;}
	public int getMana()  {return 0;}
	public void cast(CharacterRole author, CharacterRole enemy) {

	}
}
