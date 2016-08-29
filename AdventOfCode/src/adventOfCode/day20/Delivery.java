package adventOfCode.day20;

public class Delivery {
	private final int house;
	private final int presentsPerHouse;
	private ElvesFactory elves;
	public Delivery(int house, int presentsPerHouse, ElvesFactory elves) {
		this.house = house;
		this.presentsPerHouse = presentsPerHouse;
		this.elves = elves;
	}
	public int getPresents() {
		I presents = new I(0);
		elves.forHouse(house).getResult().forEach((elve)->presents.value += elve.intValue());
		return presents.value*presentsPerHouse;
	}
	private class I{
		int value;
		I(int value){
			this.value = value;
		}
	}
}
