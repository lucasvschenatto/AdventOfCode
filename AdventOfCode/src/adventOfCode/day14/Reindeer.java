package adventOfCode.day14;

public class Reindeer {
	public ReindeerState state;
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
//	private int move(int time){
//		if (time>energy)
//			return speed*energy;
//		else
//			return speed*time;
//	}
	public void fly(int time) {
		state.fly(time, this);
//		int distance = 0;
//		while(time>0){
//			distance += move(time);
//			time = time-energy-rest;
//		}
//		return distance;
	}
	public void increaseDistance(int increment){
		distance = distance + increment;
	}
	public int getDistance(){
		return distance;
	}
	public int getSpeed(){
		return speed;
	}
	public int getEnergy(){
		return energy;
	}
	public int getRest(){
		return rest;
	}
	public void setState(ReindeerState state){
		this.state = state;
	}
	public void addPoint() {
		points++;
	}
	public int getPoints() {
		return points;
	}
}
