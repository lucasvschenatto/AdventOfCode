package adventOfCode.day12;

public class NewLine implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		switch (c){
		case '\"':
			context.setState(new StartingDoubleQuote());
			break;
		case '\u0000':
			context.setState(new Finished());
			break;
		default:
			context.setState(new NotExpectedChar(this,c));
		}
	}

}
