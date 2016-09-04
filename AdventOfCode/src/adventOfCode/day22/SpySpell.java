package adventOfCode.day22;

public class SpySpell implements Spell {
	int damage;
	public SpySpell(int damage){
		this.damage = damage;
	}
	@Override
	public void cast(CharacterRole author, CharacterRole enemy) {
		enemy.defend(damage);
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTurns() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getHeal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return 0;
	}

}
