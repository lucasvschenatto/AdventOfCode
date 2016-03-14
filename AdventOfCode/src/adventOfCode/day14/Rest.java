package adventOfCode.day14;

public class Rest extends Flight {
	protected Rest(int capacity) {
		super(capacity);
	}

	@Override
	public void fly(int time, Reindeer r) {
		if (time == 0)
			r.setState(this);			
		else if (time >= timeLeft)
			new Move(r.getEnergy()).fly(time - timeLeft,r);
		else
			timeLeft = timeLeft - time;
	}

}
