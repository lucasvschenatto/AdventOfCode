package adventOfCode;

public class Day1 {
	private int firstUnderground;
	public Day1(){
		firstUnderground = 0;
	}
	public int goToFloor(String commands) {
		int floor = 0;
		if(!commands.isEmpty())
			for(int i = 0; i<commands.length();i++){
				floor += commands.charAt(i)=='(' ? +1 : -1;
				if (floor < 0 && firstUnderground == 0)
					firstUnderground = i+1;
			}
		return floor;
	}

	public int whenEnterTheBasement(String commands) {
		firstUnderground = 0;
		goToFloor(commands);
		return firstUnderground;
	}

}
