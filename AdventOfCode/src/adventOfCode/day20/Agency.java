package adventOfCode.day20;

public class Agency {
	private int presents;
	private int presentsPerHouse;
	private ElvesFactory factory;
	public Agency(int presents) {
		this(presents,10, new TenPresentsElvesFactory());
	}
	protected Agency(int presents,int presentsPerHouse, ElvesFactory factory){
		this.presents = presents;
		this.presentsPerHouse = presentsPerHouse;
		this.factory = factory;
		
	}

	public int getHouseReceivingAtLeast() {
		int houses = 0;
		while(new Delivery(houses,presentsPerHouse, factory).getPresents() < presents)
			System.out.println(++houses);
		return houses;
	}

}
