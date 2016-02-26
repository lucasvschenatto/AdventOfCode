package adventOfCode.day12;

public class FinishingDoubleQuote implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseEncodedCount(3);
		switch (c){
		case '\n':
			context.setState(new NewLine());
			break;
		case '\u0000':
			context.setState(new Finished());
			break;
		default:
		context.setState(new NotExpectedChar(this,c));
		}
	}

}
