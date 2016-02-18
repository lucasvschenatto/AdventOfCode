package adventOfCode.day8;

public class FirstHexa implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		if ("0123456789abcdef".contains(String.valueOf(c)))
			context.setState(new SecondHexa());
		else
			context.setState(new NotExpectedChar(this,c));
	}

}
