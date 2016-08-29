package adventOfCode.day21;

public abstract class Item {

	public final String name;
	public final int damage;
	public final int armor;

	protected Item(String name, int damage, int armor) {
		this.name = name;
		this.damage = damage;
		this.armor = armor;
	}

	public String toString() {
		return this.getClass().getSimpleName()+" "+name+" "+damage+" "+armor;
	}

	public int hashCode(){
		return name.hashCode() + new Integer(damage).hashCode() + new Integer(armor).hashCode();
	}

	public boolean equals(Object other) {
		return this.getClass().isInstance(other) && equalsValue((Item) other);
	}

	private boolean equalsValue(Item other) {
		return (this.name.equals(other.name)) && (this.damage == other.damage) && (this.armor == other.armor);
	}
	
}