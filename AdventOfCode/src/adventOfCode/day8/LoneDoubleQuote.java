package adventOfCode.day8;

public class LoneDoubleQuote implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseCount();
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
