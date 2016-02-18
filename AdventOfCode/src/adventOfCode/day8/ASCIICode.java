package adventOfCode.day8;

public class ASCIICode implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		if ("0123456789abcdef".contains(String.valueOf(c)))
			context.setState(new FirstHexa());
		else
			context.setState(new NotExpectedChar(this,c));
	}

}
