package adventOfCode.day8;

public class FinishingDoubleQuote implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		if (c == '\n')
			context.setState(new NewLine());
		else
			context.setState(new NotExpectedChar(this,c));
	}

}
