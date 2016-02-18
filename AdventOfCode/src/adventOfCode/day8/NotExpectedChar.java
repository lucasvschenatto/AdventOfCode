package adventOfCode.day8;

public class NotExpectedChar extends Exception implements InMemoryStringState{
	private static final long serialVersionUID = 1L;
	private String previous;
	private char problematic;
	NotExpectedChar(InMemoryStringState previousState,char problematic){
		this.previous = previousState.getClass().getSimpleName();
		this.problematic = problematic;
	}
	public void readChar(StateContext context, char c) {
		context.setState(null);
		System.err.println(String.format("Char '%1$s' not expected at count '%2$s' after state '%3$s'",problematic,context.getCount(),previous));
//		this.printStackTrace();
	}
}
