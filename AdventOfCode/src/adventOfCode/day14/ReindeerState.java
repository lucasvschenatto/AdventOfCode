package adventOfCode.day14;

public abstract class ReindeerState {
	public int timeLeft;
	public ReindeerState(int capacity){
		timeLeft = capacity;
	}
	public abstract void fly(int time, Reindeer r);
}
