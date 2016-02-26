package adventOfCode.day12;

public class Started implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		switch (c){
		case '\"':
			context.setState(new StartingDoubleQuote());
			break;			
		case '\u0000':
			context.increaseEncodedCount(2);
			context.setState(new Finished());
			break;
		default:
			context.setState(new NotExpectedChar(this,c));
		}
	}

}
