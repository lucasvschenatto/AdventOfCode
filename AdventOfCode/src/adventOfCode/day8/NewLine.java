package adventOfCode.day8;

public class NewLine implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		if (c == '\"')
			context.setState(new StartingDoubleQuote());
		else
			context.setState(new NotExpectedChar(this,c));
	}

}
