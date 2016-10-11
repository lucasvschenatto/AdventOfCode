package adventOfCode.day25;

public class CalculationCoder extends Coder {

	public CalculationCoder() {
		super(20151125);
	}

	protected long nextCode(long code) {
		return (code * 252533) % 33554393;
	}

}
