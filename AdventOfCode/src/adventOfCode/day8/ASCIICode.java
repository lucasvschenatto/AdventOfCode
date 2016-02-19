package adventOfCode.day8;

public class ASCIICode implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseEncodedCount(1);
		if ("0123456789abcdef".contains(String.valueOf(c)))
			context.setState(new FirstHexa());
		else
			context.setState(new NotExpectedChar(this,c));
	}

}
