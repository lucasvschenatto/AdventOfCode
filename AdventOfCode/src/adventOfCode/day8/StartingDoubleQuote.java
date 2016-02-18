package adventOfCode.day8;

public class StartingDoubleQuote implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		switch (c){
		case '\"':
			context.setState(new FinishingDoubleQuote());
			break;
		case '\\':
			context.setState(new Scape());
			break;
		default:
			context.setState(new Letter());
		}
	}

}
