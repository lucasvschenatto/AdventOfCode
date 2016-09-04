package adventOfCode.day22;

public class MagicMissile extends GenericSpell{
	private int damage;
	public MagicMissile() {
		super(53,0);
		this.damage = 4;
	}
	
	public int getDamage(){return damage;}
	public int getHeal()  {return 0;}
	public int getArmor() {return 0;}
	public int getMana()  {return 0;}
	public void cast(CharacterRole author, CharacterRole enemy) {

	}
}
