package adventOfCode.day20;

public class Delivery {
	private final int house;
	private final int presentsPerHouse;
	public Delivery(int house, int presentsPerHouse) {
		this.house = house;
		this.presentsPerHouse = presentsPerHouse;
	}
	public int getPresents() {
		I presents = new I(0);
		new Elves(house).getResult().forEach((elve)->presents.value += elve.intValue());
		return presents.value*presentsPerHouse;
	}
	private class I{
		int value;
		I(int value){
			this.value = value;
		}
	}
}
