package adventOfCode.day14;

public class Reindeer {
	private int speed;
	private int energy;
	private int rest;
	public Reindeer(String reindeerStats){
		String[] words = reindeerStats.split(" ");
		speed = Integer.valueOf(words[3]);
		energy = Integer.valueOf(words[6]);
		rest = Integer.valueOf(words[13]);
	}
	private int move(int time){
		if (time>energy)
			return speed*energy;
		else
			return speed*time;
	}
	public int fly(int time) {
		int distance = 0;
		while(time>0){
			distance += move(time);
			time = time-energy-rest;
		}
		return distance;
	}
}
