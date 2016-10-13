package adventOfCode.day22.old;

public class Shield extends GenericSpell {
	private int armor;
	public Shield() {
		super(113,6);
		this.armor = 7;
	}
	public int getDamage(){return 0;}
	public int getHeal()  {return 0;}
	public int getArmor() {return armor;}
	public int getMana()  {return 0;}
	public void cast(CharacterRole author, CharacterRole enemy) {

	}
}
