package adventOfCode.day22;

public abstract class Spell {
	public abstract int getCost();
	public abstract Spell next(int remainingMana);
	public abstract int cast(Wizard wizard,Boss boss);
	public abstract boolean isActive();
	public abstract void applyEffect(Wizard wizard, Boss boss);
	public abstract Spell clone();
	public static Spell first(){
		return new Missile();
	}
	protected int turns;
}
