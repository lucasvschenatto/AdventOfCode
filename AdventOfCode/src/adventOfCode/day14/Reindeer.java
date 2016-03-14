package adventOfCode.day14;

public class Reindeer {
	private Flight state;
	private int distance;
	private int points;
	private int speed;
	private int energy;
	private int rest;
	public Reindeer(String reindeerStats){
		String[] words = reindeerStats.split(" ");
		speed = Integer.valueOf(words[3]);
		energy = Integer.valueOf(words[6]);
		rest = Integer.valueOf(words[13]);
		distance = 0;
		state = new Move(energy);
	}
	public void fly(int time) {
		state.fly(time, this);
	}
	public void moveThisMuchTime(int increment){
		distance = distance + (increment * speed);
	}
	public int getDistance(){
		return distance;
	}
	public int getEnergy(){
		return energy;
	}
	public int getRest(){
		return rest;
	}
	public void setState(Flight state){
		this.state = state;
	}
	public void addPoint() {
		points++;
	}
	public int getPoints() {
		return points;
	}
}
