package adventOfCode.day25;

public class AdditionCoder extends Coder {

	public AdditionCoder() {
		super(1);
	}

	protected long nextCode(long code) {
		return ++code;
	}

}
