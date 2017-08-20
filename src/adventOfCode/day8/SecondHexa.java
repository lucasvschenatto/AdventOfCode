package adventOfCode.day8;

public class SecondHexa implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseInMemoryCount();
		context.increaseEncodedCount(1);
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
