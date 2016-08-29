package adventOfCode.day20;

public class ElevenPresentsElvesFactory implements ElvesFactory {

	@Override
	public Elves forHouse(int house) {
		return new FiftyHousesElves(house);
	}

}
