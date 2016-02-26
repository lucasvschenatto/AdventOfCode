package adventOfCode.day12;

public class NotExpectedChar extends Exception implements StringState{
	private static final long serialVersionUID = 1L;
	NotExpectedChar(StringState previousState,char problematic){
		String previous = previousState.getClass().getSimpleName();		
		System.err.println(String.format("Char '%1$s' not expected after state '%2$s'",problematic,previous));
	}
	public void readChar(StateContext context, char c) {
		context.setState(null);
	}
}
