package adventOfCode.day22.old;

public class Recharge extends GenericSpell {
	private int mana;
	public Recharge() {
		super(229,5);
		this.mana = 101;
	}
	public int getDamage(){return 0;}
	public int getHeal()  {return 0;}
	public int getArmor() {return 0;}
	public int getMana()  {return mana;}
	public void cast(CharacterRole author, CharacterRole enemy) {

	}
}
