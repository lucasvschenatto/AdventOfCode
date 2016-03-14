package adventOfCode.day14;

public class Move extends Flight {
	protected Move(int capacity) {
		super(capacity);
	}

	@Override
	public void fly(int time, Reindeer r) {
		if (time == 0)
			r.setState(this);			
		else if (time >= timeLeft){
			r.moveThisMuchTime(timeLeft);
			new Rest(r.getRest()).fly(time - timeLeft,r);
		}else{
			timeLeft = timeLeft - time;
			r.moveThisMuchTime(time);
		}
	}

}
