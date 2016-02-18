package adventOfCode.day8;

public class StateContext {
	private InMemoryStringState current;
	private int count;
	public StateContext(){
		setState(new Started());
	}
	void setState(final InMemoryStringState newState){
		current = newState;
	}
	void increaseCount(){
		count++;
	}
	public int getCount(){
		return count;
	}
	public void readChar(final char c){
		current.readChar(this,c);
	}
}
