package adventOfCode.day20;

public class Agency {
	private int presents;
	private int presentsPerHouse;
	public Agency(int presents) {
		this(presents,10);
	}
	protected Agency(int presents,int presentsPerHouse){
		this.presents = presents;
		this.presentsPerHouse = presentsPerHouse;
	}

	public int getHouseReceivingAtLeast() {
		int houses = 0;
		while(new Delivery(houses,presentsPerHouse).getPresents() < presents)
			System.out.println(++houses);
		return houses;
	}

}
