package adventOfCode.day8;

public class StateContext {
	private StringState current;
	private int inMemoryCount;
	private int encodedCount;
	public StateContext(){
		setState(new Started());
	}
	void setState(final StringState newState){
		current = newState;
	}
	void increaseInMemoryCount(){
		inMemoryCount++;
	}
	public int getInMemoryCount(){
		return inMemoryCount;
	}
	void increaseEncodedCount(int increase){
		encodedCount += increase;
	}
	public int getEncodedCount() {
		return encodedCount;
	}
	public void readChar(final char c){
		current.readChar(this,c);
	}
}
