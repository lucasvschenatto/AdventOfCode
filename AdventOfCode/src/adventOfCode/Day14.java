package adventOfCode;

public class Day14 {
	private int speed;
	private int energy;
	private int rest;
	public Day14(String reindeerStats){
		String[] words = reindeerStats.split(" ");
		speed = Integer.valueOf(words[3]);
		energy = Integer.valueOf(words[6]);
		rest = Integer.valueOf(words[13]);
	}
	private int move(int time){
		return 0;
	}
	private int rest(int time){
		return 0;
	}
	public int fly(int time) {
		if(time>energy){
			int a = (speed*energy);
			int b = a+rest;
			return time/b;
		}			
		return speed*time;
	}
}
