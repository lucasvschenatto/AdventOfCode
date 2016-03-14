package adventOfCode.day14;

public class Rest extends ReindeerState {

	protected Rest(int capacity) {
		super(capacity);
	}

	@Override
	public void fly(int time, Reindeer r) {
		if (time>=timeLeft){
			r.setState(new Move(r.getEnergy()));
			r.state.fly(time - timeLeft,r);
		}else
			timeLeft = timeLeft - time;
	}

}
