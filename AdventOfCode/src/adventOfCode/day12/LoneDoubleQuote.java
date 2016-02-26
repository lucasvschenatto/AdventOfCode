package adventOfCode.day12;

public class LoneDoubleQuote implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseInMemoryCount();
		context.increaseEncodedCount(2);
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
