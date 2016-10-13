package adventOfCode.day22.old;

public class Drain extends GenericSpell{
	private int damage;
	private int heal;
	public Drain() {
		super(73,0);
		this.damage = 2;
		this.heal = 2;
	}
	public int getDamage(){return damage;}
	public int getHeal()  {return heal;}
	public int getArmor() {return 0;}
	public int getMana()  {return 0;}
	public void cast(CharacterRole author, CharacterRole enemy) {

	}
}
