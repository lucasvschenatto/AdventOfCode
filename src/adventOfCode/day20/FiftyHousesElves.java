package adventOfCode.day20;

public class FiftyHousesElves extends Elves {

	public FiftyHousesElves(int house) {
		super(house);
	}
	protected int getMinimumElveNumber(){
//		return (int)Math.ceil(input/50.0);
		return input>50? (int)Math.ceil(input/50.0) : 1;
	}
}
