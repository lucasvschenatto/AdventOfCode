package adventOfCode.day20;

public class TenPresentsElvesFactory implements ElvesFactory {

	@Override
	public Elves forHouse(int house) {
		return new Elves(house);
	}

}
