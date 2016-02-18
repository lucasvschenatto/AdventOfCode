package adventOfCode.day8;

public class Scape implements InMemoryStringState {

	@Override
	public void readChar(StateContext context, char c) {
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
