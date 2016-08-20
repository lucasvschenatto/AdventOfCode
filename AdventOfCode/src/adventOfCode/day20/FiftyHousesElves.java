package adventOfCode.day20;

public class FiftyHousesElves extends CommonDivisor {

	public FiftyHousesElves(int input) {
		super(input);
	}
	protected int tryElvesFrom(){
		return (int)Math.ceil(input/50.0);
//		return input>50? (int)Math.ceil(input/50.0) : 1;
	}
}
