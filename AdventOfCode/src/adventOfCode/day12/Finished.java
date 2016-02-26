package adventOfCode.day12;

public class Finished implements StringState {

	@Override
	public void readChar(StateContext context, char c) {
		context.setState(new NotExpectedChar(this,c));
	}

}
