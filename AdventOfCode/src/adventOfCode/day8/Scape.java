package adventOfCode.day8;

public class Scape implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.increaseEncodedCount(2);
		switch (c){
		case 'x':
			context.setState(new ASCIICode());
			break;
		case '\\':
			context.setState(new SingleBackSlash());
			break;
		case '\"':
			context.setState(new LoneDoubleQuote());
			break;
		default:
			context.setState(new NotExpectedChar(this,c));
		}
	}

}
