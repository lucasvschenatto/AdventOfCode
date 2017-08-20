package adventOfCode.day14;

public abstract class Flight {
	public int timeLeft;
	public Flight(int capacity){
		timeLeft = capacity;
	}
	public abstract void fly(int time, Reindeer r);
}
