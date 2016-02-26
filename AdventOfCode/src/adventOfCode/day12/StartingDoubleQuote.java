package adventOfCode.day12;

public class StartingDoubleQuote implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseEncodedCount(3);
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